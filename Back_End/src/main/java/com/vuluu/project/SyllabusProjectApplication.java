package com.vuluu.project;

import com.vuluu.project.entities.User;
import com.vuluu.project.entities.UserPermission;
import com.vuluu.project.service.template.IUserPermissionService;
import com.vuluu.project.service.template.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SyllabusProjectApplication implements CommandLineRunner {

  @Autowired
  private IUserService userService;

  @Autowired
  private IUserPermissionService userPermissionService;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public static void main(String[] args) {
    SpringApplication.run(SyllabusProjectApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    // create user permission
    userPermissionService.createDefaultUserPermission();

    List<UserPermission> userPermissionList = userPermissionService.findAll();
    // create a super admin account
//    User user = new User("vuluu", "vuluu123@gmail.com",
//        bCryptPasswordEncoder.encode("vuluu123"), userPermissionList.get(0)
//    );

    for (int i = 0; i < 100; i++) {
      User user = new User("vuluu" + i, "vuluu123" + i + "@gmail.com",
          bCryptPasswordEncoder.encode("vuluu123"), userPermissionList.get(0)
      );
      userService.createUser(user);
    }

//    userService.createUser(user);
  }
}
