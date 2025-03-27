package com.mangopuree.support.exception;

import lombok.Getter;

@Getter
public class CodeException extends RuntimeException {

    private final ErrorCode errorCode;

    public CodeException(ErrorCode errorCode) {
        super(errorCode.getMessageKey());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
