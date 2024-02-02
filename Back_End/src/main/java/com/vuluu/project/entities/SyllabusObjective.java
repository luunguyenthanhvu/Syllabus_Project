package com.vuluu.project.entities;

import java.io.Serializable;
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
public class SyllabusObjective implements Serializable {

  @Id
  @ManyToOne
  @JoinColumn(name = "topic_code")
  private Syllabus syllabus;

  @Id
  @ManyToOne
  @JoinColumn(name = "objective_code")
  private LearningObjective learningObjective;
}
