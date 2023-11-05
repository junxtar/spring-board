package com.sparta.springboard.domain.board;

import com.sparta.springboard.global.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String writer;
    private String content;
    private String password;

    @Builder
    private BoardEntity(String writer, String content, String password) {
        this.writer = writer;
        this.content = content;
        this.password = password;
    }

    public static BoardEntity create(String writer, String content, String password) {
        return BoardEntity.builder()
                .writer(writer)
                .content(content)
                .password(password)
                .build();
    }
}
