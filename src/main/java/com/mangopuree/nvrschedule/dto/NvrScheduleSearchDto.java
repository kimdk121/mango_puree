package com.mangopuree.nvrschedule.dto;

import com.mangopuree.support.base.dto.RequestGridDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NvrScheduleSearchDto extends RequestGridDto {

    private String scheduleId;
    private String scheduleName;
    private String cameraId;
}
