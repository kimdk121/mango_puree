package com.mangopuree.nvrcamera.controller;

import com.mangopuree.nvrcamera.dto.NvrCameraDto;
import com.mangopuree.nvrcamera.service.NvrCameraService;
import com.mangopuree.support.base.BaseContoller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/nvrcamera")
public class NvrCameraController extends BaseContoller {

    private final NvrCameraService nvrCameraService;

    @GetMapping
    public String list(Model model) {
        List<NvrCameraDto> cameraList = nvrCameraService.findActiveCameras();
        model.addAttribute("cameraList", cameraList);
        return "admin/nvrcamera/list";
    }

}
