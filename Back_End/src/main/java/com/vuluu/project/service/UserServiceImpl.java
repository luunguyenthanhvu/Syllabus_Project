package com.vuluu.project.service;

import com.vuluu.project.dto.request.authen.RegisterModel;
import com.vuluu.project.dto.response.fordetail.DResponseUser;
import com.vuluu.project.entities.User;
import com.vuluu.project.entities.UserPermission;
import com.vuluu.project.repositories.UserRepository;
import com.vuluu.project.service.template.IEmailService;
import com.vuluu.project.service.template.IUserService;
import com.vuluu.project.utils.MyUtils;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  private IEmailService emailService;
  @Autowired
  private MyUtils myUtils;

  @Override
  public void createUser(User user) {
    if (userRepository.findByEmail(user.getEmail()) == null) {
      userRepository.save(user);
    }
  }

  @Override
  public DResponseUser login(String email, String password, HttpServletResponse response) {
    User user = userRepository.findByEmailWithUserPermission(email);

    if (user == null || !bCryptPasswordEncoder.matches(password, user.getPassword())) {
      return null;
    }
    Set<GrantedAuthority> grantedAuthorities = getUserAuthorities(user.getUserPermission());
//    Set<Role> roles = user.getRoles();
//    roles.forEach(role -> {
//      grantedAuthorities.add(new SimpleGrantedAuthority(role.getName().toString()));
//    });
    DResponseUser responseUser = modelMapper.map(user, DResponseUser.class);
    TokenAuthenticationService.addAuthentication(response, user.getUsername(), grantedAuthorities);
    String authorizationString = response.getHeader("Authorization");
    responseUser.setToken(authorizationString);
    return responseUser;
  }

  private static Set<GrantedAuthority> getUserAuthorities(UserPermission userPermission) {
    Set<GrantedAuthority> authorities = new HashSet<>();

    // Thêm quyền hạn dựa trên UserPermission
    authorities.add(new SimpleGrantedAuthority(userPermission.getSyllabus().toString()));
    authorities.add(new SimpleGrantedAuthority(userPermission.getTrainingProgram().toString()));
    authorities.add(new SimpleGrantedAuthority(userPermission.getClasses().toString()));
    authorities.add(new SimpleGrantedAuthority(userPermission.getLearningMaterial().toString()));
    authorities.add(new SimpleGrantedAuthority(userPermission.getUserManagement().toString()));

    return authorities;
  }

  @Override
  public DResponseUser registerUser(RegisterModel registerModel) {
    // check if account is exist
    if (userRepository.findByEmail(registerModel.getEmail()) != null) {
      return null;
    }
    // else create new user
    User user = new User();
    user.setUsername(registerModel.getUsername());
    user.setEmail(registerModel.getEmail());

    // generate new random pass
    String password = myUtils.generateRandomPassword();
    user.setPassword(bCryptPasswordEncoder.encode(password));

    userRepository.save(user);

    // send password to user email
    emailService.sendPasswordToEmail(registerModel.getEmail(), password);
    // map to response
    DResponseUser responseUser = modelMapper.map(user, DResponseUser.class);

    return responseUser;
  }
}
