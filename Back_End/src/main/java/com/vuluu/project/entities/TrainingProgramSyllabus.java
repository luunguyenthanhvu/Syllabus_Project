package com.vuluu.project.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class TrainingProgramSyllabus {

  @Id
  @ManyToOne
  @JoinColumn(name = "syllabus_topic_code")
  private Syllabus syllabus;

  @Id
  @ManyToOne
  @JoinColumn(name = "training_program_code")
  private TrainingProgram trainingProgram;

  private String sequence;
}
