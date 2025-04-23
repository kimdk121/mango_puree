package com.mangopuree.nvrschedule.controller;

import com.mangopuree.nvrschedule.dto.*;
import com.mangopuree.nvrschedule.service.NvrScheduleService;
import com.mangopuree.support.base.BaseController;
import com.mangopuree.support.base.dto.ApiResponseDto;
import com.mangopuree.support.grid.dto.SetGridDataDto;
import com.mangopuree.support.validator.NvrScheduleDtoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/nvrschedule")
public class NvrScheduleApiController extends BaseController {

    private final NvrScheduleService nvrScheduleService;
    private final NvrScheduleDtoValidator nvrScheduleDtoValidator;

    /**
     * API NVR schedule 전체 Grid 호출
     */
    @GetMapping("/list")
    public ResponseEntity<ApiResponseDto> list(@ModelAttribute NvrScheduleSearchDto nvrScheduleSearchDto) {

        nvrScheduleSearchDto.calculatePaging();
        List<NvrScheduleGridDto> nvrScheduleGridDtos = nvrScheduleService.nvrScheduleListByGrid(nvrScheduleSearchDto);
        int totalCount = 0;
        if (nvrScheduleGridDtos.size() > 0) {
            totalCount = nvrScheduleGridDtos.get(0).getTotalCount();
        }
        SetGridDataDto data = setGridData(nvrScheduleSearchDto, nvrScheduleGridDtos, totalCount);
        return setSuccessResult(data);
    }

    @PostMapping("/insert")
    public ResponseEntity<ApiResponseDto> insert(@RequestBody NvrScheduleInsertDto nvrScheduleInsertDto, BindingResult bindingResult) {

        nvrScheduleDtoValidator.validate(nvrScheduleInsertDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
            return setFailResult(fieldErrors);
        }
        nvrScheduleService.insert(nvrScheduleInsertDto);
        return setSuccessResult();
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ApiResponseDto> detailForUpdate(@PathVariable String scheduleId) {

        NvrScheduleDto nvrScheduleDto = nvrScheduleService.findByScheduleId(scheduleId);
        return setSuccessResult(nvrScheduleDto);
    }

    @GetMapping("/detail/{scheduleId}")
    public ResponseEntity<ApiResponseDto> detail(@PathVariable String scheduleId) {

        NvrScheduleDetailDto nvrSchedule = nvrScheduleService.findScheduleDetail(scheduleId);
        return setSuccessResult(nvrSchedule);
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponseDto> update(@RequestBody NvrScheduleInsertDto nvrScheduleInsertDto, BindingResult bindingResult) {

        nvrScheduleDtoValidator.validate(nvrScheduleInsertDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
            return setFailResult(fieldErrors);
        }
        nvrScheduleService.update(nvrScheduleInsertDto);
        return setSuccessResult();
    }

    @DeleteMapping("{scheduleId}")
    public ResponseEntity<ApiResponseDto> delete(@PathVariable String scheduleId) {
        nvrScheduleService.deleteByScheduleId(scheduleId);
        return setSuccessResult();
    }
}
