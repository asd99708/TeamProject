package com.wedogo.controller;

import com.wedogo.domain.board.Board;
import com.wedogo.domain.board.Service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("board", new Board());
        return "boards/addForm";
    }

    @PostMapping("/add")
    public String addBoard(@ModelAttribute Board board, RedirectAttributes redirectAttributes){
        boardService.BoardAdd(board);
        return "redirect:/board";
    }

    @RequestMapping("/{id}/delete")
    public String deleteBoard(@PathVariable String id){
        boardService.BoardDelete(id);
        return "redirect:/board";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable("id") String id, Model model){
        Optional<Board> result = boardService.BoardOne(id);
        Board board = result.get();
        model.addAttribute("board", board);
        log.info("board={}", board);

        return "board/editForm";
    }
}