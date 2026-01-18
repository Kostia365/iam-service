package com.post_hub.iam_service.service.impl;

import com.post_hub.iam_service.mapper.PostMapper;
import com.post_hub.iam_service.model.constants.ApiErrorsMessage;
import com.post_hub.iam_service.model.dto.post.PostDto;
import com.post_hub.iam_service.model.entity.Post;
import com.post_hub.iam_service.model.exeption.DataExistExeption;
import com.post_hub.iam_service.model.exeption.NotFoundExeption;
import com.post_hub.iam_service.model.request.post.NewPostRequest;
import com.post_hub.iam_service.model.request.post.UpdatePostRequest;
import com.post_hub.iam_service.model.response.IamResponse;
import com.post_hub.iam_service.repositories.PostRepository;
import com.post_hub.iam_service.service.PostService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;
  private final PostMapper postMapper;

  @Override
  public IamResponse<PostDto> getbyId(@NotNull int postId) {
    Post post = postRepository.findByIdAndDeletedFalse(postId)
        .orElseThrow(() -> new NotFoundExeption(ApiErrorsMessage.POST_NOT_FOUND.getMessage(postId)));
    PostDto postDto = postMapper.toPostDto(post);
    return IamResponse.createSuccessFul(postDto);
  }

  @Override
  public IamResponse<PostDto> createPost(@NotNull NewPostRequest postRequest) {
    if (postRepository.existsByTitle(postRequest.getTitle())) {
      throw new DataExistExeption(ApiErrorsMessage.POST_ALREADY_EXIST.getMessage(postRequest.getTitle()));
    }
    Post post = postMapper.createPost(postRequest);
    Post savedPost = postRepository.save(post);
    PostDto postDto = postMapper.toPostDto(savedPost);
    return IamResponse.createSuccessFul(postDto);
  }

  @Override
  public IamResponse<PostDto> updatePost(@NotNull int postId, @NotNull UpdatePostRequest request) {
    Post post = postRepository.findByIdAndDeletedFalse(postId)
        .orElseThrow(() -> new NotFoundExeption(ApiErrorsMessage.POST_NOT_FOUND.getMessage(postId)));

    postMapper.updatePost(post, request);
    post.setUpdated_at(LocalDateTime.now());
    post = postRepository.save(post);
    PostDto postDto = postMapper.toPostDto(post);
    return IamResponse.createSuccessFul(postDto);
  }

  @Override
  public void softDeletePost(int postId) {
    Post post = postRepository.findByIdAndDeletedFalse(postId)
        .orElseThrow(() -> new NotFoundExeption(ApiErrorsMessage.POST_NOT_FOUND.getMessage(postId)));
    post.setDeleted(true);
    postRepository.save(post);
  }
}
