package com.post_hub.iam_service.model.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto implements Serializable {
  private int id;
  private String title;
  private String content;
  private int likes;
  private LocalDateTime created_at;

}
