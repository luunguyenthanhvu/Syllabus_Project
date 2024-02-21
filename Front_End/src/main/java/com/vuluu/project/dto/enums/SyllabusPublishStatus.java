package com.vuluu.project.dto.enums;

public enum SyllabusPublishStatus {
  ACTIVE("ACTIVE"),INACTIVE("INACTIVE"),DRAFTING("DRAFTING");
  private final String text;
  private SyllabusPublishStatus(final String text) {
    this.text = text;
  }
  @Override
  public String toString() {
    return text;
  }
}
