package com.vuluu.project.repositories;

import com.vuluu.project.dto.response.forlist.LUserPermission;
import com.vuluu.project.entities.UserPermission;
import com.vuluu.project.entities.enums.ERole;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserPermissionRepository extends JpaRepository<UserPermission, Integer> {
  @Query("SELECT u FROM UserPermission u")
  public List<LUserPermission> findAllBy();
  public UserPermission findByRole(ERole role);
}
