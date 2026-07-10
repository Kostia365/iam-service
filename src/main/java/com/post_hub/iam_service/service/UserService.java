package com.post_hub.iam_service.service;

import com.post_hub.iam_service.model.dto.user.UserDto;
import com.post_hub.iam_service.model.request.post.NewUserRequest;
import com.post_hub.iam_service.model.response.IamResponse;
import jakarta.validation.constraints.NotNull;

public interface UserService {
  IamResponse<UserDto> getUserById(@NotNull Integer userId);

  IamResponse<UserDto> createUser(@NotNull NewUserRequest newUserRequest);

  IamResponse<UserDto> updateUser(@NotNull Integer userId, @NotNull NewUserRequest newUserRequest);

  IamResponse<UserDto> deleteUser(@NotNull Integer userId);
}
