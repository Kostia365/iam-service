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

  public static final String ID_FIELD = "id";
  public static final String TITLE_NAME_FIELD = "title";
  public static final String CONTENT_NAME_FIELD = "content";
  public static final String LIKES_NAME_FIELD = "likes";
  public static final String DELETED_FIELD = "deleted";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(nullable = false)
  private String title;
  @Column(nullable = false, length = 500)
  private String content;
  @Column(nullable = false, updatable = false)
  private LocalDateTime created_at;
  @Column(nullable = false)
  private LocalDateTime updated_at;
  @Column(nullable = false, columnDefinition = "integer default 0")
  private int likes = 0;

  @PrePersist
  protected void onCreate() {
    this.created_at = LocalDateTime.now();
  }

  @Column(nullable = false)
  private Boolean deleted = false;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "author_id", nullable = false)
  private Users author;
}
