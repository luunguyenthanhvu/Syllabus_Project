package com.vuluu.project.service.template;

import com.vuluu.project.dto.request.forupdate.UPermission;
import com.vuluu.project.entities.UserPermission;
import com.vuluu.project.entities.enums.ERole;
import java.util.List;

public interface IUserPermissionService {

  public void createDefaultUserPermission();

  public UserPermission findByRole(ERole role);

  public List<UserPermission> findAll();

  public List<UserPermission> updatePermission(List<UPermission> uPermission);
}
