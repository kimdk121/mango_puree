package com.mangopuree.nvrschedulehistory.dto;

import com.mangopuree.support.grid.dto.RequestGridDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "NVR 스케쥴 이력 그리드 조건 DTO")
public class NvrScheduleHistorySearchDto extends RequestGridDto {

    @Schema(description = "스케쥴아이디", example = "SCHEDULE0001")
    @NotBlank
    private String scheduleId;
}
