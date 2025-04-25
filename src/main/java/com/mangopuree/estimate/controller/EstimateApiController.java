package com.mangopuree.estimate.controller;

import com.mangopuree.estimate.dto.EstimateDto;
import com.mangopuree.estimate.dto.EstimateGridDto;
import com.mangopuree.estimate.dto.EstimateInsertDto;
import com.mangopuree.estimate.dto.EstimateSearchDto;
import com.mangopuree.estimate.service.EstimateService;
import com.mangopuree.support.base.BaseController;
import com.mangopuree.support.base.dto.ApiResponseDto;
import com.mangopuree.support.exception.CodeException;
import com.mangopuree.support.grid.dto.SetGridDataDto;
import com.mangopuree.support.validator.EstimateDtoValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/estimate")
public class EstimateApiController extends BaseController {

    private final EstimateService estimateService;
    private final EstimateDtoValidator estimateDtoValidator;

    @PostMapping("/insert")
    @Operation(summary = "견적서 등록", description = "견적서와 견적서 품목을 등록합니다.")
    public ResponseEntity<ApiResponseDto> insert(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "견적서 등록 DTO", required = true) @RequestBody EstimateInsertDto estimateInsertDto,
                                                 BindingResult bindingResult) {
        if(estimateInsertDto.getEstimateStatusCd() != null && "ESS002".equals(estimateInsertDto.getEstimateStatusCd())) {
            estimateDtoValidator.validate(estimateInsertDto, bindingResult);
            if (bindingResult.hasErrors()) {
                Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
                return setFailResult(fieldErrors);
            }
        }
        estimateService.insert(estimateInsertDto);
        return setSuccessResult();
    }

    @PostMapping("/update")
    @Operation(summary = "견적서 수정", description = "견적서와 견적서 품목을 수정합니다.")
    public ResponseEntity<ApiResponseDto> update(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "견적서 수정 DTO", required = true) @RequestBody EstimateInsertDto estimateInsertDto,
                                                 BindingResult bindingResult) {

        if(estimateInsertDto.getEstimateStatusCd() != null && "ESS002".equals(estimateInsertDto.getEstimateStatusCd())) {
            estimateDtoValidator.validate(estimateInsertDto, bindingResult);
            if (bindingResult.hasErrors()) {
                Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
                return setFailResult(fieldErrors);
            }
        }
        estimateService.update(estimateInsertDto);
        return setSuccessResult();
    }

    @GetMapping("/list")
    @Operation(summary = "견적서 Grid 정보 조회", description = "조건에 따른 견적서 Grid 정보를 조회합니다.")
    public ResponseEntity<ApiResponseDto> list(@ModelAttribute EstimateSearchDto estimateSearchDto) {
        estimateSearchDto.calculatePaging();
        List<EstimateGridDto> estimateGridDtos = estimateService.estimateListByGrid(estimateSearchDto);
        int totalCount = 0;
        if (estimateGridDtos.size() > 0) {
            totalCount = estimateGridDtos.get(0).getTotalCount();
        }
        SetGridDataDto data = setGridData(estimateSearchDto, estimateGridDtos, totalCount);
        return setSuccessResult(data);
    }

    @GetMapping("/{estimateId}")
    @Operation(summary = "견적서 상세조회", description = "견적서와 견적서 품목을 조회합니다.")
    public ResponseEntity<ApiResponseDto> getEstimateDetail(@Parameter(description = "견적서아이디", required = true, example = "EST25040700010") @PathVariable String estimateId) {
        EstimateDto estimateDto = estimateService.findEstimateDetail(estimateId);
        return setSuccessResult(estimateDto);
    }

    @DeleteMapping("/{estimateId}")
    @Operation(summary = "견적서 삭제", description = "견적서와 견적서 품목을 삭제합니다.")
    public ResponseEntity<ApiResponseDto> delete(@Parameter(description = "견적서아이디", required = true, example = "EST25040700010") @PathVariable String estimateId) {
        estimateService.delete(estimateId);
        return setSuccessResult();
    }

    @PostMapping("/update/{estimateId}/estimateStatusCd")
    @Operation(summary = "견적서의 상태 변경", description = "견적서의 상태를 확정으로 변경합니다.")
    public ResponseEntity<ApiResponseDto> update(@Parameter(description = "견적서아이디", required = true, example = "EST25040700010") @PathVariable String estimateId) {
        estimateService.confirmEstimateStatus(estimateId);
        return setSuccessResult();
    }

    @GetMapping("/{estimateId}/downloadEstimateToExcel")
    @Operation(summary = "견적서 엑셀 다운로드", description = "견적서를 조회하여 엑셀문서로 다운로드 합니다.")
    public ResponseEntity<Resource> downloadEstimateToExcel(@Parameter(description = "견적서아이디", required = true, example = "EST25041900001") @PathVariable String estimateId) {

        byte[] fileBytes = null;
        try {
            fileBytes = estimateService.makeEstimateToExcel(estimateId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String filename = UriUtils.encode("견적서.xlsx", StandardCharsets.UTF_8) ;
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ filename +"\"")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
                .body(new ByteArrayResource(fileBytes));
    }
}
