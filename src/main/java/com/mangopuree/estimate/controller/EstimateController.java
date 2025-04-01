package com.mangopuree.estimate.controller;

import com.mangopuree.code.service.CodeService;
import com.mangopuree.estimate.service.EstimateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/estimate")
public class EstimateController {

    private final EstimateService estimateService;
    private final CodeService codeService;

    @GetMapping
    public String listForm() {
        return "admin/estimate/list";
    }

    @GetMapping("/insert")
    public String insertForm(Model model) {
        model.addAttribute("estimateStatusList",codeService.getCodeListByCodeGroupId("ESTIMATE_STATUS"));
        model.addAttribute("validDateList",codeService.getCodeListByCodeGroupId("VALID_DATE"));
        return "admin/estimate/insert";
    }

    @GetMapping("/{id}")
    public String detailForm() {
        return "admin/estimate/detail";
    }

    @GetMapping("/{id}/edit")
    public String edltForm() {
        return "admin/estimate/edit";
    }

}
