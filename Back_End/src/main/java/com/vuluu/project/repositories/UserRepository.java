package com.vuluu.project.repositories;

import com.vuluu.project.entities.User;
import com.vuluu.project.entities.enums.Gender;
import com.vuluu.project.entities.enums.UserStatus;
import java.time.LocalDateTime;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

  public User findByUsername(String username);

  public User findByEmail(String email);

  @Query("SELECT u FROM User u JOIN FETCH u.userPermission WHERE u.email = :email")
  public User findByEmailWithUserPermission(@Param("email") String email);

  @Modifying
  @Transactional
  @Query("UPDATE User u SET u.username = :username, u.phone = :phone, u.dob = :dob, u.gender = :gender, u.status = :status, u.modifiedBy = :modifiedBy, u.modifiedDate = :modifiedDate WHERE u.id = :id")
  public int updateUserInfo(
      @Param("username") String username, @Param("phone") String phone, @Param("dob")
  LocalDateTime dob, @Param("gender") Gender gender, @Param("status") UserStatus status,
      @Param("modifiedBy") User modifiedBy, @Param("modifiedDate") LocalDateTime modifiedDate,
      @Param("id") long id);
}
