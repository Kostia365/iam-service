package com.post_hub.iam_service.model.entity;

import com.post_hub.iam_service.model.enums.RegistrationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false, length = 30)
  @Size(min = 3, max = 30)
  private String username;

  @Column(nullable = false, length = 255)
  @Size(min = 8, max = 255)
  private String password;

  @Column(nullable = false, length = 50)
  @Size(min = 5, max = 50)
  private String email;

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt = LocalDateTime.now();

  @Enumerated(EnumType.STRING)
  @Column(name = "registration_status", nullable = false)
  private RegistrationStatus status = RegistrationStatus.ACTIVE;

  @Column(name = "last_login", nullable = false)
  private LocalDateTime lastLogin = LocalDateTime.now();

  @Column(name = "is_deleted", nullable = false)
  private Boolean isDeleted = false;

  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Post> posts;

}