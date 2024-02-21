package com.vuluu.project.config;

import com.vuluu.project.config.interceptors.SecurityInterceptor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  private final String[] excludeResources = {"/user/login", "/resources/**", "/static/**",
      "/css/**", "/js/**", "/icon/**"};

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new SecurityInterceptor())
        .excludePathPatterns(excludeResources);
  }

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT);
    return modelMapper;
  }
}
