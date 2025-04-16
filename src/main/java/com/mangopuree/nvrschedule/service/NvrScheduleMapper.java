package com.mangopuree.nvrschedule.service;

import com.mangopuree.nvrschedule.dto.NvrScheduleDto;
import com.mangopuree.nvrschedule.dto.NvrScheduleGridDto;
import com.mangopuree.nvrschedule.dto.NvrScheduleInsertDto;
import com.mangopuree.nvrschedule.dto.NvrScheduleSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NvrScheduleMapper {

    List<NvrScheduleGridDto> nvrScheduleListByGrid(NvrScheduleSearchDto nvrScheduleSearchDto);

    String findNextScheduleId();

    int insert(NvrScheduleInsertDto nvrScheduleInsertDto);

    NvrScheduleDto findByScheduleId(String scheduleId);

    int update(NvrScheduleInsertDto nvrScheduleInsertDto);
}
