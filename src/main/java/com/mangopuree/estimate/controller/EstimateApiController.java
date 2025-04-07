package com.mangopuree.estimate.controller;

import com.mangopuree.estimate.dto.EstimateDraftDto;
import com.mangopuree.estimate.dto.EstimateSubmitDto;
import com.mangopuree.estimate.service.EstimateService;
import com.mangopuree.support.base.BaseContoller;
import com.mangopuree.support.security.LoginUserHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/estimate")
public class EstimateApiController extends BaseContoller {

    private final EstimateService estimateService;

    @PostMapping("/insert/temp")
    public Map<String, Object> insertTemp(@RequestBody EstimateDraftDto estimateDraftDto, BindingResult bindingResult) {
        ModelMap model = new ModelMap();
        if (bindingResult.hasErrors()) {
            Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
            return setFailResult(model, fieldErrors);
        }
        estimateService.insertTemp(estimateDraftDto);
        return setSuccessResult(model);
    }

    @PostMapping("/insert/done")
    public Map<String, Object> insertDone(@Validated @RequestBody EstimateSubmitDto estimateSubmitDto, BindingResult bindingResult) {
        ModelMap model = new ModelMap();
        if (bindingResult.hasErrors()) {
            Map<String, List<String>> fieldErrors = setFieldErrors(bindingResult);
            return setFailResult(model, fieldErrors);
        }
        estimateService.insertDone(estimateSubmitDto);
        return setSuccessResult(model);
    }
}
