package com.mangopuree.nvrschedulehistory.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.grid.dto.ResponseGridDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "NVR 스케쥴 이력 그리드 조회 DTO")
public class NvrScheduleHistoryGridDto extends ResponseGridDto {

    @Schema(description = "스케쥴이력아이디", example = "HISTORY0006")
    private String historyId;

    @Schema(description = "스케쥴명", example = "1234")
    private String scheduleName;

    @Schema(description = "영상명", example = "20250421_080000_5_CAMERA0003.mp4")
    private String movieName;

    @Schema(description = "다운로드 여부", example = "1")
    private boolean downloadedYn;

    @Schema(description = "실패이유", nullable = true)
    private String failReason;

    @Schema(description = "저장경로", example = "/data/movie/20250421_080000_5_CAMERA0003.mp4")
    private String savePath;

    @Schema(description = "등록일시", example = "2025-04-21 23:37:16")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;
}
