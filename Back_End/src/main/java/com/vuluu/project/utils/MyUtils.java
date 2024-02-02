package com.vuluu.project.utils;

import java.security.SecureRandom;
import org.springframework.stereotype.Service;

@Service
public class MyUtils {

  private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
  private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String DIGITS = "0123456789";
  private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-=_+[]{}|;:'\",.<>/?";

  public String generateRandomPassword() {
    SecureRandom random = new SecureRandom();
    StringBuilder password = new StringBuilder();

    String allCharacters =
        LOWERCASE_CHARACTERS + UPPERCASE_CHARACTERS + DIGITS + SPECIAL_CHARACTERS;

    for (int i = 0; i < 8; i++) {
      int randomIndex = random.nextInt(allCharacters.length());
      password.append(allCharacters.charAt(randomIndex));
    }

    return password.toString();
  }
}
