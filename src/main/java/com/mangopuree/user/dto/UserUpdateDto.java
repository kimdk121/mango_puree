package com.mangopuree.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "사용자 수정 DTO")
public class UserUpdateDto {

    @Schema(description = "사용자아이디", example = "9")
    private Long userId;

    @Schema(description = "아이디", example = "jwt")
    private String username;

    @Schema(description = "사용자명", example = "사용자")
    @NotBlank
    private String name;

    @Schema(description = "전화번호", example = "010-1010-1010")
    @NotBlank
    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String telNo;

    @Schema(description = "팩스번호", example = "010-1010-1010")
    @Pattern(regexp = "^0\\d{1,2}-\\d{3,4}-\\d{4}$")
    private String faxNo;

}
