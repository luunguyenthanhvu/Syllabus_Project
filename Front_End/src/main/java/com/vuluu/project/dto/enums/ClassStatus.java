package com.vuluu.project.dto.enums;

public enum ClassStatus {
  PLANNING("Planning"), OPENING("Opening"), SCHEDULED("Scheduled"), COMPLETED("Complete");
  private final String text;

  private ClassStatus(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return text;
  }
}
