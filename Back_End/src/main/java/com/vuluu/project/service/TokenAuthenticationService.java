package com.vuluu.project.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class TokenAuthenticationService {

  static final long EXPIRATION_TIME = 864_000_000; // 10 days
  static final String SECRET = "ThisIsASecret";
  static final String TOKEN_PREFIX = "Bearer";
  static final String HEADER_STRING = "Authorization";
  private static Set<GrantedAuthority> grantedAuthorities = null;

  public static void addAuthentication(HttpServletResponse res, String email,
      Set<GrantedAuthority> grantedAuthorities) {
    String JWT = Jwts.builder().setSubject(email)
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).signWith(
            SignatureAlgorithm.HS512, SECRET).compact();
    res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    TokenAuthenticationService.grantedAuthorities = grantedAuthorities;
  }

  public static Authentication getAuthentication(HttpServletRequest request) {
    String token = request.getHeader(HEADER_STRING);
    if (token != null) {
      // parse the token.
      String email = Jwts.parser().setSigningKey(SECRET)
          .parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody().getSubject();
      return email != null ?
          new UsernamePasswordAuthenticationToken(email, null,
              TokenAuthenticationService.grantedAuthorities) : null;
    }
    return null;
  }
}
