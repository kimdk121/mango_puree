package com.mangopuree.login.controller;

import com.mangopuree.support.base.BaseController;
import com.mangopuree.support.message.MessageUtil;
import com.mangopuree.user.dto.UserSignupDto;
import com.mangopuree.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController extends BaseController {

    private final UserService userService;
    private final MessageUtil messageUtil;

    /**
     * 로그인 화면 호출
     */
    @GetMapping
    public String loginForm(@RequestParam(value = "error", required = false, defaultValue = "false") boolean error,
                            @RequestParam(value = "success", required = false, defaultValue = "false") boolean success,
                            HttpSession session,
                            Model model) {
        if (error && session.getAttribute("errorMessage") != null) {
            model.addAttribute("errorMessage", messageUtil.get(session.getAttribute("errorMessage").toString()));
            session.removeAttribute("errorMessage");
        }
        if (success && session.getAttribute("successMessage") != null) {
            model.addAttribute("successMessage", messageUtil.get(session.getAttribute("successMessage").toString()));
            session.removeAttribute("successMessage");
        }
        return "login/login";
    }

    /**
     * 회원가입 화면 호출
     */
    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("userSignupDto", new UserSignupDto());
        return "login/signup";
    }

    /**
     * 회원가입
     */
    @PostMapping("/signup")
    public String signup(@Validated @ModelAttribute("userSignupDto") UserSignupDto userSignupDto,
                         BindingResult bindingResult,
                         HttpServletRequest request) {

        // 검증
        if (bindingResult.hasErrors()) {
            return "login/signup";
        }
        if (userService.existsByUsername(userSignupDto.getUsername())) {
            bindingResult.rejectValue("username", "duplication.username");
            return "login/signup";
        }
        if (!userSignupDto.isPasswordMatching()) {
            bindingResult.rejectValue("password", "mismatch.password");
            return "login/signup";
        }
        // 회원가입 처리
        try {
            userService.insertUser(userSignupDto);
        } catch (DuplicateKeyException e) {
            bindingResult.rejectValue("username", "duplication.username");
            return "login/signup";
        }
        request.getSession().setAttribute("successMessage","signup.success");
        return "redirect:/login?success=true";
    }

}
