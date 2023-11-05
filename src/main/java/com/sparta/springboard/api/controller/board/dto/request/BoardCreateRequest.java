package com.sparta.springboard.api.controller.board.dto.request;

import com.sparta.springboard.api.service.board.dto.request.BoardCreateServiceRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardCreateRequest {

    private String writer;
    private String content;
    private String password;

    public BoardCreateServiceRequest toServiceRequest() {
        return BoardCreateServiceRequest.builder()
                .writer(writer)
                .content(content)
                .password(password)
                .build();
    }
}
