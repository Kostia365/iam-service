package com.post_hub.iam_service.service;

import com.post_hub.iam_service.model.dto.post.PostDto;
import com.post_hub.iam_service.model.dto.post.PostSearchDto;
import com.post_hub.iam_service.model.request.post.NewPostRequest;
import com.post_hub.iam_service.model.request.post.PostSearchRequest;
import com.post_hub.iam_service.model.request.post.UpdatePatchRequest;
import com.post_hub.iam_service.model.request.post.UpdatePostRequest;
import com.post_hub.iam_service.model.response.IamResponse;
import com.post_hub.iam_service.model.response.PaginationResponse;
import org.springframework.data.domain.Pageable;

public interface CommentService {
  IamResponse<PostDto> getbyId(int postId);

  IamResponse<PostDto> createPost(NewPostRequest postRequest);

  IamResponse<PostDto> updatePost(int postId, UpdatePostRequest UpdatepostRequest);

  IamResponse<PostDto> updatePatch(int postId, UpdatePatchRequest UpdatePatchRequest);

  IamResponse<PaginationResponse<PostSearchDto>> searchPost(PostSearchRequest request, Pageable pageable);

  void softDeletePost(int postId);

  IamResponse<PaginationResponse<PostSearchDto>> findAllPosts(Pageable pageable);

  void createComment(String commentContent);

}
