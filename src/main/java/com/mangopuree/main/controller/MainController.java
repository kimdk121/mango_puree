package com.mangopuree.main.controller;

import com.mangopuree.support.base.BaseContoller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/main")
public class MainController extends BaseContoller {

    /**
     * 메인 페이지 호출
     */
    @GetMapping
    public String mainPage() {
        return "main";
    }
}
