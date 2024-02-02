package com.vuluu.project.entities;

import com.vuluu.project.entities.enums.DeliveryType;
import com.vuluu.project.entities.enums.TrainingFormat;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class TrainingContent implements Serializable {

  @Id
  private String content;
  @OneToMany(mappedBy = "trainingContent")
  private Set<LearningObjective> learningObjectives;
  @Enumerated(EnumType.STRING)
  private DeliveryType deliveryType;
  private int duration;
  @Enumerated(EnumType.STRING)
  private TrainingFormat trainingFormat;
  private String note;

  @ManyToOne
  @JoinColumn(name = "unit_code")
  private TrainingUnit trainingUnit;
}
