package com.mangopuree.estimate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.grid.dto.RequestGridDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Schema(description = "견적서 그리드 조건 DTO")
public class EstimateSearchDto extends RequestGridDto {

    @Schema(description = "견적서아이디", example = "EST25041900001")
    private String estimateId;

    @Schema(description = "조회용 최소 등록일시", example = "2025-01-26")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate estimateStartDate;

    @Schema(description = "조회용 최대 등록일시", example = "2025-05-26")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate estimateEndDate;

    @Schema(description = "상태코드", example = "ESS003")
    private String estimateStatusCd;
}
