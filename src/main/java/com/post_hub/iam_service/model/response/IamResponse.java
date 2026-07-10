package com.post_hub.iam_service.model.response;

import com.post_hub.iam_service.model.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IamResponse<P extends Serializable> implements Serializable {
  private String message;
  private P payload;
  private boolean success;

  public static <P extends Serializable> IamResponse<P> createSuccessFul(P payload) {
    return new IamResponse<>(StringUtils.EMPTY, payload, true);
  }

  public static <P extends Serializable> IamResponse<UserDto> updatedSuccessFul(UserDto userDto) {
    return new IamResponse<>(StringUtils.EMPTY, userDto, true);
  }
}
