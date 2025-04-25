package com.mangopuree.nvrschedule.dto;

import com.mangopuree.support.grid.dto.RequestGridDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "NVR 스케쥴 그리드 조건 DTO")
public class NvrScheduleSearchDto extends RequestGridDto {

    @Schema(description = "스케쥴아이디", example = "SCHEDULE0001")
    private String scheduleId;

    @Schema(description = "스케쥴명", example = "스케쥴1")
    private String scheduleName;

    @Schema(description = "카메라아이디", example = "CAMERA0001")
    private String cameraId;
}
