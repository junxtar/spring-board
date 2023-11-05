package com.sparta.springboard.api.service.board.dto.response;

import com.sparta.springboard.domain.board.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardCreateResponse {

    private Long id;
    private String writer;
    private String content;

    @Builder
    private BoardCreateResponse(Long id, String writer, String content) {
        this.id = id;
        this.writer = writer;
        this.content = content;
    }

    public static BoardCreateResponse of(BoardEntity board) {
        return BoardCreateResponse.builder()
                .id(board.getId())
                .writer(board.getWriter())
                .content(board.getContent())
                .build();
    }
}
