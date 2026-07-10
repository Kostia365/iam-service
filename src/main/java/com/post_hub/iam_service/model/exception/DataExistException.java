package com.post_hub.iam_service.model.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DataExistException extends RuntimeException {
  public DataExistException(String message) {
    super(message);
  }
}
