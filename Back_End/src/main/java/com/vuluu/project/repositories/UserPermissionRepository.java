package com.vuluu.project.repositories;

import com.vuluu.project.entities.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPermissionRepository extends JpaRepository<UserPermission, Integer> {

  public UserPermission findByRole(String role);
}
