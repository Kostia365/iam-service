package com.post_hub.iam_service.model.exeption;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DataExistExeption extends RuntimeException{
  public DataExistExeption(String message) {
    super(message);
  }
}
