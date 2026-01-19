package com.post_hub.iam_service.controller;

import com.post_hub.iam_service.model.constants.ApiLogMessage;
import com.post_hub.iam_service.model.dto.post.PostDto;
import com.post_hub.iam_service.model.dto.post.PostSearchDto;
import com.post_hub.iam_service.model.request.post.NewPostRequest;
import com.post_hub.iam_service.model.request.post.UpdatePatchRequest;
import com.post_hub.iam_service.model.request.post.UpdatePostRequest;
import com.post_hub.iam_service.model.response.IamResponse;
import com.post_hub.iam_service.model.response.PaginationResponse;
import com.post_hub.iam_service.service.PostService;
import com.post_hub.iam_service.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
  private final PostService postService;

  @GetMapping("/{id}")
  public ResponseEntity<IamResponse<PostDto>> getPostByID(
      @PathVariable(name = "id") Integer postId) {
    log.trace(ApiLogMessage.NAME_OF_CURRENT_METHOD.getValue(), ApiUtils.getMethodName());

    IamResponse<PostDto> response = postService.getbyId(postId);
    return ResponseEntity.ok(response);

  }

  @PostMapping("/create")
  public ResponseEntity<IamResponse<PostDto>> createPost(@RequestBody @Valid NewPostRequest postRequest) {
    log.trace(ApiLogMessage.NAME_OF_CURRENT_METHOD.getValue(), ApiUtils.getMethodName());

    IamResponse<PostDto> response = postService.createPost(postRequest);
    return ResponseEntity.ok(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<IamResponse<PostDto>> updatePostById(@PathVariable(name = "id") Integer postId, @RequestBody @Valid UpdatePostRequest request) {
    log.trace(ApiLogMessage.NAME_OF_CURRENT_METHOD.getValue(), ApiUtils.getMethodName());
    IamResponse<PostDto> updatedPost = postService.updatePost(postId, request);
    return ResponseEntity.ok(updatedPost);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> softDeletePostById(@PathVariable(name = "id") Integer postId) {
    log.trace(ApiLogMessage.NAME_OF_CURRENT_METHOD.getValue(), ApiUtils.getMethodName());

    postService.softDeletePost(postId);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/all")
  public ResponseEntity<IamResponse<PaginationResponse<PostSearchDto>>> getAllPosts(
      Pageable pageable) {
    log.trace(ApiLogMessage.NAME_OF_CURRENT_METHOD.getValue(), ApiUtils.getMethodName());
    IamResponse<PaginationResponse<PostSearchDto>> response = postService.findAllPosts(pageable);
    return ResponseEntity.ok(response);
  }
  @PatchMapping("/{id}")
  public ResponseEntity<IamResponse<PostDto>> updatePostValue(@PathVariable(name = "id") Integer postId, @RequestBody @Valid UpdatePatchRequest patchRequest){
    IamResponse<PostDto> updatedPost = postService.updatePatch(postId, patchRequest);
    return ResponseEntity.ok(updatedPost);
  }
}
