package com.mangopuree.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "jwt 인증토큰 응답 DTO")
public class AuthResponseDto {

    @Schema(description = "jwt 인증 토큰")
    private String token;
}
