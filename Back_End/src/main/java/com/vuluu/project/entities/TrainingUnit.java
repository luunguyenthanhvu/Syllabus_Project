package com.vuluu.project.entities;

import java.io.Serializable;
import javax.persistence.Column;
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
public class TrainingUnit implements Serializable {

  @Id
  private String unitCode;
  @Column(unique = true)
  private String unitName;
  private int dayNumber;
  @ManyToOne
  @JoinColumn(name = "topic_code")
  private Syllabus syllabus;

}
