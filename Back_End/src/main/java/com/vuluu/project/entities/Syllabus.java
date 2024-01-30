package com.vuluu.project.entities;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Syllabus {
  @Id
  private String topicCode;
  @Column(unique = true)
  private String topicName;
  private String technicalGroup;
  private String version;
  private int trainingAudience;
  private String topicOutline;
  @OneToMany(mappedBy = "syllabus")
  private Set<TrainingMaterial> trainingMaterials;
  private String trainingPrinciples;
  private String priority;
}
