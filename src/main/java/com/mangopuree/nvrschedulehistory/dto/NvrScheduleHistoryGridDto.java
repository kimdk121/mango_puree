package com.mangopuree.nvrschedulehistory.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mangopuree.support.base.dto.ResponseGridDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NvrScheduleHistoryGridDto extends ResponseGridDto {

    private String historyId;
    private String scheduleName;
    private String movieName;
    private boolean downloadedYn;
    private String failReason;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;
}
