package com.sparta.springboard.api.service.board;

import com.sparta.springboard.api.service.board.dto.request.BoardDeleteServiceRequest;
import com.sparta.springboard.api.service.board.dto.request.BoardServiceRequest;
import com.sparta.springboard.api.service.board.dto.response.BoardResponse;
import com.sparta.springboard.domain.board.BoardEntity;
import com.sparta.springboard.domain.board.BoardRepository;
import com.sparta.springboard.global.util.Encryption;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public BoardResponse getBoard(Long id) {
        return BoardResponse.of(existsBoard(id));
    }

    public List<BoardResponse> getBoards() {
        return boardRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(BoardResponse::of)
                .collect(Collectors.toList());
    }

    public BoardResponse createBoard(BoardServiceRequest boardServiceRequest) {
        BoardEntity board = BoardEntity.create(
                boardServiceRequest.getTitle(),
                boardServiceRequest.getWriter(),
                boardServiceRequest.getContent(),
                Encryption.encryption(boardServiceRequest.getPassword()));

        BoardEntity saveBoard = boardRepository.save(board);

        return BoardResponse.of(saveBoard);
    }

    @Transactional
    public BoardResponse updateBoard(BoardServiceRequest boardServiceRequest, Long id) {
        String requestPassword = Encryption.encryption(boardServiceRequest.getPassword());
        BoardEntity board = existsBoard(id);
        if (board.getPassword().equals(requestPassword)) {
            board.update(boardServiceRequest.getTitle(), boardServiceRequest.getWriter(),
                    boardServiceRequest.getContent());

            return BoardResponse.of(board);
        }

        return null; // bad response ?
    }

    public void deleteBoard(BoardDeleteServiceRequest boardDeleteServiceRequest, Long id) {
        String requestPassword = Encryption.encryption(boardDeleteServiceRequest.getPassword());
        BoardEntity board = existsBoard(id);
        if (board.getPassword().equals(requestPassword)) {
            boardRepository.delete(board);
        }
    }

    private BoardEntity existsBoard(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물 입니다."));
    }
}
