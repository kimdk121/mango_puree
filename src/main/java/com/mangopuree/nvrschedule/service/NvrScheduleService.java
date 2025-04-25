package com.mangopuree.nvrschedule.service;

import com.mangopuree.nvrschedule.dto.*;
import com.mangopuree.support.security.LoginUserHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NvrScheduleService {

    private final NvrScheduleMapper nvrScheduleMapper;

    /**
     * Grid용 스케쥴 조회
     * @param nvrScheduleSearchDto
     * @return List<NvrScheduleGridDto>
     */
    public List<NvrScheduleGridDto> nvrScheduleListByGrid(NvrScheduleSearchDto nvrScheduleSearchDto) {
        return nvrScheduleMapper.nvrScheduleListByGrid(nvrScheduleSearchDto);
    }

    /**
     * 수정페이지용 조회
     * @param scheduleId
     * @return NvrScheduleDto
     */
    public NvrScheduleDto findByScheduleId(String scheduleId) {
        return nvrScheduleMapper.findByScheduleId(scheduleId);
    }

    /**
     * 다음 저장할 스케쥴아이디 조회
     * @return String
     */
    public String findNextScheduleId() {
        return nvrScheduleMapper.findNextScheduleId();
    }

    /**
     * 등록
     * @param nvrScheduleInsertDto
     * @return int
     */
    public int insert(NvrScheduleInsertDto nvrScheduleInsertDto) {

        String scheduleId = findNextScheduleId();
        Long regId = LoginUserHolder.getAsLong();
        nvrScheduleInsertDto.setScheduleId(scheduleId);
        nvrScheduleInsertDto.setRegId(regId);

        return nvrScheduleMapper.insert(nvrScheduleInsertDto);
    }

    /**
     * 수정
     * @param nvrScheduleInsertDto
     * @return int
     */
    public int update(NvrScheduleInsertDto nvrScheduleInsertDto) {

        Long regId = LoginUserHolder.getAsLong();
        nvrScheduleInsertDto.setRegId(regId);

        return nvrScheduleMapper.update(nvrScheduleInsertDto);
    }

    /**
     * 스케쥴아이디로 삭제
     * @param scheduleId
     * @return int
     */
    public int deleteByScheduleId(String scheduleId) {
        return nvrScheduleMapper.deleteByScheduleId(scheduleId);
    }

    /**
     * 상세페이지용 조회
     * @param scheduleId
     * @return NvrScheduleDetailDto
     */
    public NvrScheduleDetailDto findScheduleDetail(String scheduleId) {
        return nvrScheduleMapper.findScheduleDetail(scheduleId);
    }

    /**
     * 다운로드 할 스케쥴 조회
     * @return List<NvrScheduleDto>
     */
    public List<NvrScheduleDto> findScheduleToDownload() {
        return nvrScheduleMapper.findScheduleToDownload();
    }

    /**
     * 다운로드 일자 지금으로 수정
     * @param scheduleId
     * @return int
     */
    public int updateLastDownloadDt(String scheduleId) {
        return nvrScheduleMapper.updateLastDownloadDt(scheduleId);
    }
}
