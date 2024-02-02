package com.vuluu.project.dto.response.fordetail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DResponseUser {

  private long id;
  private String username;
  private String token;
}
