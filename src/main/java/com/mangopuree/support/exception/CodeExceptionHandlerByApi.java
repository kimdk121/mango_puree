package com.mangopuree.support.exception;

import com.mangopuree.support.message.MessageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class CodeExceptionHandlerByApi {

    private final MessageUtil messageUtil;

    @ExceptionHandler(CodeException.class)
    public ResponseEntity<Map<String, String>> handleCodeExceptionByApi(CodeException e) {
        String errorCode = e.getErrorCode().getCode();
        String errorMessage = messageUtil.get(e.getErrorCode().getMessageKey());

        log.error("ERROR CODE = {}", errorCode);
        log.error("ERROR MESSAGE = {}", errorMessage);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of(
                        "errorCode", errorCode,
                        "errorMessage", errorMessage
                ));
    }
}
