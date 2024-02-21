package com.vuluu.project.dto.enums;

public enum UserStatus {
  ACTIVE("ACTIVE"), INACTIVE("INACTIVE");
  private final String text;
  private UserStatus(String text) {
    this.text = text;
  }
  @Override
  public String toString() {
    return text;
  }
}
