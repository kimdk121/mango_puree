package com.mangopuree.nvrschedule.service;

import com.mangopuree.nvrschedule.dto.NvrScheduleDto;
import com.mangopuree.nvrschedule.dto.NvrScheduleGridDto;
import com.mangopuree.nvrschedule.dto.NvrScheduleInsertDto;
import com.mangopuree.nvrschedule.dto.NvrScheduleSearchDto;
import com.mangopuree.support.security.LoginUserHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NvrScheduleService {

    private final NvrScheduleMapper nvrScheduleMapper;

    public List<NvrScheduleGridDto> nvrScheduleListByGrid(NvrScheduleSearchDto nvrScheduleSearchDto) {
        return nvrScheduleMapper.nvrScheduleListByGrid(nvrScheduleSearchDto);
    }

    public NvrScheduleDto findByScheduleId(String scheduleId) {
        return nvrScheduleMapper.findByScheduleId(scheduleId);
    }

    public String findNextScheduleId() {
        return nvrScheduleMapper.findNextScheduleId();
    }

    public int insert(NvrScheduleInsertDto nvrScheduleInsertDto) {

        String scheduleId = findNextScheduleId();
        Long regId = LoginUserHolder.getAsLong();
        nvrScheduleInsertDto.setScheduleId(scheduleId);
        nvrScheduleInsertDto.setRegId(regId);

        return nvrScheduleMapper.insert(nvrScheduleInsertDto);
    }

    public int update(NvrScheduleInsertDto nvrScheduleInsertDto) {

        Long regId = LoginUserHolder.getAsLong();
        nvrScheduleInsertDto.setRegId(regId);

        return nvrScheduleMapper.update(nvrScheduleInsertDto);
    }
}
