package com.mangopuree.nvrschedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.nvrschedulehistory.dto.NvrScheduleHistoryDto;
import com.mangopuree.support.base.dto.BaseAuditDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class NvrScheduleDetailDto extends BaseAuditDto {

    private String scheduleId;
    private String cameraId;
    private String scheduleName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private int cycle;
    private int duration;

    List<NvrScheduleHistoryDto> historyList;
}
