package com.mangopuree.support.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

@RequiredArgsConstructor
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final String failUrl;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {

        String errorMsg;

        if(exception instanceof BadCredentialsException){
            errorMsg = "아이디나 비밀번호가 맞지 않습니다. 다시 확인해 주세요.";
        }
        else{
            errorMsg = "알수없는 이유로 로그인에 실패하였습니다.";
        }
        request.getSession().setAttribute("errorMessage", errorMsg);
        response.sendRedirect(failUrl + "?error=true");
    }

}