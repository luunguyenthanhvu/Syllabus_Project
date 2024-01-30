package com.vuluu.project.entities;

import com.vuluu.project.entities.enums.ClassStatus;
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
import net.bytebuddy.asm.Advice.Local;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Class {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToMany(mappedBy = "class_user_id")
  private Set<ClassUser> classUser;

  @ManyToOne
  @JoinColumn(name = "training_program_code")
  private TrainingProgram trainingProgram;

  private String className;
  private String classCode;
  // number of days
  private int duration;

  @Enumerated(EnumType.STRING)
  private ClassStatus status;

  private String location;
  private String fsu;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  @OneToOne
  private User createdBy;
  private LocalDateTime createdDate;
  @OneToOne
  private User modifiedBy;
  private LocalDateTime modifiedDate;
}
