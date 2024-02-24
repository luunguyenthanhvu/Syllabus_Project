package com.vuluu.project.service;

import com.vuluu.project.dto.form.LoginForm;
import com.vuluu.project.dto.response.fordetail.DResponseUser;
import com.vuluu.project.service.http.HttpBase;
import com.vuluu.project.service.http.Token;
import com.vuluu.project.service.url.UserUrl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("httpUser")
public class HttpUser {

  @Autowired
  private UserUrl userUrl;

  @Autowired
  private ModelMapper modelMapper;

  public DResponseUser login(LoginForm loginForm) {
    HttpBase<LoginForm, DResponseUser> httpBase = new HttpBase<>();
    DResponseUser dResponseUser = httpBase.postToAPI(loginForm, userUrl.login(),
        DResponseUser.class);
    System.out.println(dResponseUser);
    if (dResponseUser != null) {
      Token.API_KEY = dResponseUser.getToken();
      // add role
    }
    return dResponseUser;
  }
}
