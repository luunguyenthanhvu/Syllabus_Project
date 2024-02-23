package com.vuluu.project.dto.request.authen;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class LoginModel {

  /**
   * Login user email
   */
  private String email;

  /**
   * Login user password
   */
  private String password;
}
