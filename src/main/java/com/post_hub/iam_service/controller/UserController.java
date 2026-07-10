package com.post_hub.iam_service.controller;

import com.post_hub.iam_service.model.constants.ApiLogMessage;
import com.post_hub.iam_service.model.dto.user.UserDto;
import com.post_hub.iam_service.model.request.post.NewUserRequest;
import com.post_hub.iam_service.model.response.IamResponse;
import com.post_hub.iam_service.service.UserService;
import com.post_hub.iam_service.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
  private final UserService userService;

  @GetMapping("/{id}")
  public ResponseEntity<IamResponse<UserDto>> getUserById(@PathVariable(name = "id") Integer userId) {
    log.trace(ApiLogMessage.NAME_OF_CURRENT_METHOD.getValue(), ApiUtils.getMethodName());
    IamResponse<UserDto> response = userService.getUserById(userId);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/create")
  public ResponseEntity<IamResponse<UserDto>> createUser(@RequestBody @Valid NewUserRequest userRequest) {
    log.trace(ApiLogMessage.NAME_OF_CURRENT_METHOD.getValue(), ApiUtils.getMethodName());
    IamResponse<UserDto> response = userService.createUser(userRequest);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<IamResponse<UserDto>> deleteUserById(@PathVariable(name = "id") Integer userId) {
    log.trace(ApiLogMessage.NAME_OF_CURRENT_METHOD.getValue(), ApiUtils.getMethodName());
    return ResponseEntity.ok().build();
  }
}
