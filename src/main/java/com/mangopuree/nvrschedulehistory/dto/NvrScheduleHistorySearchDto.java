package com.mangopuree.nvrschedulehistory.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.base.dto.RequestGridDto;
import com.mangopuree.support.base.dto.ResponseGridDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NvrScheduleHistorySearchDto extends RequestGridDto {

    private String scheduleId;
}
