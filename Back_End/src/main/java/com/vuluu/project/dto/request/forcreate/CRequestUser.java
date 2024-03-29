package com.vuluu.project.dto.request.forcreate;

import com.vuluu.project.entities.enums.ERole;
import com.vuluu.project.entities.enums.Gender;
import com.vuluu.project.entities.enums.UserStatus;
import java.time.LocalDateTime;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
  @NotBlank
  @Enumerated(EnumType.STRING)
  private ERole userType;

  /**
   * Account username
   */
  @NotBlank
  @Size(min = 6, max = 50, message = "user name must between 6 and 50")
  private String username;

  /**
   * Account email
   */
  @Email
  private String email;

  /**
   * Account phone
   */
  @NotBlank(message = "Phone number is required")
  @Size(min = 10, max = 15, message = "Phone number length must between 10 and 15")
  @Pattern(regexp = "\\d{10,15}", message = "Phone number must contain only digits")
  private String phone;

  /**
   * Account dob
   */
  @NotBlank(message = "Date of birth is required")
  @NotNull(message = "Date of birth is required")
  @Past(message = "Date of birth must be in the past")
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
