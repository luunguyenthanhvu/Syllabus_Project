package com.vuluu.project.dto.request.forupdate;

import com.vuluu.project.entities.enums.ERole;
import com.vuluu.project.entities.enums.EUserPermission;
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
public class UPermission {

  private long id;

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
