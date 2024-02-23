package com.vuluu.project.dto.request.authen;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RegisterModel {

  /**
   * user name for register
   */
  @Size(min = 5, max = 50, message = "Length of username should be from 5 to 50")
  private String username;

  /**
   * email for login and system send password
   */
  @Email
  private String email;
}
