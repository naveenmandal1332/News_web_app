package com.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "users")
public class User {

  @Id
  private ObjectId id;

  @NotBlank(message = "User Name is mandatory!")
  @Indexed(unique = true)
  private String username;

  @NotBlank(message = "Name is mandatory!")
  private String name;

  @NotBlank(message = "Email is mandatory!")
  @Email
  @Indexed(unique = true)
  private String email;

  @NotBlank(message = "Role id is mandatory!")
  private int roleId;

  @NotBlank(message = "Password is mandatory!")
  private String password;

  private String token;
  private String dob;
  private String gender;
  private String address;

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
