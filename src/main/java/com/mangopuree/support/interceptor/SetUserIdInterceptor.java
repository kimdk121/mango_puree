package com.mangopuree.support.interceptor;

import com.mangopuree.support.security.CustomUserDetails;
import com.mangopuree.support.security.LoginUserHolder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

public class SetUserIdInterceptor implements HandlerInterceptor {

    // 유저아이디 쓰레드로컬에 저장
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated()) {
            LoginUserHolder.setUserId(authentication.getName());

            if (authentication.getPrincipal() instanceof CustomUserDetails) {
                CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
                LoginUserHolder.setUsername(principal.getLoginId());
            }

        }

        return true;
    }

    // 쓰레드로컬 클리어
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LoginUserHolder.clear();
    }
}
