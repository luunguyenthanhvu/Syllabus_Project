package com.vuluu.project.service.template;

import com.vuluu.project.dto.request.forupdate.UPermission;
import com.vuluu.project.dto.response.forlist.LResponseUser;
import com.vuluu.project.dto.response.forlist.LUserPermission;
import com.vuluu.project.entities.UserPermission;
import com.vuluu.project.entities.enums.ERole;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface IUserPermissionService {

  /**
   * Create a default permission
   */
  public void createDefaultUserPermission();

  /**
   * Find user permission by their role
   * @param role
   * @return UserPermission
   */
  public UserPermission findByRole(ERole role);

  /**
   * find all userPermission
   * @return List<UserPermission>
   */
  public List<UserPermission> findAll();

  /**
   * Update user permission
   * @param uPermission
   * @return List<UserPermission> updated
   */
  public List<UserPermission> updatePermission(List<UPermission> uPermission);

  /**
   * response list user permission
   * @return
   */
  @Query("select u from UserPermission u")
  public List<LUserPermission> getAll();
}
