package com.mangopuree.support.base.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Schema(description = "공통 등록 수정 DTO")
public class BaseAuditDto {

    @Schema(description = "등록자아이디", example = "1")
    private Long regId;
    @Schema(description = "수정자아이디", example = "1")
    private Long updId;
}
