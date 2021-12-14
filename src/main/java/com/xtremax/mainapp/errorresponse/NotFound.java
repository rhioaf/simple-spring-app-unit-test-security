package com.xtremax.mainapp.errorresponse;

public class NotFound {
  private String message;

  public NotFound(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
