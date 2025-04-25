package com.mangopuree.vendor.controller;

import com.mangopuree.support.base.BaseController;
import com.mangopuree.support.base.dto.ApiResponseDto;
import com.mangopuree.support.grid.dto.SetGridDataDto;
import com.mangopuree.vendor.dto.VendorGridDto;
import com.mangopuree.vendor.dto.VendorSearchDto;
import com.mangopuree.vendor.service.VendorService;
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
@RequestMapping("/api/vendor")
public class VendorApiController extends BaseController {

    private final VendorService vendorService;

    @GetMapping("/list")
    @Operation(summary = "거래처 Grid 정보 조회", description = "조건에 따른 거래처 Grid 정보를 조회합니다.")
    public ResponseEntity<ApiResponseDto> list(@ModelAttribute VendorSearchDto vendorSearchDto) {

        vendorSearchDto.calculatePaging();
        List<VendorGridDto> vendorGridDtos = vendorService.vendorListByGrid(vendorSearchDto);
        int totalCount = 0;
        if (vendorGridDtos.size() > 0) {
            totalCount = vendorGridDtos.get(0).getTotalCount();
        }
        SetGridDataDto data = setGridData(vendorSearchDto, vendorGridDtos, totalCount);
        return setSuccessResult(data);
    }
}
