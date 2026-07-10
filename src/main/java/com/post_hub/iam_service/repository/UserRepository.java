package com.post_hub.iam_service.repository;

import com.post_hub.iam_service.model.entity.Users;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users, Integer> {
  boolean existsByUsername(@NotNull String username);

  boolean existsByEmail(@NotNull String email);
}
