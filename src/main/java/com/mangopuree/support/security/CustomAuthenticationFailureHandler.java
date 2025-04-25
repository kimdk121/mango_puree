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

    /**
     * 로그인 실패 세션에 실패 메세지 저장
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {

        String errorMessage;

        if(exception instanceof BadCredentialsException){
            errorMessage = "login.fail.badCredentials";
        }
        else{
            errorMessage = "login.fail.unknown";
        }
        request.getSession().setAttribute("errorMessage", errorMessage);
        response.sendRedirect(failUrl + "?error=true");
    }

}