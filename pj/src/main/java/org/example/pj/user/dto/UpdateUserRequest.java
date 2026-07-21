package org.example.pj.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateUserRequest {

    @NotBlank(message = "사용자 이름 수정시 필수로 작성해야합니다.")
    @Size(max = 20, message = "이름은 20자 이내로 작성해주세요.")
    private String username;

    @NotBlank(message = "사용자 이메일 수정시 필수로 작성해야합니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다")
    private String email;

}
