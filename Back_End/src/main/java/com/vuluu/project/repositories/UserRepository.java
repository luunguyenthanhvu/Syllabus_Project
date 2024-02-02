package com.vuluu.project.repositories;

import com.vuluu.project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  public User findByName(String username);
}
