package com.mangopuree.nvrschedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.grid.dto.ResponseGridDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "NVR 스케쥴 그리드 조회 DTO")
public class NvrScheduleGridDto extends ResponseGridDto {

    @Schema(description = "스케쥴아이디", example = "SCHEDULE0001")
    private String scheduleId;

    @Schema(description = "카메라아이디", example = "CAMERA0001")
    private String cameraId;

    @Schema(description = "스케쥴명", example = "스케쥴1")
    private String scheduleName;

    @Schema(description = "시작일자", example = "2025-04-18")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Schema(description = "종료일자", example = "2025-04-19")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Schema(description = "주기 (분)", example = "60")
    private Integer cycle;

    @Schema(description = "길이 (분)", example = "3")
    private Integer duration;

    @Schema(description = "마지막 다운로드일시", example = "2025-04-25 19:07:12")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastDownloadDt;

    @Schema(description = "등록자아이디", example = "1")
    private String regId;

    @Schema(description = "등록자명", example = "관리자")
    private String regUserName;

    @Schema(description = "등록일시", example = "2025-04-17 00:54:51.000")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;
}
