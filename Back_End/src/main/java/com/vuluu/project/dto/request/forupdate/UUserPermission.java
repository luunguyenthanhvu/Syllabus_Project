package com.vuluu.project.dto.request.forupdate;

import com.vuluu.project.entities.enums.ERole;
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
public class UUserPermission {

  /**
   * Update user id
   */
  private long id;

  /**
   * User permission (SUPPER_ADMIN, ADMIN,TRAINER)
   */
  @Enumerated(EnumType.STRING)
  private ERole role;
}
