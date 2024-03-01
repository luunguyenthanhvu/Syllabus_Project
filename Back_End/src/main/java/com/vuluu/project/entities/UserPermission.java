package com.vuluu.project.entities;

import com.vuluu.project.entities.enums.ERole;
import com.vuluu.project.entities.enums.EUserPermission;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserPermission implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  public UserPermission() {
    this.syllabus = EUserPermission.CREATE;
    this.trainingProgram = EUserPermission.CREATE;
    this.classes = EUserPermission.CREATE;
    this.learningMaterial = EUserPermission.CREATE;
    this.userManagement = EUserPermission.CREATE;
  }

  public UserPermission(ERole role, EUserPermission syllabus, EUserPermission trainingProgram,
      EUserPermission classes, EUserPermission learningMaterial, EUserPermission userManagement) {
    this.role = role;
    this.syllabus = syllabus;
    this.trainingProgram = trainingProgram;
    this.classes = classes;
    this.learningMaterial = learningMaterial;
    this.userManagement = userManagement;
  }

  public String getRole() {
    return role.toString();
  }
}
