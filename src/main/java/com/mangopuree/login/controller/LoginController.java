package com.mangopuree.login.controller;

import com.mangopuree.support.base.BaseContoller;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController extends BaseContoller {

    /**
     * 로그인 화면 호출
     */
    @GetMapping
    public String login(@RequestParam(value = "error", required = false, defaultValue = "false") boolean error,
                        HttpSession session,
                        Model model) {
        if (error) {
            model.addAttribute("errorMessage", session.getAttribute("errorMessage"));
            session.removeAttribute("errorMessage");
        }
        return "login/login";
    }

    /**
     * 회원가입 화면 호출
     */
    @GetMapping("/signup")
    public String signup() {

        return "login/signup";
    }
}
