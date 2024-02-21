package com.vuluu.project.dto.enums;

public enum TrainingProgramStatus {
  ACTIVE("ACTIVE"), DE_ACTIVE("DE_ACTIVE");
  private final String text;

  private TrainingProgramStatus(final String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return text;
  }
}
