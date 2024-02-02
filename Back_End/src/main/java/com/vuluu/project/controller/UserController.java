package com.vuluu.project.controller;

import com.vuluu.project.dto.request.authen.LoginModel;
import com.vuluu.project.dto.response.fordetail.DResponseUser;
import com.vuluu.project.service.template.IUserService;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "User", description = "User API's")
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private IUserService userService;

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResponseEntity<Object> loginUser(@RequestBody LoginModel loginModel,
      HttpServletResponse response) {
    String username = loginModel.getUsername();
    String password = loginModel.getPassword();
    DResponseUser user = userService.login(username, password, response);
    if (user != null) {
      return ResponseEntity.ok().body(user);
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
    }
  }
}
