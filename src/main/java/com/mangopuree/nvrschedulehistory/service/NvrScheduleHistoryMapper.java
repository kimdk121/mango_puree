package com.mangopuree.nvrschedulehistory.service;


import com.mangopuree.nvrschedulehistory.dto.NvrScheduleHistoryGridDto;
import com.mangopuree.nvrschedulehistory.dto.NvrScheduleHistoryInsertDto;
import com.mangopuree.nvrschedulehistory.dto.NvrScheduleHistorySearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NvrScheduleHistoryMapper {

    /**
     * Grid용 이력 조회
     * @param nvrScheduleHistorySearchDto
     * @return List<NvrScheduleHistoryGridDto>
     */
    List<NvrScheduleHistoryGridDto> historyListByGrid(NvrScheduleHistorySearchDto nvrScheduleHistorySearchDto);

    /**
     * 다음 저장할 스케쥴이력아이디 조회
     * @return String
     */
    String findNextHistoryId();

    /**
     * 등록
     * @param nvrScheduleHistoryInsertDto
     * @return int
     */
    int insert(NvrScheduleHistoryInsertDto nvrScheduleHistoryInsertDto);
}
