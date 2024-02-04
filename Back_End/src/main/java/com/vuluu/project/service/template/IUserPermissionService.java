package com.vuluu.project.service.template;

import com.vuluu.project.entities.UserPermission;
import java.util.List;

public interface IUserPermissionService {

  public void createDefaultUserPermission();

  public UserPermission findByRole(String role);

  public List<UserPermission> findAll();
}
