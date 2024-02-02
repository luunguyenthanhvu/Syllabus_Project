package com.vuluu.project.entities;

import com.vuluu.project.entities.enums.SyllabusPublishStatus;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
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
public class Syllabus implements Serializable {

  @Id
  @Column(name = "topic_code")
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
  @Enumerated(EnumType.STRING)
  private SyllabusPublishStatus publishStatus;
  @OneToOne
  private User createdBy;
  private LocalDateTime createdDate;
  @OneToOne
  private User modifiedBy;
  private LocalDateTime modifiedDate;
  @OneToMany(mappedBy = "syllabus")
  private Set<TrainingUnit> trainingUnits;
  @OneToMany(mappedBy = "syllabus")
  private Set<SyllabusObjective> syllabusObjectives;
}
