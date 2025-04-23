package com.mangopuree.nvrschedulehistory.dto;

import com.mangopuree.support.grid.dto.RequestGridDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NvrScheduleHistorySearchDto extends RequestGridDto {

    private String scheduleId;
}
