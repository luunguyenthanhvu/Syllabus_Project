package com.vuluu.project.service.url.env;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@PropertySource("classpath:url.properties")
@Component
public class UrlProperties {

  @Autowired
  private Environment environment;

  private static final String HOST = "backend.host";

  private String getHost() {
    return environment.getProperty(HOST);
  }

  public String getProperty(String propertyName) {
    return getHost() + environment.getProperty(propertyName);
  }
}
