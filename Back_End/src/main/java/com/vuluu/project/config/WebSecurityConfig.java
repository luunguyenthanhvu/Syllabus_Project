package com.vuluu.project.config;


import com.vuluu.project.config.filters.JWTAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private String[] swaggerAntPatterns = {"/v2/api-docs", "/configuration/ui",
      "/swagger-resources/**",
      "/configuration/security", "/swagger-ui.html", "/webjars/**"};

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers(swaggerAntPatterns);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests()
        // No need authentication.
        .antMatchers("/user/login", "/user/register", "/admin/**", "/role/create").permitAll()
//        .antMatchers("/admin/**").hasAnyAuthority("SUPPER_ADMIN")
        .antMatchers("/product/getall", "/product/get/*", "/department/getall", "/department/get/*")
        .hasAnyAuthority("CUSTOMER")
        // Need authentication.
        .anyRequest().authenticated().and()
        //
        // Add Filter - JWTAuthenticationFilter
        //
        .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
