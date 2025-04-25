package com.mangopuree.support.grid.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@Schema(description = "공통 등록 수정 DTO")
public class SetGridDataDto <T>{

    @Schema(description = "Grid 데이터 DTO")
    private List<T> contents;

    @Schema(description = "페이징 처리 DTO")
    private PaginationDto pagination;
}
