package com.sparta.springboard.api.controller.board.dto.request;

import com.sparta.springboard.api.service.board.dto.request.BoardDeleteServiceRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardDeleteRequest {

    private String password;

    public BoardDeleteServiceRequest toServiceRequest() {
        return BoardDeleteServiceRequest.builder()
                .password(password)
                .build();
    }
}
