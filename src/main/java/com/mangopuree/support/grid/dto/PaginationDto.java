package com.mangopuree.support.grid.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(description = "페이징 처리 DTO")
public class PaginationDto {

    @Schema(description = "페이지 번호", example = "1")
    private int page;

    @Schema(description = "총 데이터 수", example = "100")
    private int totalCount;
}
