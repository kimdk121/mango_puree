package com.mangopuree.user.controller;

import com.mangopuree.support.base.BaseContoller;
import com.mangopuree.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/user")
@RequiredArgsConstructor
public class UserController extends BaseContoller {

    private final UserService userService;

    /**
     * 사용자 화면 호출
     */
    @GetMapping
    public String listForm() {
        return "admin/user/list";
    }

}
