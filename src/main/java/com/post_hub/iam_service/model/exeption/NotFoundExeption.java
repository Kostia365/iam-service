package com.post_hub.iam_service.model.exeption;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class NotFoundExeption extends RuntimeException {
    public NotFoundExeption(String message) {
      super(message);
  }
}
