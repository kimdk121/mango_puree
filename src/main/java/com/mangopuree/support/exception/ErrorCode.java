package com.mangopuree.support.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    MENU_NOT_FOUND ("E001", "errorCode.menu.notFound")
    , PARENT_MENU_NOT_FOUND ("E002", "errorCode.parentMenu.notFound");

    private final String code;
    private final String messageKey;

    ErrorCode(String code, String messageKey) {
        this.code = code;
        this.messageKey = messageKey;
    }

}
