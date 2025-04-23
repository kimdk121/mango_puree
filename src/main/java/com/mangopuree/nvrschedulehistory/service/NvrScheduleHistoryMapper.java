package com.mangopuree.nvrschedulehistory.service;


import com.mangopuree.nvrschedulehistory.dto.NvrScheduleHistoryGridDto;
import com.mangopuree.nvrschedulehistory.dto.NvrScheduleHistoryInsertDto;
import com.mangopuree.nvrschedulehistory.dto.NvrScheduleHistorySearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NvrScheduleHistoryMapper {

    List<NvrScheduleHistoryGridDto> historyListByGrid(NvrScheduleHistorySearchDto nvrScheduleHistorySearchDto);

    String findNextHistoryId();

    int insert(NvrScheduleHistoryInsertDto nvrScheduleHistoryInsertDto);
}
