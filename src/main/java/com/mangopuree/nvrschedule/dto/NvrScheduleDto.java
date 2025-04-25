package com.mangopuree.nvrschedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.base.dto.BaseAuditDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "NVR 스케쥴 조회 DTO")
public class NvrScheduleDto {

    @Schema(description = "스케쥴아이디", example = "SCHEDULE0005")
    private String scheduleId;

    @Schema(description = "카메라아이디", example = "CAMERA0002")
    private String cameraId;

    @Schema(description = "스케쥴명", example = "123")
    private String scheduleName;

    @Schema(description = "시작일자", example = "2025-04-18")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Schema(description = "종료일자", example = "2025-04-19")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Schema(description = "주기 (분)", example = "60")
    private int cycle;

    @Schema(description = "길이 (분)", example = "5")
    private int duration;

    @Schema(description = "마지막 다운로드일자", example = "2025-04-19 21:49:15")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastDownloadDt;

}
