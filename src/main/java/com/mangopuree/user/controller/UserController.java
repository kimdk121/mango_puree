package com.mangopuree.user.controller;

import com.mangopuree.support.base.BaseController;
import com.mangopuree.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/user")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserService userService;

    /**
     * 리스트 페이지 조회
     * @return view
     */
    @GetMapping
    public String listForm() {
        return "admin/user/list";
    }

}
