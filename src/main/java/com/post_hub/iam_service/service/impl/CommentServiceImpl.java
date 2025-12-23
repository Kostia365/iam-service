//package com.post_hub.iam_service.service.impl;
//
//import com.post_hub.iam_service.model.constants.ApiErrorsMessage;
//import com.post_hub.iam_service.model.dto.post.PostDto;
//import com.post_hub.iam_service.model.entity.Post;
//import com.post_hub.iam_service.model.exeption.NotFoundExeption;
//import com.post_hub.iam_service.model.response.IamResponse;
//import com.post_hub.iam_service.repositories.PostRepository;
//import com.post_hub.iam_service.service.PostService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//
//@Service
//@RequiredArgsConstructor
//public class CommentServiceImpl implements PostService {
//  private final PostRepository postRepository;
//
//  @Override
//  public IamResponse<PostDto> getbyId(int postId) {
//    Post post = postRepository.findById(postId)
//        .orElseThrow(() -> new NotFoundExeption(ApiErrorsMessage.POST_NOT_FOUND.getMessage(postId)));
//    return null;
//  }
//}
