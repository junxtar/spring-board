package com.sparta.springboard.api.service.board;

import com.sparta.springboard.api.service.board.dto.request.BoardCreateServiceRequest;
import com.sparta.springboard.api.service.board.dto.response.BoardResponse;
import com.sparta.springboard.domain.board.BoardEntity;
import com.sparta.springboard.domain.board.BoardRepository;
import com.sparta.springboard.global.util.Encryption;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardResponse getBoard(Long id) {
        return boardRepository.findById(id)
                .map(BoardResponse::of)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
    }

    public List<BoardResponse> getBoards() {
        return boardRepository.findAll().stream()
                .map(BoardResponse::of)
                .collect(Collectors.toList());
    }

    public BoardResponse createBoard(BoardCreateServiceRequest boardCreateServiceRequest) {
        BoardEntity board = BoardEntity.create(
                boardCreateServiceRequest.getWriter(),
                boardCreateServiceRequest.getContent(),
                Encryption.encryption(boardCreateServiceRequest.getPassword()));
        BoardEntity saveBoard = boardRepository.save(board);

        return BoardResponse.of(saveBoard);
    }
}
