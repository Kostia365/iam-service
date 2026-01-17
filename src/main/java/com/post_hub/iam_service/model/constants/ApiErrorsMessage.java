package com.post_hub.iam_service.model.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor (access = AccessLevel.PRIVATE)
public enum ApiErrorsMessage {
  POST_NOT_FOUND("Post with ID: %s not found"),
  POST_ALREADY_EXIST("Post with title: '%s' already exist")
  ;
  private final String message;
  public String getMessage(Object... args){
    return String.format(message, args);
  }

}
