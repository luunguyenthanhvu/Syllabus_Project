package com.vuluu.project.dto.response.forlist;

import com.vuluu.project.entities.UserPermission;
import com.vuluu.project.entities.enums.ERole;
import com.vuluu.project.entities.enums.Gender;
import java.time.LocalDateTime;

public interface LResponseUser {
  long getId();
  String getUsername();
  String getEmail();
  LocalDateTime getDob();
  Gender getGender();
  String getRole();
}
