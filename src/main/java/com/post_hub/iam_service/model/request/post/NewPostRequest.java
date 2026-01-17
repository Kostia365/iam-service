package com.post_hub.iam_service.model.request.post;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewPostRequest implements Serializable {
  @NotBlank(message = "title can not be empty")
  private String title;
  @NotBlank(message = "content can not be empty")
  private String content;
  @NotNull(message = "likes can not be null")
  private int likes;
}
