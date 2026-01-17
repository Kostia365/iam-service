package com.post_hub.iam_service.mapper;


import com.post_hub.iam_service.model.dto.post.PostDto;
import com.post_hub.iam_service.model.entity.Post;
import com.post_hub.iam_service.model.request.post.NewPostRequest;
import com.post_hub.iam_service.model.request.post.UpdatePostRequest;
import org.hibernate.type.descriptor.DateTimeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;

import java.util.Objects;


@Mapper(
    componentModel = "spring",
    nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
    imports = {DateTimeUtils.class, Objects.class}
)
public interface PostMapper {
  @Mapping(source = "id", target = "id")
  @Mapping(source = "title", target = "title")
  @Mapping(source = "content", target = "content")
  @Mapping(source = "created_at", target = "created_at", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
  @Mapping(source = "likes", target = "likes")
  PostDto toPostDto(Post post);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "created_at", ignore = true)
  Post createPost(NewPostRequest postRequest);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "created_at", ignore = true)
  Post updatePost(@MappingTarget Post post, UpdatePostRequest request);
}
