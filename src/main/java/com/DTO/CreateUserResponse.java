package com.DTO;

import com.Entity.User;

public class CreateUserResponse {
  private String message;
  private boolean status;
  private User data;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public boolean getStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public User getData() {
    return data;
  }

  public void setData(User data) {
    this.data = data;
  }
}
