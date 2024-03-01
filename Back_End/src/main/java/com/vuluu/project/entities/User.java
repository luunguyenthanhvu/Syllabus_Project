package com.vuluu.project.entities;

import com.vuluu.project.entities.enums.Gender;
import com.vuluu.project.entities.enums.UserStatus;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String username;
  @Column(unique = true)
  private String email;

  private String password;

  private String phone;

  private LocalDateTime dob;

  @Enumerated(EnumType.STRING)
  private Gender gender;

  @ManyToOne
  @JoinColumn(name = "user_permission_id")
  private UserPermission userPermission;

  @Enumerated(EnumType.STRING)
  private UserStatus status;

  @OneToOne
  private User createdBy;

  private LocalDateTime createdDate;

  @OneToOne
  private User modifiedBy;

  private LocalDateTime modifiedDate;

  @OneToMany(mappedBy = "user")
  private Set<TrainingProgram> trainingPrograms;

  @OneToMany(mappedBy = "user")
  private Set<ClassUser> classUser;

  public User(String username, String email, String password, UserPermission userPermission) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.userPermission = userPermission;
  }

  @Transient
  public String getRole() {
    if (userPermission != null) {
      return userPermission.getRole();
    }
    return null;
  }

}
