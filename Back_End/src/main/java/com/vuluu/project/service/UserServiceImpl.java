package com.vuluu.project.service;

import com.vuluu.project.dto.response.fordetail.DResponseUser;
import com.vuluu.project.entities.User;
import com.vuluu.project.repositories.UserRepository;
import com.vuluu.project.service.template.IUserService;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
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

  @Override
  public DResponseUser login(String username, String password, HttpServletResponse response) {
    User user = userRepository.findByName(username);
    if (user == null) {
      return null;
    }
//    if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
//      return null;
//    }
    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//    Set<Role> roles = user.getRoles();
//    roles.forEach(role -> {
//      grantedAuthorities.add(new SimpleGrantedAuthority(role.getName().toString()));
//    });
    DResponseUser responseUser = modelMapper.map(user, DResponseUser.class);
    TokenAuthenticationService.addAuthentication(response, user.getName(), grantedAuthorities);
    String authorizationString = response.getHeader("Authorization");
    responseUser.setToken(authorizationString);
    return responseUser;
  }
}
