package com.post_hub.iam_service.controller;

import com.post_hub.iam_service.service.CommentService;
import com.post_hub.iam_service.service.impl.TimeSetedCommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {
  private final CommentService defaultcommentService;
  private final CommentService advancCommentService;
  @Autowired
  public CommentController(CommentService defaultcommentService,
                           @Qualifier("advancedCommentService") CommentService advancCommentService) {
    this.defaultcommentService = defaultcommentService;
    this.advancCommentService = advancCommentService;
  }


  @PostMapping("/addDefaultComment")
  public ResponseEntity<String> addDefaultComment(@RequestBody Map<String, Object> requestBody
  ) {
    String content = (String) requestBody.get("content");
    defaultcommentService.createComment(content);

    return new ResponseEntity<>("default comment created:" + content, HttpStatus.OK);
  }

  @PostMapping("/createdatecomm")
  public ResponseEntity<String> swichToCommTimeSerw(@RequestBody Map<String, Object> requestBody
  ) {
    String content = (String) requestBody.get("content");
    defaultcommentService.createComment(content);

    return new ResponseEntity<>("Comment with time created:" + content, HttpStatus.OK);
  }

}
