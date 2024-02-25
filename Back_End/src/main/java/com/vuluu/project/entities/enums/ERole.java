package com.vuluu.project.entities.enums;

public enum ERole {
  SUPPER_ADMIN("SUPER_ADMIN"),ADMIN("ADMIN"),TRAINER("TRAINER");
  private final String text;
  private ERole(final String text) {
    this.text = text;
  }
  @Override
  public String toString() {
    return text;
  }
}
