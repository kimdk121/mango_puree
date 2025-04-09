package com.mangopuree.estimate.controller;

import com.mangopuree.estimate.dto.*;
import com.mangopuree.estimate.service.EstimateService;
import com.mangopuree.support.base.BaseContoller;
import com.mangopuree.support.security.LoginUserHolder;
import com.mangopuree.support.validator.EstimateDtoValidator;
import com.mangopuree.user.dto.UserGridDto;
import com.mangopuree.user.dto.UserSearchDto;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/estimate")
public class EstimateApiController extends BaseContoller {

    private final EstimateService estimateService;
    private final EstimateDtoValidator estimateDtoValidator;

    @PostMapping("/insert")
    public Map<String, Object> insert(@RequestBody EstimateInsertDto estimateInsertDto, BindingResult bindingResult) {
        ModelMap model = new ModelMap();

        if(estimateInsertDto.getEstimateStatusCd() != null && "ESS002".equals(estimateInsertDto.getEstimateStatusCd())) {
            estimateDtoValidator.validate(estimateInsertDto, bindingResult);
            if (bindingResult.hasErrors()) {
                Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
                return setFailResult(model, fieldErrors);
            }
        }
        estimateService.insert(estimateInsertDto);
        return setSuccessResult(model);
    }

    @PostMapping("/update/{estimateId}")
    public Map<String, Object> update(@RequestBody EstimateInsertDto estimateInsertDto, BindingResult bindingResult) {
        ModelMap model = new ModelMap();

        if(estimateInsertDto.getEstimateStatusCd() != null && "ESS002".equals(estimateInsertDto.getEstimateStatusCd())) {
            estimateDtoValidator.validate(estimateInsertDto, bindingResult);
            if (bindingResult.hasErrors()) {
                Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
                return setFailResult(model, fieldErrors);
            }
        }
        estimateService.update(estimateInsertDto);
        return setSuccessResult(model);
    }

    /**
     * API 견적서 전체 Grid 호출
     */
    @GetMapping("/list")
    public Map<String, Object> list(@ModelAttribute EstimateSearchDto estimateSearchDto) {
        ModelMap model = new ModelMap();
        estimateSearchDto.calculatePaging();
        List<EstimateGridDto> estimateGridDtos = estimateService.estimateListByGrid(estimateSearchDto);
        if (estimateGridDtos == null) {
            return setFailResult(model);
        }
        int totalCount = estimateGridDtos.get(0).getTotalCount();

        Map<String, Object> data = setGridData(estimateSearchDto, estimateGridDtos, totalCount);
        model.addAttribute("data", data);

        return setSuccessResult(model);
    }

    @GetMapping("/{estimateId}")
    public Map<String, Object> getEstimateDetail(@PathVariable String estimateId) {
        ModelMap model = new ModelMap();
        EstimateDto estimateDto = estimateService.findEstimateDetail(estimateId);
        model.addAttribute("estimate", estimateDto);
        return setSuccessResult(model);
    }

    @DeleteMapping("/{estimateId}")
    public Map<String, Object> delete(@PathVariable String estimateId) {
        ModelMap model = new ModelMap();
        return setSuccessResult(model);
    }
}
