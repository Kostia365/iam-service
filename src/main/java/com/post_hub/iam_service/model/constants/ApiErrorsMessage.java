package com.post_hub.iam_service.model.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor (access = AccessLevel.PRIVATE)
public enum ApiErrorsMessage {
  POST_NOT_FOUND("Post with ID: {} not found");
  private final String message;
  public String getMessage(Object... args){
    return String.format(message, args);
  }
}
