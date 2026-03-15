package com.post_hub.iam_service.service.impl;

import com.post_hub.iam_service.mapper.PostMapper;
import com.post_hub.iam_service.model.constants.ApiErrorsMessage;
import com.post_hub.iam_service.model.dto.post.PostDto;
import com.post_hub.iam_service.model.dto.post.PostSearchDto;
import com.post_hub.iam_service.model.entity.Post;
import com.post_hub.iam_service.model.exeption.DataExistExeption;
import com.post_hub.iam_service.model.exeption.NotFoundExeption;
import com.post_hub.iam_service.model.request.post.NewPostRequest;
import com.post_hub.iam_service.model.request.post.PostSearchRequest;
import com.post_hub.iam_service.model.request.post.UpdatePatchRequest;
import com.post_hub.iam_service.model.request.post.UpdatePostRequest;
import com.post_hub.iam_service.model.response.IamResponse;
import com.post_hub.iam_service.model.response.PaginationResponse;
import com.post_hub.iam_service.repository.PostRepository;
import com.post_hub.iam_service.repository.criteries.PostSearchCriteria;
import com.post_hub.iam_service.service.PostService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

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
  public IamResponse<PostDto> updatePatch(@NotNull int postId, @NotNull UpdatePatchRequest updatePatchRequest) {
    postRepository.updateTitleById(updatePatchRequest.getTitle(), postId);
    return IamResponse.createSuccessFul(null);
  }

  @Override
  public IamResponse<PaginationResponse<PostSearchDto>> searchPost(PostSearchRequest request, Pageable pageable) {
    Specification<Post> specification = new PostSearchCriteria(request);
    Page<PostSearchDto> posts = postRepository.findAll(specification, pageable)
        .map(postMapper::toPostSearchDto);
    PaginationResponse<PostSearchDto> response = PaginationResponse.<PostSearchDto>builder()
        .content(posts.getContent())
        .pagination(PaginationResponse.Pagination.builder()
            .total(posts.getTotalElements())
            .limit(pageable.getPageSize())
            .page(posts.getNumber() + 1)
            .pages(posts.getTotalPages())
            .build())
        .build();
    return IamResponse.createSuccessFul(response);
  }


  @Override
  public void softDeletePost(int postId) {
    Post post = postRepository.findByIdAndDeletedFalse(postId)
        .orElseThrow(() -> new NotFoundExeption(ApiErrorsMessage.POST_NOT_FOUND.getMessage(postId)));
    post.setDeleted(true);
    postRepository.save(post);
  }

  @Override
  public IamResponse<PaginationResponse<PostSearchDto>> findAllPosts(Pageable pageable) {
    Page<PostSearchDto> posts = postRepository.findAll(pageable)
        .map(postMapper::toPostSearchDto);
    PaginationResponse<PostSearchDto> paginationResponse = new PaginationResponse<>(
        posts.getContent(),
        new PaginationResponse.Pagination(
            posts.getTotalElements(),
            pageable.getPageSize(),
            posts.getNumber() + 1,
            posts.getTotalPages()
        )
    );
    return IamResponse.createSuccessFul(paginationResponse);
  }
}
