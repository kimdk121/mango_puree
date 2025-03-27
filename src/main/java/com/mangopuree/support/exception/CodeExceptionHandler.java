package com.mangopuree.support.exception;

import com.mangopuree.support.message.MessageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class CodeExceptionHandler {

    private final MessageUtil messageUtil;

    @ExceptionHandler(CodeException.class)
    public String handleCodeException(CodeException ex, Model model) {
        String errorCode = ex.getErrorCode().getCode();
        String errorMessage = messageUtil.get(ex.getErrorCode().getMessageKey());

        log.error("ERROR CODE = {}", errorCode);
        log.error("ERROR MESSAGE = {}", errorMessage);

        model.addAttribute("errorCode", errorCode);
        model.addAttribute("errorMessage", errorMessage);

        return "error/500";
    }
}
