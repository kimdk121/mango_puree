package com.mangopuree.nvrschedulehistory.service;

import com.mangopuree.nvrschedulehistory.dto.NvrScheduleHistoryGridDto;
import com.mangopuree.nvrschedulehistory.dto.NvrScheduleHistoryInsertDto;
import com.mangopuree.nvrschedulehistory.dto.NvrScheduleHistorySearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NvrScheduleHistoryService {

    private final NvrScheduleHistoryMapper nvrScheduleHistoryMapper;

    /**
     * Grid용 이력 조회
     * @param nvrScheduleHistorySearchDto
     * @return List<NvrScheduleHistoryGridDto>
     */
    public List<NvrScheduleHistoryGridDto> historyListByGrid(NvrScheduleHistorySearchDto nvrScheduleHistorySearchDto) {
        return nvrScheduleHistoryMapper.historyListByGrid(nvrScheduleHistorySearchDto);
    }

    /**
     * 다음 저장할 스케쥴이력아이디 조회
     * @return String
     */
    public String findNextHistoryId() {
        return nvrScheduleHistoryMapper.findNextHistoryId();
    }

    /**
     * 등록
     * @param nvrScheduleHistoryInsertDto
     * @return int
     */
    public int insert(NvrScheduleHistoryInsertDto nvrScheduleHistoryInsertDto) {
        return nvrScheduleHistoryMapper.insert(nvrScheduleHistoryInsertDto);
    }
}
