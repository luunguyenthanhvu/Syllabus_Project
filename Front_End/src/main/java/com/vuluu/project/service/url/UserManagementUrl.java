package com.vuluu.project.service.url;

import com.vuluu.project.service.url.env.UrlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManagementUrl {

  @Autowired
  private UrlProperties urlProperties;

  /**
   * Get user list
   */
  private static final String GET_ALL = "admin.get.user_list";

  /**
   * Add new User
   */
  private static final String ADD_NEW = "admin.add.new_user";

  public String getUserList() {
    return urlProperties.getProperty(GET_ALL);
  }

  public String addNewUser() {
    return urlProperties.getProperty(ADD_NEW);
  }
}
