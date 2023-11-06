package com.sparta.springboard.exception.handler;

import com.sparta.springboard.exception.BoardException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BoarderExceptionHandler {
    @ExceptionHandler(BoardException.class)
    public ResponseEntity<BoardException> BoardExceptionHandler(BoardException e) {
        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(BoardException.builder()
                        .errorCode(e.getErrorCode())
                        .build());
    }
}
