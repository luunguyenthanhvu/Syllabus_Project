package com.vuluu.project.service.template;

import com.vuluu.project.dto.request.authen.RegisterModel;
import com.vuluu.project.dto.response.fordetail.DResponseUser;
import com.vuluu.project.entities.User;
import javax.servlet.http.HttpServletResponse;

public interface IUserService {
  void createUser(User user);
  DResponseUser login(String email, String password, HttpServletResponse response);

  DResponseUser registerUser(RegisterModel registerModel);
}
