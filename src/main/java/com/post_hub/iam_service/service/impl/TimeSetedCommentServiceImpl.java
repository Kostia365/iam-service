package com.post_hub.iam_service.service.impl;

import com.post_hub.iam_service.model.dto.post.PostDto;
import com.post_hub.iam_service.model.dto.post.PostSearchDto;
import com.post_hub.iam_service.model.request.post.NewPostRequest;
import com.post_hub.iam_service.model.request.post.PostSearchRequest;
import com.post_hub.iam_service.model.request.post.UpdatePatchRequest;
import com.post_hub.iam_service.model.request.post.UpdatePostRequest;
import com.post_hub.iam_service.model.response.IamResponse;
import com.post_hub.iam_service.model.response.PaginationResponse;
import com.post_hub.iam_service.service.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service("advancedCommentService")
public class TimeSetedCommentServiceImpl implements CommentService {
  private final List<String> comments = new ArrayList<>();

  @Override
  public IamResponse<PostDto> getbyId(int postId) {
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
    String advancedComment = "[" + LocalDateTime.now() + "] " + commentContent.toUpperCase();
    comments.add(commentContent);
    System.out.println("Advanced comment: " + advancedComment);
  }
}
