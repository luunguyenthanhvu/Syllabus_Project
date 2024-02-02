package com.vuluu.project.service.template;

import com.vuluu.project.dto.request.authen.RegisterModel;
import com.vuluu.project.dto.response.fordetail.DResponseUser;
import javax.servlet.http.HttpServletResponse;

public interface IUserService {

  DResponseUser login(String email, String password, HttpServletResponse response);

  DResponseUser registerUser(RegisterModel registerModel);
}
