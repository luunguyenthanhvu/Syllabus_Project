package com.vuluu.project.repositories;

import com.vuluu.project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

  public User findByUsername(String username);

  public User findByEmail(String email);

  @Query("SELECT u FROM User u JOIN FETCH u.userPermission WHERE u.email = :email")
  public User findByEmailWithUserPermission(@Param("email") String email);
}
