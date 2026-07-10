package com.post_hub.iam_service.model.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.post_hub.iam_service.model.enums.RegistrationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
  private Integer id;
  private String username;
  private String email;
  @JsonProperty("created_at")
  private LocalDateTime created_at = LocalDateTime.now();
  @JsonProperty("last_login")
  private LocalDateTime last_login = LocalDateTime.now();
  @JsonProperty("registration_status")
  private RegistrationStatus registration_status = RegistrationStatus.ACTIVE;
}
