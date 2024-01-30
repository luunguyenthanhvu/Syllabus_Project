package com.vuluu.project.entities;

import com.vuluu.project.entities.enums.TrainingProgramStatus;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader.Strategy;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TrainingProgram {

  @Id
  @Column(name = "training_program_code")
  private String trainingProgramCode;

  private String name;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  private LocalDateTime startTime;
  // number of days
  private int duration;
  private String topicCode;

  @Enumerated(EnumType.STRING)
  private TrainingProgramStatus status;

  @OneToOne
  private User createdBy;
  private LocalDateTime createdDate;
  @OneToOne
  private User modifiedBy;
  private LocalDateTime modifiedDate;

  @OneToMany(mappedBy = "training_program_syllabus")
  private Set<TrainingProgramSyllabus> trainingProgramSyllabus;
}
