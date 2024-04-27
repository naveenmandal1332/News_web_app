package com.Utils;

public class GeneratePassword {
  String password;
  int noOfUpperCase;
  int noOfLowerCase;
  int noOfdigit;
  int noOfSpecialCharacter;

  // Getter
  public String getNewPassword() {
    return password;
  }

  // Setter
  public void setNewPassword(int noOfUpperCase, int noOfLowerCase, int noOfdigit, int noOfSpecialCharacter) {

    this.noOfUpperCase = noOfUpperCase;
    this.noOfLowerCase = noOfLowerCase;
    this.noOfdigit = noOfdigit;
    this.noOfSpecialCharacter = noOfSpecialCharacter;

    this.password = generateNewPassword(noOfUpperCase, noOfLowerCase, noOfdigit, noOfSpecialCharacter);
  }

  // Password generation:
  private String generateNewPassword(int noOfUpperCase, int noOfLowerCase, int noOfdigit, int noOfSpecialCharacter) {
    char[] upperCaseLetter = getAlphabet("Uppercase");
    char[] lowerCaseLetter = getAlphabet("Lowercase");
    char[] digit = getDigit();
    char[] specialCharacter = getSpecialCharacter();

    String newPassword = "";

    if (noOfLowerCase > 0 && noOfLowerCase < lowerCaseLetter.length)
      newPassword += addLetter(noOfLowerCase, lowerCaseLetter);

    if (noOfdigit > 0 && noOfdigit < digit.length)
      newPassword += addLetter(noOfdigit, digit);

    if (noOfSpecialCharacter > 0 && noOfSpecialCharacter < specialCharacter.length)
      newPassword += addLetter(noOfSpecialCharacter, specialCharacter);

    if (noOfUpperCase > 0 && noOfUpperCase < upperCaseLetter.length)
      newPassword += addLetter(noOfUpperCase, upperCaseLetter);

    return newPassword;
  }

  private String addLetter(int n, char arr[]) {
    String str = "";
    for (int i = 0; i < n; i++) {
      int ind = (int) (Math.random() * arr.length); // corrected the Math.random() usage
      str += arr[ind];
    }
    return str;
  }

  private char[] getAlphabet(String type) {
    char[] alphabet = new char[26];
    char ch = type.equalsIgnoreCase("Lowercase") ? 'a' : 'A';
    for (int i = 0; i < 26; i++) {
      alphabet[i] = (char) (ch + i);
    }
    return alphabet;
  }

  private char[] getDigit() {
    char[] digit = new char[10];
    for (int i = 48; i <= 57; i++)
      digit[i - 48] = (char) (i);
    return digit;
  }

  private char[] getSpecialCharacter() {
    char specialChar[] = new char[15];
    for (int i = 33; i <= 47; i++) {
      specialChar[i - 33] = (char) (i);
    }
    return specialChar;
  }
}