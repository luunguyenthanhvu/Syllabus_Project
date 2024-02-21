package com.vuluu.project.dto.response.authen;


import com.vuluu.project.dto.enums.ERole;
import com.vuluu.project.dto.enums.EUserPermission;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserPermissionModel {

  @Enumerated(EnumType.STRING)
  private ERole role;

  @Enumerated(EnumType.STRING)
  private EUserPermission syllabus;

  @Enumerated(EnumType.STRING)
  private EUserPermission trainingProgram;

  @Enumerated(EnumType.STRING)
  private EUserPermission classes;

  @Enumerated(EnumType.STRING)
  private EUserPermission learningMaterial;

  @Enumerated(EnumType.STRING)
  private EUserPermission userManagement;
}
