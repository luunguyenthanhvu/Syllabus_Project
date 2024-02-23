package com.vuluu.project.service;

import com.vuluu.project.dto.request.forupdate.UPermission;
import com.vuluu.project.entities.UserPermission;
import com.vuluu.project.entities.enums.ERole;
import com.vuluu.project.entities.enums.EUserPermission;
import com.vuluu.project.repositories.UserPermissionRepository;
import com.vuluu.project.service.template.IUserPermissionService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPermissionServiceImpl implements IUserPermissionService {

  @Autowired
  private UserPermissionRepository userPermissionRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public void createDefaultUserPermission() {
    List<UserPermission> userPermissionList = userPermissionRepository.findAll();
    // check if exits
    if (userPermissionList.size() != 0) {
      return;
    }
    for (int i = 1; i <= 3; i++) {
      UserPermission userPermission = new UserPermission();
      switch (i) {
        case 1:
          userPermission.setRole(ERole.SUPPER_ADMIN);
          userPermission.setSyllabus(EUserPermission.FULL_ACCESS);
          userPermission.setTrainingProgram(EUserPermission.FULL_ACCESS);
          userPermission.setClasses(EUserPermission.FULL_ACCESS);
          userPermission.setLearningMaterial(EUserPermission.FULL_ACCESS);
          userPermission.setUserManagement(EUserPermission.FULL_ACCESS);
          break;
        case 2:
          userPermission.setRole(ERole.ADMIN);
          break;
        case 3:
          userPermission.setRole(ERole.TRAINER);
          break;
      }
      userPermissionRepository.save(userPermission);
    }
  }

  @Override
  public UserPermission findByRole(ERole role) {
    return userPermissionRepository.findByRole(role);
  }

  @Override
  public List<UserPermission> findAll() {
    return userPermissionRepository.findAll();
  }

  @Override
  public List<UserPermission> updatePermission(List<UPermission> uPermission) {
    uPermission.forEach(
        n -> userPermissionRepository.save(modelMapper.map(n, UserPermission.class)));

    return userPermissionRepository.findAll();
  }
}
