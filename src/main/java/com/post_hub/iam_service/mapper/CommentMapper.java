package com.post_hub.iam_service.mapper;


import org.hibernate.type.descriptor.DateTimeUtils;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.Objects;

@Mapper(
    componentModel = "spring",
    nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
    imports = {DateTimeUtils.class, Objects.class}
)
public interface CommentMapper {
}
