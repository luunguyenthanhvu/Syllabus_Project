package com.vuluu.project.config.interceptors;

import com.vuluu.project.service.http.Token;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityInterceptor extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    String url = request.getRequestURI();
    System.out.println(url);
    if (Token.API_KEY.equals("None")) {
      response.sendRedirect("/user/login");
    }
//        else {
//            if(!url.contains("/customer/list") && !Token.ROLE.contains(ERole.ADMIN)) {
//                throw new ForbiddenException("403 Forbidden");
//            }
//        }
    return true;
  }
}
