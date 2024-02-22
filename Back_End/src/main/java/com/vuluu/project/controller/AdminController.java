package com.vuluu.project.controller;

import com.vuluu.project.dto.request.forcreate.CRequestUser;
import com.vuluu.project.service.template.IUserService;
import io.swagger.annotations.Api;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
      BindingResult bindingResult) {
    return null;
  }
}
