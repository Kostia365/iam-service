package com.post_hub.iam_service.service;

import com.post_hub.iam_service.model.dto.post.PostDto;
import com.post_hub.iam_service.model.dto.post.PostSearchDto;
import com.post_hub.iam_service.model.request.post.NewPostRequest;
import com.post_hub.iam_service.model.request.post.UpdatePatchRequest;
import com.post_hub.iam_service.model.request.post.UpdatePostRequest;
import com.post_hub.iam_service.model.response.IamResponse;
import com.post_hub.iam_service.model.response.PaginationResponse;
import jakarta.validation.constraints.NotNull;

import org.springframework.data.domain.Pageable;

public interface PostService {
  IamResponse<PostDto> getbyId(@NotNull int postId);

  IamResponse<PostDto> createPost(@NotNull NewPostRequest postRequest);

  IamResponse<PostDto> updatePost(@NotNull int postId, @NotNull UpdatePostRequest UpdatepostRequest);

  IamResponse<PostDto> updatePatch(@NotNull int postId, @NotNull UpdatePatchRequest UpdatePatchRequest);

  void softDeletePost(@NotNull int postId);
  IamResponse<PaginationResponse<PostSearchDto>> findAllPosts(Pageable pageable);
}
