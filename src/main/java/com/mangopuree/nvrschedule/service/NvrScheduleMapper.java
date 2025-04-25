package com.mangopuree.nvrschedule.service;

import com.mangopuree.nvrschedule.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NvrScheduleMapper {

    /**
     * Grid용 스케쥴 조회
     * @param nvrScheduleSearchDto
     * @return List<NvrScheduleGridDto>
     */
    List<NvrScheduleGridDto> nvrScheduleListByGrid(NvrScheduleSearchDto nvrScheduleSearchDto);

    /**
     * 다음 저장할 스케쥴아이디 조회
     * @return String
     */
    String findNextScheduleId();

    /**
     * 등록
     * @param nvrScheduleInsertDto
     * @return int
     */
    int insert(NvrScheduleInsertDto nvrScheduleInsertDto);

    /**
     * 수정페이지용 조회
     * @param scheduleId
     * @return NvrScheduleDto
     */
    NvrScheduleDto findByScheduleId(String scheduleId);

    /**
     * 수정
     * @param nvrScheduleInsertDto
     * @return int
     */
    int update(NvrScheduleInsertDto nvrScheduleInsertDto);

    /**
     * 스케쥴아이디로 삭제
     * @param scheduleId
     * @return int
     */
    int deleteByScheduleId(String scheduleId);

    /**
     * 상세페이지용 조회
     * @param scheduleId
     * @return NvrScheduleDetailDto
     */
    NvrScheduleDetailDto findScheduleDetail(String scheduleId);

    /**
     * 다운로드 할 스케쥴 조회
     * @return List<NvrScheduleDto>
     */
    List<NvrScheduleDto> findScheduleToDownload();

    /**
     * 다운로드 일자 지금으로 수정
     * @param scheduleId
     * @return
     */
    int updateLastDownloadDt(String scheduleId);
}
