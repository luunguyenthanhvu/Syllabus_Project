package com.vuluu.project.controller;

import com.vuluu.project.dto.request.forcreate.CRequestUser;
import com.vuluu.project.dto.request.forupdate.UPermission;
import com.vuluu.project.dto.request.forupdate.URequestUser;
import com.vuluu.project.dto.request.forupdate.UUserPermission;
import com.vuluu.project.dto.response.fordetail.DResponseUser;
import com.vuluu.project.entities.UserPermission;
import com.vuluu.project.service.template.IUserPermissionService;
import com.vuluu.project.service.template.IUserService;
import io.swagger.annotations.Api;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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

  @Autowired
  private IUserPermissionService userPermissionService;

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

    DResponseUser dResponseUser = userService.updateUserInfo(uRequestUser, request);
    return ResponseEntity.ok(dResponseUser);
  }

  @PutMapping(value = "/update/user-permission/{id}")
  public ResponseEntity<DResponseUser> updateUserPermission(
      @Valid @RequestBody UUserPermission uUserPermission, BindingResult bindingResult) {
    // check validate
    if (bindingResult.hasErrors()) {
      return ResponseEntity.badRequest().body(null);
    }

    DResponseUser dResponseUser = userService.updateUserUserPermission(uUserPermission);
    return ResponseEntity.ok(dResponseUser);
  }

  @GetMapping(value = "/get/permission-list")
  public ResponseEntity<List<UserPermission>> getListUserPermission() {
    List<UserPermission> userPermissionList = userPermissionService.findAll();
    return ResponseEntity.ok().body(userPermissionList);
  }

  @PutMapping(value = "/update/permission")
  public ResponseEntity<List<UserPermission>> updatePermission(@RequestBody List<UPermission> uPermissionList) {
    List<UserPermission> userPermissionList = userPermissionService.updatePermission(uPermissionList);
    return ResponseEntity.ok().body(userPermissionList);
  }
}
