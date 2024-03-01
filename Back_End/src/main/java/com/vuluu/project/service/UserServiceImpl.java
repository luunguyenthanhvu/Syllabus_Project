package com.vuluu.project.service;

import com.vuluu.project.dto.request.authen.RegisterModel;
import com.vuluu.project.dto.request.forcreate.CRequestUser;
import com.vuluu.project.dto.request.forupdate.URequestUser;
import com.vuluu.project.dto.request.forupdate.UUserPermission;
import com.vuluu.project.dto.response.fordetail.DResponseUser;
import com.vuluu.project.dto.response.forlist.LResponseUser;
import com.vuluu.project.entities.User;
import com.vuluu.project.entities.UserPermission;
import com.vuluu.project.entities.enums.Gender;
import com.vuluu.project.entities.enums.UserStatus;
import com.vuluu.project.repositories.UserRepository;
import com.vuluu.project.service.template.IEmailService;
import com.vuluu.project.service.template.IUserPermissionService;
import com.vuluu.project.service.template.IUserService;
import com.vuluu.project.utils.MyUtils;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  private final int DEFAULT_PAGE_SIZE = 10;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private IUserPermissionService userPermissionService;

  @Autowired
  private IEmailService emailService;

  @Autowired
  private MyUtils myUtils;

  @Override
  @Transactional
  public List<LResponseUser> getAll(int page) {
    Pageable pageable = PageRequest.of(page, DEFAULT_PAGE_SIZE);
    Page<LResponseUser> usersPage = userRepository.findAllBy(pageable)
        .map(user -> mapUserToResponseUser(user));
    return usersPage.getContent();
  }

  @Override
  @Transactional
  public void createUser(User user) {
    if (userRepository.findByEmail(user.getEmail()) == null) {
      userRepository.save(user);
    }
  }

  @Override
  @Transactional
  public DResponseUser login(String email, String password, HttpServletResponse response) {
    User user = userRepository.findByEmailWithUserPermission(email);

    if (user == null || !bCryptPasswordEncoder.matches(password, user.getPassword())) {
      return null;
    }
    Set<GrantedAuthority> grantedAuthorities = getUserAuthorities(user.getUserPermission());

    DResponseUser responseUser = modelMapper.map(user, DResponseUser.class);
    TokenAuthenticationService.addAuthentication(response, user.getEmail(), grantedAuthorities);
    String authorizationString = response.getHeader("Authorization");
    responseUser.setToken(authorizationString);
    return responseUser;
  }

  private static Set<GrantedAuthority> getUserAuthorities(UserPermission userPermission) {
    Set<GrantedAuthority> authorities = new HashSet<>();

    // add authorities from user permission
    authorities.add(new SimpleGrantedAuthority(userPermission.getSyllabus().toString()));
    authorities.add(new SimpleGrantedAuthority(userPermission.getTrainingProgram().toString()));
    authorities.add(new SimpleGrantedAuthority(userPermission.getClasses().toString()));
    authorities.add(new SimpleGrantedAuthority(userPermission.getLearningMaterial().toString()));
    authorities.add(new SimpleGrantedAuthority(userPermission.getUserManagement().toString()));

    return authorities;
  }

  @Override
  @Transactional
  public DResponseUser registerUser(RegisterModel registerModel) {
    // check if account is exist
    if (userRepository.findByEmail(registerModel.getEmail()) != null) {
      return null;
    }
    // else create new user
    User user = new User();
    user.setUsername(registerModel.getUsername());
    user.setEmail(registerModel.getEmail());
    user.setCreatedDate(LocalDateTime.now());
    user.setStatus(UserStatus.ACTIVE);

    // generate new random pass
    String password = myUtils.generateRandomPassword();
    user.setPassword(bCryptPasswordEncoder.encode(password));

    userRepository.save(user);

    // send password to user email
    emailService.sendUserAccount(user.getEmail(), user.getUsername(), password);
    // map to response
    DResponseUser responseUser = modelMapper.map(user, DResponseUser.class);

    return responseUser;
  }

  @Override
  @Transactional
  public DResponseUser createUser(CRequestUser cRequestUser, HttpServletRequest request) {
    //get user info from token
    Authentication authentication = TokenAuthenticationService.getAuthentication(request);
    if (authentication == null) {
      return null;
    }

    // if user not exists
    if (userRepository.findByEmail(cRequestUser.getEmail()) != null) {
      return null;
    }

    String loggedInUserEmail = authentication.getName();
    // get user logged
    User loggedUser = userRepository.findByEmail(loggedInUserEmail);
    User user = modelMapper.map(cRequestUser, User.class);
    // set user create by, modify by
    user.setCreatedBy(loggedUser);
    user.setModifiedBy(loggedUser);

    // set create date, modify date
    user.setCreatedDate(LocalDateTime.now());
    user.setModifiedDate(LocalDateTime.now());

    // generate auto password
    String password = myUtils.generateRandomPassword();
    user.setPassword(bCryptPasswordEncoder.encode(password));

    // set user permission
    user.setUserPermission(userPermissionService.findByRole(
        cRequestUser.getUserType()));

    // save user to database
    userRepository.save(user);

    // send email to user
    emailService.sendUserAccount(user.getEmail(), user.getUsername(), password);

    return modelMapper.map(user, DResponseUser.class);
  }

  @Override
  @Transactional
  public DResponseUser updateUserInfo(URequestUser uRequestUser, HttpServletRequest request) {
    //get user info from token
    Authentication authentication = TokenAuthenticationService.getAuthentication(request);
    if (authentication == null) {
      return null;
    }

    // if user not exists
    if (userRepository.findById(uRequestUser.getId()) == null) {
      return null;
    }

    String loggedInUserEmail = authentication.getName();
    // get user logged
    User loggedUser = userRepository.findByEmail(loggedInUserEmail);
    User user = modelMapper.map(uRequestUser, User.class);

    // update modified date, modified user
    user.setModifiedDate(LocalDateTime.now());
    user.setModifiedBy(loggedUser);

    int rowUpdated = userRepository.updateUserInfo(user.getUsername(), user.getPhone(),
        user.getDob(),
        user.getGender(), user.getStatus(), user.getModifiedBy(), user.getModifiedDate(),
        user.getId());

    if (rowUpdated != 1) {
      return null;
    }

    return modelMapper.map(user, DResponseUser.class);
  }

  @Override
  @Transactional
  public DResponseUser updateUserUserPermission(UUserPermission uUserPermission) {
    // if user not exists
    if (userRepository.findById(uUserPermission.getId()) == null) {
      return null;
    }
    UserPermission userPermission = userPermissionService.findByRole(uUserPermission.getRole());
    int rowUpdated = userRepository.updateUserPermission(userPermission, uUserPermission.getId());

    if (rowUpdated != 1) {
      return null;
    }

    return modelMapper.map(uUserPermission, DResponseUser.class);
  }

  private LResponseUser mapUserToResponseUser(User user) {
    LResponseUser responseUser = new LResponseUser() {
      @Override
      public long getId() {
        return user.getId();
      }

      @Override
      public String getUsername() {
        return user.getUsername();
      }

      @Override
      public String getEmail() {
        return user.getEmail();
      }

      @Override
      public LocalDateTime getDob() {
        return user.getDob();
      }

      @Override
      public Gender getGender() {
        return user.getGender();
      }

      @Override
      public String getRole() {
        return user.getRole();
      }
    };
    return responseUser;
  }
}
