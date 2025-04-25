package com.mangopuree.movie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "영상 다운로드 DTO")
public class MovieDownloadDto {

    @Schema(description = "카메라아이디", example = "CAMERA0001")
    private String cameraId;

    @Schema(description = "영상시작일시", example = "2025-04-21 08:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @Schema(description = "영상종료일시", example = "2025-04-21 08:05:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    @Schema(description = "길이 (분)", example = "5")
    private int duration;

    @Schema(description = "영상데이터", example = "AAAAIGZ0eXBpc29tAAACAGlzb21pc28yYXZjMW1wNDEAACztbW9vdgAAAGxtdmhkAAAAAAAA" +
            "AAAAAAAAAAAD6AAAH+AAAQAAAQAAAAAAAAAAAAAAAAEAAAAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAAAAAAA" +
            "AAAAAAAAAAAAAAAAAwAAFXl0cmFrAAAAXHRraGQAAAADAAAAAAAAAAAAAAABAAAAAAAAH+AAAAAAAAAAAAAAAAEBAAAAAAEAAAAAAAAAAAAA" +
            "AAAAAAABAAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAAkZWR0cwAAABxlbHN0AAAAAAAAAAEAAB/")
    private String movieData;
}
