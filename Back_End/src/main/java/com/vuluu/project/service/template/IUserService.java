package com.vuluu.project.service.template;

import com.vuluu.project.dto.response.fordetail.DResponseUser;
import javax.servlet.http.HttpServletResponse;

public interface IUserService {

  DResponseUser login(String username, String password, HttpServletResponse response);
}
