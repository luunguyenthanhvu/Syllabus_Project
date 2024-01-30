package com.vuluu.project.entities;

import com.vuluu.project.entities.enums.ERole;
import com.vuluu.project.entities.enums.EUserPermission;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserPermission {
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
}
