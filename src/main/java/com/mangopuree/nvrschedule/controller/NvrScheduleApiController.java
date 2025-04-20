package com.mangopuree.nvrschedule.controller;

import com.mangopuree.estimate.dto.EstimateGridDto;
import com.mangopuree.estimate.dto.EstimateSearchDto;
import com.mangopuree.nvrschedule.dto.*;
import com.mangopuree.nvrschedule.service.NvrScheduleService;
import com.mangopuree.support.base.BaseContoller;
import com.mangopuree.support.validator.NvrScheduleDtoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/nvrschedule")
public class NvrScheduleApiController extends BaseContoller {

    private final NvrScheduleService nvrScheduleService;
    private final NvrScheduleDtoValidator nvrScheduleDtoValidator;

    /**
     * API NVR schedule 전체 Grid 호출
     */
    @GetMapping("/list")
    public Map<String, Object> list(@ModelAttribute NvrScheduleSearchDto nvrScheduleSearchDto) {
        ModelMap model = new ModelMap();
        nvrScheduleSearchDto.calculatePaging();
        List<NvrScheduleGridDto> nvrScheduleGridDtos = nvrScheduleService.nvrScheduleListByGrid(nvrScheduleSearchDto);
        int totalCount = 0;
        if (nvrScheduleGridDtos.size() > 0) {
            totalCount = nvrScheduleGridDtos.get(0).getTotalCount();
        }
        Map<String, Object> data = setGridData(nvrScheduleSearchDto, nvrScheduleGridDtos, totalCount);
        model.addAttribute("data", data);

        return setSuccessResult(model);
    }

    @PostMapping("/insert")
    public Map<String, Object> insert(@RequestBody NvrScheduleInsertDto nvrScheduleInsertDto, BindingResult bindingResult) {
        ModelMap model = new ModelMap();
        nvrScheduleDtoValidator.validate(nvrScheduleInsertDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
            return setFailResult(model, fieldErrors);
        }
        nvrScheduleService.insert(nvrScheduleInsertDto);
        return setSuccessResult(model);
    }

    @GetMapping("/{scheduleId}")
    public Map<String, Object> detailForUpdate(@PathVariable String scheduleId) {
        ModelMap model = new ModelMap();
        NvrScheduleDto nvrScheduleDto = nvrScheduleService.findByScheduleId(scheduleId);
        model.addAttribute("nvrSchedule", nvrScheduleDto);
        return setSuccessResult(model);
    }

    @GetMapping("/detail/{scheduleId}")
    public Map<String, Object> detail(@PathVariable String scheduleId) {
        ModelMap model = new ModelMap();
        NvrScheduleDetailDto scheduleDetail = nvrScheduleService.findScheduleDetail(scheduleId);
        model.addAttribute("nvrSchedule", scheduleDetail);
        return setSuccessResult(model);
    }

    @PostMapping("/update")
    public Map<String, Object> update(@RequestBody NvrScheduleInsertDto nvrScheduleInsertDto, BindingResult bindingResult) {
        ModelMap model = new ModelMap();
        nvrScheduleDtoValidator.validate(nvrScheduleInsertDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
            return setFailResult(model, fieldErrors);
        }
        nvrScheduleService.update(nvrScheduleInsertDto);
        return setSuccessResult(model);
    }

    @DeleteMapping("{scheduleId}")
    public Map<String, Object> delete(@PathVariable String scheduleId) {
        ModelMap model = new ModelMap();
        nvrScheduleService.deleteByScheduleId(scheduleId);
        return setSuccessResult(model);
    }
}
