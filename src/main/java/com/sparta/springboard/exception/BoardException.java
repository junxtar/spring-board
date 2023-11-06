package com.sparta.springboard.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardException extends RuntimeException {

    private boolean result;
    private ErrorCode errorCode;
    private String message;

    @Builder
    public BoardException(ErrorCode errorCode) {
        this.result = false;
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }
}
