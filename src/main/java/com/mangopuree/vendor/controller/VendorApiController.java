package com.mangopuree.vendor.controller;

import com.mangopuree.support.base.BaseController;
import com.mangopuree.support.base.dto.ApiResponseDto;
import com.mangopuree.support.grid.dto.SetGridDataDto;
import com.mangopuree.vendor.dto.VendorGridDto;
import com.mangopuree.vendor.dto.VendorSearchDto;
import com.mangopuree.vendor.service.VendorService;
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

    /**
     * API 거래처 Grid 호출
     */
    @GetMapping("/list")
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
