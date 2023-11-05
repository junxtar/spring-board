package com.sparta.springboard.api.controller.board.dto.request;

import com.sparta.springboard.api.service.board.dto.request.BoardServiceRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardRequest {

    private String title;
    private String writer;
    private String content;
    private String password;

    public BoardServiceRequest toServiceRequest() {
        return BoardServiceRequest.builder()
                .title(title)
                .writer(writer)
                .content(content)
                .password(password)
                .build();
    }
}
