package com.vuluu.project.controller;

import com.vuluu.project.dto.response.forlist.LResponseUser;
import com.vuluu.project.service.url.HttpUserPermission;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
  @Autowired
  private HttpUserPermission httpUserPermission;

  @GetMapping("/user-list")
  private String list(Model model) {
    List<LResponseUser> userList = httpUserPermission.getAll();
    model.addAttribute("userList", userList);
    return "user-management";
  }
}
