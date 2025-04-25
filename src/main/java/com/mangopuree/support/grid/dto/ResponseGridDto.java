package com.mangopuree.support.grid.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "공통 그리드 조회 DTO")
public class ResponseGridDto {

    @Schema(description = "순번", example = "1")
    private int rnum;

    @Schema(description = "총 데이터 수", example = "10")
    private int totalCount;
}
