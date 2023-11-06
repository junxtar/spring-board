package com.sparta.springboard.api.service.board.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardDeleteServiceRequest {

    private String password;

    @Builder
    private BoardDeleteServiceRequest (String password) {
        this.password = password;
    }

}
