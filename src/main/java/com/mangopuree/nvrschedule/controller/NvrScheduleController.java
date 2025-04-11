package com.mangopuree.nvrschedule.controller;

import com.mangopuree.nvrschedule.dto.NvrScheduleInsertDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/nvrschedule")
public class NvrScheduleController {


    @GetMapping
    public String list() {
        return "admin/nvrschedule/list";
    }

    @GetMapping("/insert")
    public String insertForm(Model model) {
        model.addAttribute("scheduleDto", new NvrScheduleInsertDto());
        return "admin/nvrschedule/insert";
    }
}
