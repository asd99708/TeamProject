package com.wedogo.controller;

import com.wedogo.domain.board.Board;
import com.wedogo.domain.board.Service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController{
    private final BoardService boardService;

    @GetMapping
    public String board(Model model){
        List<Board> board = boardService.BoardList();
    model.addAttribute("board", board);
    return "board/list";
    }

    @GetMapping("/{id}")
    public String board(@PathVariable("id") String id, Model model){
        boardService.ViewcntUpdate(id);
        Optional<Board> result = boardService.BoardOne(id);
        Board board = result.get();
        model.addAttribute("board", board);
        log.info("board={}", board);
        return "board/list";
    }
}