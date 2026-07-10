package com.post_hub.iam_service.model.exception;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}
