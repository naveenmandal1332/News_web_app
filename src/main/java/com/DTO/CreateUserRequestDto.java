package com.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateUserRequestDto {
  @NotEmpty(message = "Username is mandatory!")
  @Size(min = 8, max = 30, message = "The length of username must be between 8 and 30 characters.")
  private String username;

  @NotEmpty(message = "Email is mandatory!")
  @Email
  private String email;

  // @NotEmpty(message = "Paswword is mandatory!")
  @Size(min = 8, max = 16, message = "The length of username must be between 8 and 16 characters.")
  private String password;

  @NotEmpty(message = "Name is mandatory!")
  private String name;

  @NotNull(message = "RoleId is mandatory!")
  private int roleId;

  private String dob;
  private String gender;
  private String address;

  // Getter and Setter to access and modify the values:

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public int getRole() {
    return roleId;
  }

  public void setRole(int roleId) {
    this.roleId = roleId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
