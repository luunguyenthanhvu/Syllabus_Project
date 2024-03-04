package com.vuluu.project.dto.request.forcreate;

import com.vuluu.project.dto.enums.ERole;
import com.vuluu.project.dto.enums.Gender;
import com.vuluu.project.dto.enums.UserStatus;
import java.time.LocalDateTime;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CRequestUser {

  /**
   * User permission (SUPPER_ADMIN, ADMIN,TRAINER)
   */
  @Enumerated(EnumType.STRING)
  private ERole userType;

  /**
   * Account username
   */
  private String username;

  /**
   * Account email
   */
  private String email;

  /**
   * Account phone
   */
  private String phone;

  /**
   * Account dob
   */
  private LocalDateTime dob;

  /**
   * Account gender (MALE/FEMALE)
   */
  @Enumerated(EnumType.STRING)
  private Gender gender;

  /**
   * Account status (ACTIVE/INACTIVE)
   */
  @Enumerated(EnumType.STRING)
  private UserStatus status;
}
