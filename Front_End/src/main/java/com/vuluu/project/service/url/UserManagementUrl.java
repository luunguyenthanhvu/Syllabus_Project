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

  public String GetUserList() {
    return urlProperties.getProperty(GET_ALL);
  }
}
