package com.sparta.springboard.api.controller.board.dto.request;

import com.sparta.springboard.api.service.board.dto.request.BoardCreateServiceRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardCreateRequest {

    private String writer;
    private String content;
    private String password;

    @Builder
    private BoardCreateRequest(String writer, String content, String password) {
        this.writer = writer;
        this.content = content;
        this.password = password;
    }

    public BoardCreateServiceRequest toServiceRequest() {
        return BoardCreateServiceRequest.builder()
                .writer(writer)
                .content(content)
                .password(password)
                .build();
    }
}
