package com.post_hub.iam_service.service.impl;

import com.post_hub.iam_service.model.constants.ApiErrorsMessage;
import com.post_hub.iam_service.model.dto.post.PostDto;
import com.post_hub.iam_service.model.entity.Post;
import com.post_hub.iam_service.model.exeption.NotFoundExeption;
import com.post_hub.iam_service.model.response.IamResponse;
import com.post_hub.iam_service.repositories.PostRepository;
import com.post_hub.iam_service.service.PostService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;

  @Override
  public IamResponse<PostDto> getbyId(@NotNull int postId) {
    Post post = postRepository.findById(postId)
        .orElseThrow(() -> new NotFoundExeption(ApiErrorsMessage.POST_NOT_FOUND.getMessage(postId)));
    // Maps entity fields to data transfer object
    PostDto postDto = PostDto.builder()
        .id(post.getId())
        .title(post.getTitle())
        .likes(post.getLikes())
        .content(post.getContent())
        .created_at(post.getCreated_at())
        .build();
    return IamResponse.createSuccessFull(postDto);
  }
}
