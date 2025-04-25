package com.mangopuree.movie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.resttemplate.dto.ExternalRequestDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MovieSearchDto extends ExternalRequestDto {

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

}
