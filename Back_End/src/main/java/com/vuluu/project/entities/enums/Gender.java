package com.vuluu.project.entities.enums;

public enum Gender {
  MALE("MALE"), FEMALE("FEMALE");
  private final String text;

  private Gender(final String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return text;
  }
}
