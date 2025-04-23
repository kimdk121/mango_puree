package com.mangopuree.nvrschedulehistory.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NvrScheduleHistoryInsertDto {

    private String historyId;
    private String scheduleId;
    private String movieId;
    private boolean downloadedYn;
    private String failReason;
}
