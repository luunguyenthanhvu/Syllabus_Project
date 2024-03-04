package com.vuluu.project.service;

import com.vuluu.project.dto.request.forcreate.CRequestUser;
import com.vuluu.project.dto.response.fordetail.DResponseUser;
import com.vuluu.project.dto.response.forlist.LResponseUser;
import com.vuluu.project.service.http.HttpBase;
import com.vuluu.project.service.url.UserManagementUrl;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HttpUserPermission {

  @Autowired
  private UserManagementUrl userManagementUrl;

  public List<LResponseUser> getAll() {
    HttpBase<LResponseUser[], LResponseUser[]> httpBase = new HttpBase<>();
    LResponseUser[] responseUsers = httpBase.getFromAPI(userManagementUrl.getUserList(),
        LResponseUser[].class);
    return Arrays.asList(responseUsers);
  }

  public DResponseUser add(CRequestUser cRequestUser) {
    HttpBase<CRequestUser, DResponseUser> httpBase = new HttpBase<>();
    return httpBase.postToAPI(cRequestUser, userManagementUrl.addNewUser(), DResponseUser.class);
  }
}
