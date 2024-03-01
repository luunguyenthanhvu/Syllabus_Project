package com.vuluu.project.repositories;

import com.vuluu.project.dto.response.forlist.LResponseUser;
import com.vuluu.project.entities.User;
import com.vuluu.project.entities.UserPermission;
import com.vuluu.project.entities.enums.Gender;
import com.vuluu.project.entities.enums.UserStatus;
import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

  /**
   * get all user in system
   *
   * @return
   */
  @Query("SELECT U FROM User U")
  public List<LResponseUser> findAllBy();

  /**
   * find user by their email
   *
   * @param email
   * @return User
   */
  public User findByEmail(String email);

  /**
   * Find a user by their email ( this user have all info include user permission)
   *
   * @param email
   * @return User
   */
  @Query("SELECT u FROM User u JOIN FETCH u.userPermission WHERE u.email = :email")
  public User findByEmailWithUserPermission(@Param("email") String email);

  /**
   * Update user info except id, role, email
   *
   * @param username
   * @param phone
   * @param dob
   * @param gender
   * @param status
   * @param modifiedBy
   * @param modifiedDate
   * @param id
   * @return rows updated
   */
  @Modifying
  @Transactional
  @Query("UPDATE User u SET u.username = :username, u.phone = :phone, u.dob = :dob, u.gender = :gender, u.status = :status, u.modifiedBy = :modifiedBy, u.modifiedDate = :modifiedDate WHERE u.id = :id")
  public int updateUserInfo(
      @Param("username") String username, @Param("phone") String phone, @Param("dob")
  LocalDateTime dob, @Param("gender") Gender gender, @Param("status") UserStatus status,
      @Param("modifiedBy") User modifiedBy, @Param("modifiedDate") LocalDateTime modifiedDate,
      @Param("id") long id);

  /**
   * Update user permission by their id
   * @param userPermission
   * @param id
   * @return rows updated
   */
  @Modifying
  @Transactional
  @Query("UPDATE User u SET u.userPermission = :userPermission WHERE u.id = :id")
  public int updateUserPermission(@Param("userPermission") UserPermission userPermission,
      @Param("id") long id);

}
