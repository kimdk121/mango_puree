package com.mangopuree.estimate.controller;

import com.mangopuree.estimate.dto.EstimateDto;
import com.mangopuree.estimate.dto.EstimateGridDto;
import com.mangopuree.estimate.dto.EstimateInsertDto;
import com.mangopuree.estimate.dto.EstimateSearchDto;
import com.mangopuree.estimate.service.EstimateService;
import com.mangopuree.support.base.BaseController;
import com.mangopuree.support.base.dto.ApiResponseDto;
import com.mangopuree.support.grid.dto.SetGridDataDto;
import com.mangopuree.support.validator.EstimateDtoValidator;
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
    public ResponseEntity<ApiResponseDto> insert(@RequestBody EstimateInsertDto estimateInsertDto, BindingResult bindingResult) {

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
    public ResponseEntity<ApiResponseDto> update(@RequestBody EstimateInsertDto estimateInsertDto, BindingResult bindingResult) {

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

    /**
     * API 견적서 전체 Grid 호출
     */
    @GetMapping("/list")
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
    public ResponseEntity<ApiResponseDto> getEstimateDetail(@PathVariable String estimateId) {
        EstimateDto estimateDto = estimateService.findEstimateDetail(estimateId);
        return setSuccessResult(estimateDto);
    }

    @DeleteMapping("/{estimateId}")
    public ResponseEntity<ApiResponseDto> delete(@PathVariable String estimateId) {
        estimateService.delete(estimateId);
        return setSuccessResult();
    }

    @PostMapping("/update/{estimateId}/estimateStatusCd")
    public ResponseEntity<ApiResponseDto> update(@PathVariable String estimateId) {
        estimateService.confirmEstimateStatus(estimateId);
        return setSuccessResult();
    }

    @GetMapping("/{estimateId}/downloadEstimateToExcel")
    public ResponseEntity<Resource> downloadEstimateToExcel(@PathVariable String estimateId) {

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
