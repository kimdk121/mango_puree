package com.mangopuree.support.base.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@Schema(description = "공통 API 조회 DTO")
public class ApiResponseDto<T> {

    @Schema(description = "코드", example = "00")
    private String code;

    @Schema(description = "메세지", example = "success")
    private String message;

    @Schema(description = "결과", example = "true")
    private boolean result;

    @Schema(description = "데이터", nullable = true)
    private T data;

    @Schema(description = "필드에러", nullable = true)
    private Map<String, List<String>> fieldErrors;
}
