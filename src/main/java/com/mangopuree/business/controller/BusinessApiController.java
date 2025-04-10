package com.mangopuree.business.controller;

import com.mangopuree.business.dto.BusinessGridDto;
import com.mangopuree.business.dto.BusinessSearchDto;
import com.mangopuree.business.service.BusinessService;
import com.mangopuree.support.base.BaseContoller;
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
@RequestMapping("/api/business")
public class BusinessApiController extends BaseContoller {

    private final BusinessService businessService;

    /**
     * API 사업자 Grid 호출
     */
    @GetMapping("/list")
    public Map<String, Object> list(@ModelAttribute BusinessSearchDto businessSearchDto) {
        ModelMap model = new ModelMap();
        businessSearchDto.calculatePaging();
        List<BusinessGridDto> businessGridDtos = businessService.businessListByGrid(businessSearchDto);
        if (businessGridDtos == null) {
            return setFailResult(model);
        }
        int totalCount = businessGridDtos.get(0).getTotalCount();

        Map<String, Object> data = setGridData(businessSearchDto, businessGridDtos, totalCount);
        model.addAttribute("data", data);

        return setSuccessResult(model);
    }
}
