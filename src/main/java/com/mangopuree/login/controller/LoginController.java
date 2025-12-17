package com.mangopuree.login.controller;

import com.mangopuree.support.base.BaseController;
import com.mangopuree.support.message.MessageUtil;
import com.mangopuree.user.dto.UserSignupDto;
import com.mangopuree.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    private final UserDetailsService userDetailsService;

    /**
     * 로그인 페이지 조회
     * @param error 에러 여부
     * @param success 성공 여부
     * @param session 에러 메세지나 성공 메세지가 담겨있을 수 있음
     * @param model
     * @return view
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
     * 회원가입 페이지 조회
     * @param model
     * @return view
     */
    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("userSignupDto", new UserSignupDto());
        return "login/signup";
    }

    /**
     * 회원가입
     * @param userSignupDto
     * @param bindingResult
     * @param request
     * @return view
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
        // 회원가입 성공 메세지 담음
        request.getSession().setAttribute("successMessage","signup.success");
        return "redirect:/login?success=true";
    }

    /**
     * 게스트로그인
     * @param request
     * @return main
     */
    @GetMapping("/guest")
    public String guestLogin(HttpServletRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername("guest");
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

        return "redirect:/admin/main";
    }
}
