package com.mangopuree.support.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    MENU_NOT_FOUND ("ERR_SYS_001", "errorCode.menu.notFound")
    , PARENT_MENU_NOT_FOUND ("ERR_SYS_002", "errorCode.parentMenu.notFound")

    , API_TIMEOUT ("ERR_API_001", "errorCode.api.timeout")
    , API_FAIL ("ERR_API_002", "errorCode.api.fail");

    private final String code;
    private final String messageKey;

    ErrorCode(String code, String messageKey) {
        this.code = code;
        this.messageKey = messageKey;
    }

}
