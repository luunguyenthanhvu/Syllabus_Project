package com.vuluu.project.dto.enums;

public enum ERole {
  SUPPER_ADMIN("SUPPER_ADMIN"),ADMIN("ADMIN"),TRAINER("TRAINER");
  private final String text;
  private ERole(final String text) {
    this.text = text;
  }
  @Override
  public String toString() {
    return text;
  }
}
