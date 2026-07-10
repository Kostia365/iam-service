package com.post_hub.iam_service.repository;

import com.post_hub.iam_service.model.entity.Comment;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
  void deleteById(@NotNull Integer id);

  boolean existsByIsDeletedAndId(boolean isDeleted, Integer id);

  boolean existsById(@NotNull Integer id);

}
