package com.vuluu.project.config;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.Authentication;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

  public static final String AUTHORIZATION_HEADER = "Authorization";
  public static final String DEFAULT_INCLUDE_PATTERN = "/.*";

  @Bean
  public Docket swaggerSpringfoxDocket() {
    Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
        .groupName(AUTHORIZATION_HEADER)
        .produces(Collections.singleton("application/json"))
        .consumes(Collections.singleton("application/json"))
        .ignoredParameterTypes(Authentication.class)
        .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
        .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
        .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
        .securityContexts(Lists.newArrayList(securityContext()))
        .securitySchemes(Lists.newArrayList(apiKey()))
        .useDefaultResponseMessages(false).select()
        .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
        .paths(PathSelectors.any()).build();
    return docket;
  }

  private ApiKey apiKey() {
    return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
  }

  private springfox.documentation.spi.service.contexts.SecurityContext securityContext() {
    return SecurityContext.builder().securityReferences(defaultAuth())
        .forPaths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN)).build();
  }

  List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    return Lists.newArrayList(new SecurityReference("JWT", authorizationScopes));
  }

  private ApiInfo apiInfo() {
    ApiInfo apiInfo = new ApiInfo("Tutorial REST API", "API For Tutorial", "API Ver1.0",
        "Terms of service",
        new Contact("Vu Luu", "https://www.facebook.com/profile.php?id=100048027210422",
            "luunguuenthanhvu123@gmail.com"), "License of API",
        "API license URL", Collections.emptyList());
    return apiInfo;
  }
}
