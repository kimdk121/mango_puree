package com.mangopuree.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "사용자 비밀번호 수정 DTO")
public class UserPasswordUpdateDto {

    @Schema(description = "사용자아이디", example = "9")
    private Long userId;

    @Schema(description = "비밀번호", example = "123456")
    @Size(min =6)
    @NotBlank
    private String password;

    @Schema(description = "비밀번호 확인", example = "123456")
    @Size(min =6)
    @NotBlank
    private String confirmPassword;

    @Schema(description = "비밀번호 매칭", hidden = true)
    public boolean isPasswordMatching() {
        return password.equals(confirmPassword);
    }
}
