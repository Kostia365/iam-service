package com.post_hub.iam_service.service.impl;

import com.post_hub.iam_service.service.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service("advancedCommentService")
public class TimeSetedCommentServiceImpl implements CommentService {
  private final List<String> comments = new ArrayList<>();

  @Override
  public void createComment(String commentContent) {
    String advancedComment = "[" + LocalDateTime.now() + "] " + commentContent.toUpperCase();
    comments.add(commentContent);
    System.out.println("Advanced comment: " + advancedComment);
  }
}
