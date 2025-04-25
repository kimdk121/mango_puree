package com.mangopuree.nvrschedulehistory.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(description = "NVR 스케쥴 이력 그리드 등록 DTO")
public class NvrScheduleHistoryInsertDto {

    @Schema(description = "스케쥴이력아이디", example = "HISTORY0007")
    private String historyId;

    @Schema(description = "스케쥴아이디", example = "SCHEDULE0003")
    private String scheduleId;

    @Schema(description = "영상아이디", example = "MOVIE0024")
    private String movieId;

    @Schema(description = "다운로드 여부", example = "1")
    private boolean downloadedYn;

    @Schema(description = "실패이유", nullable = true)
    private String failReason;
}
