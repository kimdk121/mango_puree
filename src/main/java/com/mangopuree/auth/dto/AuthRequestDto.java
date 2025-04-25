package com.mangopuree.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "jwt 인증토큰 요청 DTO")
public class AuthRequestDto {

    @Schema(description = "아이디", example = "jwt")
    @NotBlank
    private String username;

    @Schema(description = "비밀번호", example = "123456")
    @NotNull
    private String password;
}
