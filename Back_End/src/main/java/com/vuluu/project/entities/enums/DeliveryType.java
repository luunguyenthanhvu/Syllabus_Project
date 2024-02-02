package com.vuluu.project.entities.enums;

public enum DeliveryType {
  ASSIGNMENT("ASSIGNMENT"), CONCEPT("CONCEPT"), GUIDE("GUIDE"), TEST("TEST"), EXAM("EXAM"), SEMINAR(
      "SEMINAR");
  private final String text;

  private DeliveryType(final String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return text;
  }
}