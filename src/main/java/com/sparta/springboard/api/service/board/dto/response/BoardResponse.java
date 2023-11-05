package com.sparta.springboard.api.service.board.dto.response;

import com.sparta.springboard.domain.board.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardResponse {

    private Long id;
    private String title;
    private String writer;
    private String content;

    @Builder
    private BoardResponse(Long id, String title, String writer, String content) {
        this.title = title;
        this.id = id;
        this.writer = writer;
        this.content = content;
    }

    public static BoardResponse of(BoardEntity board) {
        return BoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .writer(board.getWriter())
                .content(board.getContent())
                .build();
    }
}
