package com.post_hub.iam_service.service;

import com.post_hub.iam_service.model.dto.post.PostDto;
import com.post_hub.iam_service.model.request.post.NewPostRequest;
import com.post_hub.iam_service.model.request.post.UpdatePostRequest;
import com.post_hub.iam_service.model.response.IamResponse;
import jakarta.validation.constraints.NotNull;

public interface PostService {
  IamResponse<PostDto> getbyId(@NotNull int postId);

  IamResponse<PostDto> createPost(@NotNull NewPostRequest postRequest);

  IamResponse<PostDto> updatePost(@NotNull int postId, @NotNull UpdatePostRequest UpdatepostRequest);
}
