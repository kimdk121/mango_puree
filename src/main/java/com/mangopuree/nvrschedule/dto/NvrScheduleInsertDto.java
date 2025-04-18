package com.mangopuree.nvrschedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.base.dto.BaseAuditDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NvrScheduleInsertDto extends BaseAuditDto {

    private String scheduleId;

    @NotBlank
    private String cameraId;

    @NotBlank
    private String scheduleName;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotNull
    @Min(value = 1)
    private int cycle;

    @NotNull
    @Min(value = 1)
    private int duration;

    public boolean isDateRangeValid() {
        return startDate != null && endDate != null && !startDate.isAfter(endDate);
    }
}
