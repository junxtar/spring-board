package com.sparta.springboard.api.service.board;

import com.sparta.springboard.api.service.board.dto.request.BoardCreateServiceRequest;
import com.sparta.springboard.api.service.board.dto.response.BoardCreateResponse;
import com.sparta.springboard.domain.board.BoardEntity;
import com.sparta.springboard.domain.board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardCreateResponse createBoard(BoardCreateServiceRequest boardCreateServiceRequest) {
        BoardEntity board = BoardEntity.create(
                boardCreateServiceRequest.getWriter(),
                boardCreateServiceRequest.getContent(),
                boardCreateServiceRequest.getPassword());

        BoardEntity saveBoard = boardRepository.save(board);

        return BoardCreateResponse.of(saveBoard);
    }
}
