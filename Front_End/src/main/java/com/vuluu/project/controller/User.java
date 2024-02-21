package com.vuluu.project.controller;

import com.vuluu.project.dto.form.LoginForm;
import com.vuluu.project.dto.response.fordetail.DResponseUser;
import com.vuluu.project.service.HttpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class User {

  @Autowired
  private HttpUser httpUser;

  @GetMapping("/login")
  public String getLogin(Model model, String error, String logout) {
    // check error
    if (error != null) {
      model.addAttribute("error", "Your email and password is invalid");
    }

    if (logout != null) {
      model.addAttribute("message", "You have been logged out successfully.");
    }

    model.addAttribute("loginForm", new LoginForm());
    return "login";
  }

  @PostMapping("/login")
  public String postLogin(@ModelAttribute("loginModel") LoginForm loginForm) {
    DResponseUser dResponseUser = httpUser.login(loginForm);

    if (dResponseUser == null) {
      return "redirect:/user/login";
    }

    return "redirect:/user/test";
  }

  @GetMapping("/test")
  public String test() {
    return "test";
  }
}
