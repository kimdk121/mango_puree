package com.mangopuree.nvrschedulehistory.service;

import com.mangopuree.nvrschedulehistory.dto.NvrScheduleHistoryGridDto;
import com.mangopuree.nvrschedulehistory.dto.NvrScheduleHistorySearchDto;
import com.mangopuree.support.base.dto.RequestGridDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NvrScheduleHistoryService {

    private final NvrScheduleHistoryMapper nvrScheduleHistoryMapper;

    public List<NvrScheduleHistoryGridDto> historyListByGrid(NvrScheduleHistorySearchDto nvrScheduleHistorySearchDto) {
        return nvrScheduleHistoryMapper.historyListByGrid(nvrScheduleHistorySearchDto);
    }
}
