package com.post_hub.iam_service.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(nullable = false)
  private String title;
  @Column(nullable = false, length = 500)
  private String content;
  @Column(nullable = false, updatable = false)
  private LocalDateTime created_at;
  @Column(nullable = false, columnDefinition = "integer default 0")
  private int likes = 0;

  @PrePersist
  protected void onCreate() {
    this.created_at = LocalDateTime.now();
  }
}
