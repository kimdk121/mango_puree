package com.mangopuree.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.grid.dto.ResponseGridDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "사용자 그리드 조건 DTO")
public class UserGridDto extends ResponseGridDto {

    @Schema(description = "사용자아이디", example = "1")
    private Long userId;
    @Schema(description = "아이디", example = "admin")
    private String username;
    @Schema(description = "사용자명", example = "관리자")
    private String name;
    @Schema(description = "전화번호", example = "010-1010-1012")
    private String telNo;
    @Schema(description = "팩스번호", example = "02-1010-1012")
    private String faxNo;
    @Schema(description = "권한명", example = "ADMIN")
    private String roleName;
    @Schema(description = "등록일시", example = "2025-03-19 13:59:59")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;
}
