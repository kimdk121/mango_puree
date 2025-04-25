package com.mangopuree.nvrschedule.controller;

import com.mangopuree.nvrcamera.dto.NvrCameraDto;
import com.mangopuree.nvrcamera.service.NvrCameraService;
import com.mangopuree.nvrschedule.dto.NvrScheduleInsertDto;
import com.mangopuree.nvrschedule.service.NvrScheduleService;
import com.mangopuree.support.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/nvrschedule")
public class NvrScheduleController extends BaseController {

    private final NvrCameraService nvrCameraService;

    /**
     * 리스트 페이지 조회
     * @param cameraId 조회 조건에 추가
     * @param model
     * @return view
     */
    @GetMapping
    public String list(@RequestParam(required = false) String cameraId, Model model) {
        List<NvrCameraDto> cameraList = nvrCameraService.findActiveCameras();
        model.addAttribute("nvrScheduleInsertDto", new NvrScheduleInsertDto());
        model.addAttribute("today", LocalDate.now());
        model.addAttribute("selectedCameraId", cameraId);
        model.addAttribute("cameraList", cameraList);
        return "admin/nvrschedule/list";
    }

}
