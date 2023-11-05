package com.sparta.springboard.api.controller.board;

import com.sparta.springboard.api.ApiResponse;
import com.sparta.springboard.api.controller.board.dto.request.BoardCreateRequest;
import com.sparta.springboard.api.service.board.BoardService;
import com.sparta.springboard.api.service.board.dto.response.BoardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/board/new")
    public ApiResponse<BoardResponse> createBoard(
            @RequestBody BoardCreateRequest boardCreateRequest) {

        return ApiResponse.success(boardService.createBoard(boardCreateRequest.toServiceRequest()));
    }

    @GetMapping("/board/{id}")
    public ApiResponse<BoardResponse> getBoard(@PathVariable Long id) {

        return ApiResponse.success(boardService.getBoard(id));
    }
}
