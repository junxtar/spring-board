package com.sparta.springboard.api.controller.board;

import com.sparta.springboard.api.ApiResponse;
import com.sparta.springboard.api.controller.board.dto.request.BoardDeleteRequest;
import com.sparta.springboard.api.controller.board.dto.request.BoardRequest;
import com.sparta.springboard.api.service.board.BoardService;
import com.sparta.springboard.api.service.board.dto.response.BoardResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board/{id}")
    public ApiResponse<BoardResponse> getBoard(@PathVariable Long id) {

        return ApiResponse.success(boardService.getBoard(id));
    }

    @GetMapping("/boards")
    public ApiResponse<List<BoardResponse>> getBoards() {

        return ApiResponse.success(boardService.getBoards());
    }

    @PostMapping("/board/new")
    public ApiResponse<BoardResponse> createBoard(
            @RequestBody BoardRequest boardRequest) {

        return ApiResponse.success(boardService.createBoard(boardRequest.toServiceRequest()));
    }

    @PutMapping("/board/{id}")
    public ApiResponse<BoardResponse> updateBoard(@RequestBody BoardRequest boardRequest,
            @PathVariable Long id) {
        return ApiResponse.success(boardService.updateBoard(boardRequest.toServiceRequest(), id));
    }

    @DeleteMapping("/board/{id}")
    public void deleteBoard(@RequestBody BoardDeleteRequest boardDeleteRequest, @PathVariable Long id) {
        boardService.deleteBoard(boardDeleteRequest.toServiceRequest(), id);
    }
}
