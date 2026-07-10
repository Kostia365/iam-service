package com.post_hub.iam_service.service.impl;

import com.post_hub.iam_service.mapper.UserMapper;
import com.post_hub.iam_service.model.constants.ApiErrorsMessage;
import com.post_hub.iam_service.model.dto.user.UserDto;
import com.post_hub.iam_service.model.entity.Users;
import com.post_hub.iam_service.model.exception.DataExistException;
import com.post_hub.iam_service.model.exception.NotFoundException;
import com.post_hub.iam_service.model.request.post.NewUserRequest;
import com.post_hub.iam_service.model.response.IamResponse;
import com.post_hub.iam_service.repository.UserRepository;
import com.post_hub.iam_service.service.UserService;
import jakarta.persistence.NoResultException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public IamResponse<UserDto> getUserById(@NotNull Integer userId) {
    Users user = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException(ApiErrorsMessage.USER_NOT_FOUND_BY_ID.getMessage(userId)));
    UserDto userDto = userMapper.toUserDto(user);
    return IamResponse.createSuccessFul(userDto);
  }

  @Override
  public IamResponse<UserDto> createUser(NewUserRequest newUserRequest) {
    if (userRepository.existsByEmail(newUserRequest.getEmail())) {
      throw new DataExistException(ApiErrorsMessage.LOGIN_ALREADY_USED.getMessage(newUserRequest.getEmail()));
    }
    if (userRepository.existsByUsername(newUserRequest.getUsername())) {
      throw new DataExistException(ApiErrorsMessage.USERNAME_ALREADY_EXIST.getMessage(newUserRequest.getUsername()));
    }
    Users user = userMapper.createUser(newUserRequest);
    Users savedUser = userRepository.save(user);
    UserDto userDto = userMapper.toUserDto(savedUser);

    return IamResponse.createSuccessFul(userDto);
  }

  @Override
  public IamResponse<UserDto> updateUser(Integer userId, NewUserRequest newUserRequest) {
    if (userRepository.existsByEmail(newUserRequest.getEmail())) {
      Users user = userMapper.createUser(newUserRequest);
      Users savedUser = userRepository.save(user);
      UserDto userDto = userMapper.toUserDto(savedUser);

      return IamResponse.updatedSuccessFul(userDto);
    } else {
      throw new NotFoundException(ApiErrorsMessage.USER_NOT_FOUND_BY_LOGIN.getMessage(userId));
    }
  }

  @Override
  public IamResponse<UserDto> deleteUser(Integer userId) {
    Users user = userRepository.findById(userId).orElseThrow(NoResultException::new);
    userRepository.delete(user);

    return null;
  }
}
