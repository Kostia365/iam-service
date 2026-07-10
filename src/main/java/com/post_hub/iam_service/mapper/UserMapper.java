package com.post_hub.iam_service.mapper;

import com.post_hub.iam_service.model.dto.user.UserDto;
import com.post_hub.iam_service.model.entity.Users;
import com.post_hub.iam_service.model.request.post.NewUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)

public interface UserMapper {
  @Mapping(source = "lastLogin", target = "last_login")
  UserDto toUserDto(Users user);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "status", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "lastLogin", ignore = true)
  @Mapping(target = "isDeleted", ignore = true)
  Users createUser(NewUserRequest userRequest);
}
