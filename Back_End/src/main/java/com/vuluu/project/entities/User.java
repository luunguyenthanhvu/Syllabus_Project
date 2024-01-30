package com.vuluu.project.entities;

import com.vuluu.project.entities.enums.Gender;
import com.vuluu.project.entities.enums.UserStatus;
import java.time.LocalDateTime;
import java.util.Set;
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
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  private String email;

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

  @OneToMany(mappedBy = "user_id")
  private Set<TrainingProgram> trainingPrograms;

  @OneToMany(mappedBy = "class_user_id")
  private Set<ClassUser> classUser;
}
