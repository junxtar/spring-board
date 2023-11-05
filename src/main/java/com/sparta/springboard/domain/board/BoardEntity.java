package com.sparta.springboard.domain.board;

import com.sparta.springboard.global.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String writer;
    private String content;
    private String password;

    @Builder
    public BoardEntity (String writer, String content, String password) {
        this.writer = writer;
        this.content = content;
        this.password = password;
    }
}
