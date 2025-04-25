package com.mangopuree.nvrschedulehistory.controller;

import com.mangopuree.nvrschedulehistory.dto.NvrScheduleHistoryGridDto;
import com.mangopuree.nvrschedulehistory.dto.NvrScheduleHistorySearchDto;
import com.mangopuree.nvrschedulehistory.service.NvrScheduleHistoryService;
import com.mangopuree.support.base.BaseController;
import com.mangopuree.support.base.dto.ApiResponseDto;
import com.mangopuree.support.grid.dto.SetGridDataDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/nvrschedulehistory")
public class NvrScheduleHistoryApiController extends BaseController {

    private final NvrScheduleHistoryService nvrScheduleHistoryService;

    @GetMapping("/list")
    @Operation(summary = "NVR 스케쥴 이력 Grid 정보 조회", description = "조건에 따른 NVR 스케쥴 이력 Grid 정보를 조회합니다.")
    public ResponseEntity<ApiResponseDto> list(@ModelAttribute NvrScheduleHistorySearchDto nvrScheduleHistorySearchDto) {

        nvrScheduleHistorySearchDto.calculatePaging();
        List<NvrScheduleHistoryGridDto> nvrScheduleHistoryGridDtos = nvrScheduleHistoryService.historyListByGrid(nvrScheduleHistorySearchDto);
        int totalCount = 0;
        if (nvrScheduleHistoryGridDtos.size() > 0) {
            totalCount = nvrScheduleHistoryGridDtos.get(0).getTotalCount();
        }
        SetGridDataDto data = setGridData(nvrScheduleHistorySearchDto, nvrScheduleHistoryGridDtos, totalCount);
        return setSuccessResult(data);
    }
}
