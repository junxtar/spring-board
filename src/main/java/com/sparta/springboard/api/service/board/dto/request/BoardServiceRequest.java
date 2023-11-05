package com.sparta.springboard.api.service.board.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardCreateServiceRequest {
    private String title;
    private String writer;
    private String content;
    private String password;

    @Builder
    private BoardCreateServiceRequest(String title, String writer, String content, String password) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.password = password;
    }
}
