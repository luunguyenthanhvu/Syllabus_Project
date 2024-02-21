package com.vuluu.project.service.url;

import com.vuluu.project.service.url.env.UrlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUrl {

  @Autowired
  private UrlProperties urlProperties;

  private static final String LOGIN = "user.login";

  public String login() {
    return urlProperties.getProperty(LOGIN);
  }
}
