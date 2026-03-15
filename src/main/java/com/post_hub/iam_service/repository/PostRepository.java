package com.post_hub.iam_service.repository;

import com.post_hub.iam_service.model.entity.Post;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface PostRepository extends JpaRepository<Post, Integer>, JpaSpecificationExecutor<Post> {
  boolean existsByTitle(String title);

  @Modifying(flushAutomatically = true, clearAutomatically = true)
  @Query(value = "update posts set title=:title where  id =: id",nativeQuery = true)
  @Transactional
  void updateTitleById(@Param("title") String title, @Param("id") Integer id );

  Optional<Post> findByIdAndDeletedFalse(int id);
}
