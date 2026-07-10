package com.post_hub.iam_service.model.request.post;


import com.post_hub.iam_service.model.enums.RegistrationStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserRequest {
  @NotBlank(message = "username can not be empty")
  @Size(min = 3, max = 50)
  private String username;
  @NotBlank(message = "password can not be empty")
  @Size(min = 3, max = 50)
  private String password;
  @NotBlank(message = "email can not be empty")
  @Email
  private String email;
  private RegistrationStatus status = RegistrationStatus.ACTIVE;
  private Boolean isDeleted = false;
}
