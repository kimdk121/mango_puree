package com.mangopuree.support.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class MessageUtil {

    private final MessageSource messageSource;

    /**
     * 메시지 코드로 메시지 반환 (기본 로케일)
     */
    public String get(String code) {
        return messageSource.getMessage(code, null, Locale.getDefault());
    }

    /**
     * 메시지 코드 + 파라미터 (기본 로케일)
     */
    public String get(String code, Object... args) {
        return messageSource.getMessage(code, args, Locale.getDefault());
    }

    /**
     * 메시지 코드 + 파라미터 + 로케일
     */
    public String get(String code, Object[] args, Locale locale) {
        return messageSource.getMessage(code, args, locale);
    }
}
