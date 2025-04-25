package com.mangopuree.user.dto;

import com.mangopuree.support.grid.dto.RequestGridDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "사용자 그리드 조건 DTO")
public class UserSearchDto extends RequestGridDto {

    @Schema(description = "아이디", example = "admin")
    private String username;
    @Schema(description = "사용자명", example = "관리자")
    private String name;
}
