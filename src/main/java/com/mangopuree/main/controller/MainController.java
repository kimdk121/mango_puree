package com.mangopuree.main.controller;

import com.mangopuree.support.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/main")
public class MainController extends BaseController {

    /**
     * 메인 페이지 조회
     * @return view
     */
    @GetMapping
    public String mainForm() {
        return "admin/main";
    }
}
