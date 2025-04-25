package com.mangopuree.support.resttemplate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Schema(description = "RestTemplate 응답 DTO")
public class ExternalResponseDto<T> {

    @Schema(description = "응답아이디", example = "d991f060-53ac-4c30-9216-1f4e838aeacb")
    private String responseId;

    @Schema(description = "응답일시", example = "2025-04-21 09:05:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime responseDt;

    @Schema(description = "결과코드", example = "SUCCESS")
    private String resultCode;

    @Schema(description = "결과메세지", example = "영상 다운로드 성공")
    private String resultMessage;

    @Schema(description = "데이터", nullable = true)
    private List<T> data;
}