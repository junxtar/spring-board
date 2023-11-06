package com.sparta.springboard.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    BOARD_NOT_FOUNT(HttpStatus.NOT_FOUND, "게시물을 찾을 수 없습니다."),
    PASSWORD_NOT_MATCH(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");

    private final HttpStatus status;
    private final String message;

}
