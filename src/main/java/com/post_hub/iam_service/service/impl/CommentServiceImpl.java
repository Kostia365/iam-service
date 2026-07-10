package com.post_hub.iam_service.service.impl;

import com.post_hub.iam_service.model.constants.ApiErrorsMessage;
import com.post_hub.iam_service.model.dto.post.PostDto;
import com.post_hub.iam_service.model.dto.post.PostSearchDto;
import com.post_hub.iam_service.model.entity.Post;
import com.post_hub.iam_service.model.exeption.NotFoundExeption;
import com.post_hub.iam_service.model.request.post.NewPostRequest;
import com.post_hub.iam_service.model.request.post.PostSearchRequest;
import com.post_hub.iam_service.model.request.post.UpdatePatchRequest;
import com.post_hub.iam_service.model.request.post.UpdatePostRequest;
import com.post_hub.iam_service.model.response.IamResponse;
import com.post_hub.iam_service.model.response.PaginationResponse;
import com.post_hub.iam_service.repository.PostRepository;
import com.post_hub.iam_service.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
  private final PostRepository postRepository;

  @Override
  public IamResponse<PostDto> getbyId(int postId) {
    Post post = postRepository.findById(postId)
        .orElseThrow(() -> new NotFoundExeption(ApiErrorsMessage.POST_NOT_FOUND.getMessage(postId)));
    return null;
  }

  @Override
  public IamResponse<PostDto> createPost(NewPostRequest postRequest) {
    return null;
  }

  @Override
  public IamResponse<PostDto> updatePost(int postId, UpdatePostRequest UpdatepostRequest) {
    return null;
  }

  @Override
  public IamResponse<PostDto> updatePatch(int postId, UpdatePatchRequest UpdatePatchRequest) {
    return null;
  }

  @Override
  public IamResponse<PaginationResponse<PostSearchDto>> searchPost(PostSearchRequest request, Pageable pageable) {
    return null;
  }

  @Override
  public void softDeletePost(int postId) {

  }

  @Override
  public IamResponse<PaginationResponse<PostSearchDto>> findAllPosts(Pageable pageable) {
    return null;
  }

  @Override
  public void createComment(String commentContent) {

  }
}
