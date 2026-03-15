package com.post_hub.iam_service.model.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSearchDto implements Serializable {

  private int id;
  private String title;
  private String content;
  private Integer likes;
  private LocalDateTime created_at;
  private Boolean isDeleted;

}
