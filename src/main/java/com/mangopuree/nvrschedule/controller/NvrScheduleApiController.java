package com.mangopuree.nvrschedule.controller;

import com.mangopuree.nvrschedule.dto.*;
import com.mangopuree.nvrschedule.service.NvrScheduleService;
import com.mangopuree.support.base.BaseController;
import com.mangopuree.support.base.dto.ApiResponseDto;
import com.mangopuree.support.exception.CodeException;
import com.mangopuree.support.exception.ErrorCode;
import com.mangopuree.support.grid.dto.SetGridDataDto;
import com.mangopuree.support.validator.NvrScheduleDtoValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    @GetMapping("/list")
    @Operation(summary = "NVR 스케쥴 Grid 정보 조회", description = "조건에 따른 NVR 스케쥴 Grid 정보를 조회합니다.")
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
    @Operation(summary = "NVR 스케쥴 등록", description = "NVR 스케쥴을 등록합니다.")
    public ResponseEntity<ApiResponseDto> insert(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "NVR 스케쥴 등록 DTO", required = true) @RequestBody NvrScheduleInsertDto nvrScheduleInsertDto,
                                                 BindingResult bindingResult) {

        nvrScheduleDtoValidator.validate(nvrScheduleInsertDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
            return setFailResult(fieldErrors);
        }
        nvrScheduleService.insert(nvrScheduleInsertDto);
        return setSuccessResult();
    }

    @GetMapping("/{scheduleId}")
    @Operation(summary = "수정페이지용 NVR 스케쥴 조회", description = "수정페이지용 NVR 스케쥴을 조회합니다.")
    public ResponseEntity<ApiResponseDto> detailForUpdate(@Parameter(description = "스케쥴아이디", required = true, example = "SCHEDULE0004") @PathVariable String scheduleId) {

        NvrScheduleDto nvrScheduleDto = nvrScheduleService.findByScheduleId(scheduleId);
        if (nvrScheduleDto == null) {
            throw new CodeException(ErrorCode.NVRSCHEDULE_NOT_FOUND);
        }
        return setSuccessResult(nvrScheduleDto);
    }

    @GetMapping("/detail/{scheduleId}")
    @Operation(summary = "상세페이지용 NVR 스케쥴 조회", description = "상세페이지용 NVR 스케쥴을 조회합니다.")
    public ResponseEntity<ApiResponseDto> detail(@Parameter(description = "스케쥴아이디", required = true, example = "SCHEDULE0004") @PathVariable String scheduleId) {

        NvrScheduleDetailDto nvrScheduleDto = nvrScheduleService.findScheduleDetail(scheduleId);
        if (nvrScheduleDto == null) {
            throw new CodeException(ErrorCode.NVRSCHEDULE_NOT_FOUND);
        }
        return setSuccessResult(nvrScheduleDto);
    }

    @PostMapping("/update")
    @Operation(summary = "NVR 스케쥴 수정", description = "NVR 스케쥴을 수정합니다.")
    public ResponseEntity<ApiResponseDto> update(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "NVR 스케쥴 등록 DTO", required = true) @RequestBody NvrScheduleInsertDto nvrScheduleInsertDto,
                                                 BindingResult bindingResult) {

        nvrScheduleDtoValidator.validate(nvrScheduleInsertDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
            return setFailResult(fieldErrors);
        }
        nvrScheduleService.update(nvrScheduleInsertDto);
        return setSuccessResult();
    }

    @DeleteMapping("{scheduleId}")
    @Operation(summary = "NVR 스케쥴 삭제", description = "NVR 스케쥴을 삭제합니다.")
    public ResponseEntity<ApiResponseDto> delete(@Parameter(description = "스케쥴아이디", required = true, example = "SCHEDULE0005") @PathVariable String scheduleId) {
        nvrScheduleService.deleteByScheduleId(scheduleId);
        return setSuccessResult();
    }
}
