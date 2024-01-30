package com.vuluu.project.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ClassUser implements Serializable {

  @Id
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User userId;

  @Id
  @ManyToOne
  @JoinColumn(name = "class_id")
  private Class classId;

  private String userType;
}
