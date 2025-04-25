package com.mangopuree.nvrcamera.controller;

import com.mangopuree.nvrcamera.dto.NvrCameraDto;
import com.mangopuree.nvrcamera.service.NvrCameraService;
import com.mangopuree.support.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/nvrcamera")
public class NvrCameraController extends BaseController {

    private final NvrCameraService nvrCameraService;

    /**
     * 리스트 페이지 조회
     * @param model
     * @return view
     */
    @GetMapping
    public String list(Model model) {
        List<NvrCameraDto> cameraList = nvrCameraService.findActiveCameras();
        model.addAttribute("cameraList", cameraList);
        return "admin/nvrcamera/list";
    }

}
