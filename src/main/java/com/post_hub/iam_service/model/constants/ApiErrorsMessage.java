package com.post_hub.iam_service.model.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApiErrorsMessage {
  POST_NOT_FOUND("Post with ID: %s not found"),
  POST_ALREADY_EXIST("Post with title: '%s' already exist"),
  USER_NOT_FOUND_BY_ID("Users with ID: %s not found"),

  LOGIN_ALREADY_USED("User with this email already exist"),
  USERNAME_ALREADY_EXIST("User with this login already exist");
  private final String message;

  public String getMessage(Object... args) {
    return String.format(message, args);
  }

}
