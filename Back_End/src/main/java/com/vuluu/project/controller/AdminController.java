package com.vuluu.project.controller;

import com.vuluu.project.dto.request.forcreate.CRequestUser;
import com.vuluu.project.dto.request.forupdate.URequestUser;
import com.vuluu.project.dto.response.fordetail.DResponseUser;
import com.vuluu.project.service.template.IUserService;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Admin", description = "Admin API's")
@RestController
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  private IUserService userService;

  @PostMapping(value = "/add/new-user")
  public ResponseEntity<DResponseUser> addNewUser(@Valid @RequestBody CRequestUser cRequestUser,
      BindingResult bindingResult, HttpServletRequest request) {
    // check validate
    if (bindingResult.hasErrors()) {
      return ResponseEntity.badRequest().body(null);
    }

    // create new user
    DResponseUser dResponseUser = userService.createUser(cRequestUser, request);

    return ResponseEntity.ok(dResponseUser);
  }

  @PutMapping(value = "/update/user-info/{id}")
  public ResponseEntity<DResponseUser> updateUserInfo(
      @Valid @RequestBody URequestUser uRequestUser, BindingResult bindingResult,
      HttpServletRequest request) {
    // check validate
    if (bindingResult.hasErrors()) {
      return ResponseEntity.badRequest().body(null);
    }
    DResponseUser dResponseUser = userService.updateUser(uRequestUser, request);
    return ResponseEntity.ok(dResponseUser);
  }
}
