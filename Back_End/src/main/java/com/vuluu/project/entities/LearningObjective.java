package com.vuluu.project.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class LearningObjective implements Serializable {

  @Id
  private String code;
  @Column(unique = true)
  private String name;
  private String type;
  private String description;
  @OneToMany(mappedBy = "learningObjective")
  private Set<SyllabusObjective> syllabusObjectives;
  @ManyToOne
  @JoinColumn(name = "training_content")
  private TrainingContent trainingContent;
}
