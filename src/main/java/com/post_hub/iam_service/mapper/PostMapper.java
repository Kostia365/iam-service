package com.post_hub.iam_service.mapper;


import com.post_hub.iam_service.model.dto.post.PostDto;
import com.post_hub.iam_service.model.dto.post.PostSearchDto;
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
  PostDto toPostDto(Post post);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "created_at", ignore = true)
  Post createPost(NewPostRequest postRequest);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "created_at", ignore = true)
  void updatePost(@MappingTarget Post post, UpdatePostRequest request);

  @Mapping(source = "deleted", target = "isDeleted")
  PostSearchDto toPostSearchDto(Post post);

}
