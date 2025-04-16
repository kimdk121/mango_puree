package com.mangopuree.vendor.controller;

import com.mangopuree.support.base.BaseContoller;
import com.mangopuree.vendor.dto.VendorGridDto;
import com.mangopuree.vendor.dto.VendorSearchDto;
import com.mangopuree.vendor.service.VendorService;
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
@RequestMapping("/api/vendor")
public class VendorApiController extends BaseContoller {

    private final VendorService vendorService;

    /**
     * API 거래처 Grid 호출
     */
    @GetMapping("/list")
    public Map<String, Object> list(@ModelAttribute VendorSearchDto vendorSearchDto) {
        ModelMap model = new ModelMap();
        vendorSearchDto.calculatePaging();
        List<VendorGridDto> vendorGridDtos = vendorService.vendorListByGrid(vendorSearchDto);
        int totalCount = 0;
        if (vendorGridDtos.size() > 0) {
            totalCount = vendorGridDtos.get(0).getTotalCount();
        }
        Map<String, Object> data = setGridData(vendorSearchDto, vendorGridDtos, totalCount);
        model.addAttribute("data", data);

        return setSuccessResult(model);
    }
}
