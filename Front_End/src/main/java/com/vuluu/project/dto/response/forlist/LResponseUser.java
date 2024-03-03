package com.vuluu.project.dto.response.forlist;

import com.vuluu.project.dto.enums.Gender;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LResponseUser {
  private long id;
  private String username;
  private String email;
  private LocalDateTime dob;
  private Gender gender;
  private String role;
}
