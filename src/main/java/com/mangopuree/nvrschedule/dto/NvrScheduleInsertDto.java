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

@Getter
@Setter
@Schema(description = "NVR 스케쥴 등록 DTO")
public class NvrScheduleInsertDto extends BaseAuditDto {

    @Schema(description = "스케쥴아이디", example = "SCHEDULE0005", requiredMode = Schema.RequiredMode.REQUIRED)
    private String scheduleId;

    @Schema(description = "카메라아이디", example = "CAMERA0002")
    @NotBlank
    private String cameraId;

    @Schema(description = "스케쥴명", example = "123")
    @NotBlank
    private String scheduleName;

    @Schema(description = "시작일자", example = "2025-04-18")
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Schema(description = "종료일자", example = "2025-04-19")
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Schema(description = "주기 (분)", example = "60")
    @NotNull
    @Min(value = 1)
    private int cycle;

    @Schema(description = "길이 (분)", example = "5")
    @NotNull
    @Min(value = 1)
    private int duration;

    @Schema(description = "일자 validate", hidden = true)
    public boolean isDateRangeValid() {
        return startDate != null && endDate != null && !startDate.isAfter(endDate);
    }
}
