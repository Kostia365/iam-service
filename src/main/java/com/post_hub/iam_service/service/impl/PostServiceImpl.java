package com.post_hub.iam_service.service.impl;

import com.post_hub.iam_service.mapper.PostMapper;
import com.post_hub.iam_service.model.constants.ApiErrorsMessage;
import com.post_hub.iam_service.model.dto.post.PostDto;
import com.post_hub.iam_service.model.entity.Post;
import com.post_hub.iam_service.model.exeption.NotFoundExeption;
import com.post_hub.iam_service.model.response.IamResponse;
import com.post_hub.iam_service.repositories.PostRepository;
import com.post_hub.iam_service.service.PostService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;
  private final PostMapper postMapper;

  @Override
  public IamResponse<PostDto> getbyId(@NotNull int postId) {
    Post post = postRepository.findById(postId)
        .orElseThrow(() -> new NotFoundExeption(ApiErrorsMessage.POST_NOT_FOUND.getMessage(postId)));
    PostDto postDto = postMapper.toPostDto(post);
    return IamResponse.createSuccessFull(postDto);
  }
}
