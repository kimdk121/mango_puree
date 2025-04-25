package com.mangopuree.support.grid.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "공통 그리드 조건 DTO")
public class RequestGridDto {

    @Schema(description = "페이지별 데이터 수", example = "10")
    private int perPage;

    @Schema(description = "페이지 번호", example = "1")
    private int page;

    @Schema(description = "페이지 번호", example = "0", hidden = true)
    private int offset;

    @Schema(description = "조회 데이터 수", example = "10", hidden = true)
    private int limit;

    @Schema(description = "페이징 계산", hidden = true)
    public void calculatePaging() {
        this.offset = (page - 1) * perPage;
        this.limit = perPage;
    }
}
