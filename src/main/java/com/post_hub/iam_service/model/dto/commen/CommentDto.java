package com.post_hub.iam_service.model.dto.commen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto implements Serializable {

  private Long id;
  private Long postId;
  private Long authorId;
  private String content;
  private LocalDateTime createdAt = LocalDateTime.now();
  private Boolean isDeleted = false;
}
