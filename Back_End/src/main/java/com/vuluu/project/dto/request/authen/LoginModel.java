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

  private String email;

  private String password;
}
