package com.vuluu.project.dto.response.forlist;

import com.vuluu.project.entities.enums.ERole;
import com.vuluu.project.entities.enums.EUserPermission;

public interface LUserPermission {
  long getId();
  ERole getRole();
  EUserPermission getSyllabus();
  EUserPermission getTrainingProgram();
  EUserPermission getClasses();
  EUserPermission getLearningMaterial();
  EUserPermission getUserManagement();
}
