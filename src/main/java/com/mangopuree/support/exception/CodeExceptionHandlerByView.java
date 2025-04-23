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
public class CodeExceptionHandlerByView {

    private final MessageUtil messageUtil;

    @ExceptionHandler(CodeException.class)
    public String handleCodeExceptionByView(CodeException e, Model model) {
        String errorCode = e.getErrorCode().getCode();
        String errorMessage = messageUtil.get(e.getErrorCode().getMessageKey());

        log.error("ERROR CODE = {}", errorCode);
        log.error("ERROR MESSAGE = {}", errorMessage);

        model.addAttribute("errorCode", errorCode);
        model.addAttribute("errorMessage", errorMessage);

        return "error/500";
    }
}
