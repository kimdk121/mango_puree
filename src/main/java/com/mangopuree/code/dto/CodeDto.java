package com.mangopuree.code.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "코드 조회 DTO")
public class CodeDto {

    @Schema(description = "코드아이디", example = "ESS001")
    private String codeId;

    @Schema(description = "코드그룹아이디", example = "ESTIMATE_STATUS")
    private String codeGroupId;

    @Schema(description = "코드명", example = "임시저장")
    private String codeName;

    @Schema(description = "코드값", example = "TEMP")
    private String codeValue;
}
