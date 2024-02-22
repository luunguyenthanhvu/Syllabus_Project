package com.vuluu.project.controller;

import com.vuluu.project.dto.request.forcreate.CRequestUser;
import com.vuluu.project.dto.response.fordetail.DResponseUser;
import com.vuluu.project.service.template.IUserService;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Admin", description = "Admin API's")
@RestController
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  private IUserService userService;

  @RequestMapping(value = "/add-new-user", method = RequestMethod.POST)
  public ResponseEntity<Object> addNewUser(@Valid @RequestBody CRequestUser cRequestUser,
      BindingResult bindingResult, HttpServletRequest request) {
    // check validate
    if (bindingResult.hasErrors()) {
      return ResponseEntity.badRequest().body("Invalid request data");
    }

    // create new user
    DResponseUser dResponseUser = userService.createUser(cRequestUser, request);

    if (dResponseUser != null) {
      return ResponseEntity.ok(dResponseUser);
    } else {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create user");
    }
  }
}
