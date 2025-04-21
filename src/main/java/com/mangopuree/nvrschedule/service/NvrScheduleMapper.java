package com.mangopuree.nvrschedule.service;

import com.mangopuree.nvrschedule.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NvrScheduleMapper {

    List<NvrScheduleGridDto> nvrScheduleListByGrid(NvrScheduleSearchDto nvrScheduleSearchDto);

    String findNextScheduleId();

    int insert(NvrScheduleInsertDto nvrScheduleInsertDto);

    NvrScheduleDto findByScheduleId(String scheduleId);

    int update(NvrScheduleInsertDto nvrScheduleInsertDto);

    int deleteByScheduleId(String scheduleId);

    NvrScheduleDetailDto findScheduleDetail(String scheduleId);

    List<NvrScheduleDto> findScheduleToDownload();

    int updateLastDownloadDt(String scheduleId);
}
