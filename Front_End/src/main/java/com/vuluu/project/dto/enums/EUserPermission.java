package com.vuluu.project.dto.enums;

public enum EUserPermission {
  ACCESS_DENIED("ACCESS_DENIED"),VIEW("VIEW"),MODIFY("MODIFY"),CREATE("CREATE"),FULL_ACCESS("FULL_ACCESS");
  private final String text;
  private EUserPermission(final String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return text;
  }
}
