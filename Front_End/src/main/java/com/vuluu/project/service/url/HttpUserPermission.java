package com.vuluu.project.service.url;

import com.vuluu.project.dto.response.forlist.LResponseUser;
import com.vuluu.project.service.http.HttpBase;
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
    LResponseUser[] responseUsers = httpBase.getFromAPI(userManagementUrl.GetUserList(),
        LResponseUser[].class);
    return Arrays.asList(responseUsers);
  }
}
