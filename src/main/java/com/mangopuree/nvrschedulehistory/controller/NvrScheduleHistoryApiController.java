package com.mangopuree.nvrschedulehistory.controller;

import com.mangopuree.nvrschedulehistory.dto.NvrScheduleHistoryGridDto;
import com.mangopuree.nvrschedulehistory.dto.NvrScheduleHistorySearchDto;
import com.mangopuree.nvrschedulehistory.service.NvrScheduleHistoryService;
import com.mangopuree.support.base.BaseContoller;
import com.mangopuree.support.base.dto.RequestGridDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/nvrschedulehistory")
public class NvrScheduleHistoryApiController extends BaseContoller {

    private final NvrScheduleHistoryService nvrScheduleHistoryService;

    @GetMapping("/list")
    public Map<String, Object> list(@ModelAttribute NvrScheduleHistorySearchDto nvrScheduleHistorySearchDto) {
        ModelMap model = new ModelMap();
        nvrScheduleHistorySearchDto.calculatePaging();
        List<NvrScheduleHistoryGridDto> nvrScheduleHistoryGridDtos = nvrScheduleHistoryService.historyListByGrid(nvrScheduleHistorySearchDto);
        int totalCount = 0;
        if (nvrScheduleHistoryGridDtos.size() > 0) {
            totalCount = nvrScheduleHistoryGridDtos.get(0).getTotalCount();
        }
        Map<String, Object> data = setGridData(nvrScheduleHistorySearchDto, nvrScheduleHistoryGridDtos, totalCount);
        model.addAttribute("data", data);

        return setSuccessResult(model);
    }
}
