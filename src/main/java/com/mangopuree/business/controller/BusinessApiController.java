package com.mangopuree.business.controller;

import com.mangopuree.business.dto.BusinessGridDto;
import com.mangopuree.business.dto.BusinessSearchDto;
import com.mangopuree.business.service.BusinessService;
import com.mangopuree.support.base.BaseController;
import com.mangopuree.support.base.dto.ApiResponseDto;
import com.mangopuree.support.grid.dto.SetGridDataDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@RequestMapping("/api/business")
public class BusinessApiController extends BaseController {

    private final BusinessService businessService;

    @GetMapping("/list")
    @Operation(summary = "사업자 Grid 정보 조회", description = "조건에 따른 사업자 Grid 정보를 조회합니다.")
    public ResponseEntity<ApiResponseDto> list(@ModelAttribute BusinessSearchDto businessSearchDto) {
        businessSearchDto.calculatePaging();
        List<BusinessGridDto> businessGridDtos = businessService.businessListByGrid(businessSearchDto);
        int totalCount = 0;
        if (businessGridDtos.size() > 0) {
            totalCount = businessGridDtos.get(0).getTotalCount();
        }
        SetGridDataDto data = setGridData(businessSearchDto, businessGridDtos, totalCount);
        return setSuccessResult(data);
    }
}
