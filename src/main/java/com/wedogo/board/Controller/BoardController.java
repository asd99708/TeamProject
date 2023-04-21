package com.wedogo.board.Controller;

import com.wedogo.board.Service.BoardService;
import com.wedogo.board.Service.UserinfoService;
import com.wedogo.board.entity.Board;
import com.wedogo.board.entity.Userinfo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final UserinfoService userinfoService;

    public BoardController(BoardService boardService, UserinfoService userService) {
        this.boardService = boardService;
        this.userinfoService = userService;
    }

    @GetMapping("/list")
    public String list(@RequestParam(name = "page", defaultValue = "1") int page,
                       @RequestParam(name = "size", defaultValue = "10") int size,
                       Model model) {
        List<Board> boardList = boardService.findAll(); // 모든 게시물을 가져온다.
        Page<Board> boardPage = boardService.findAllPaged(page, size); // 페이지네이션된 게시물 목록을 가져온다.
        model.addAttribute("boardList", boardList); // 모델 객체에 게시물 목록을 추가한다.
        model.addAttribute("boardPage", boardPage); // 모델 객체에 페이지네이션된 게시물 목록을 추가한다.
        return "board/list"; // 게시물 목록 페이지를 반환한다.
    }

    @GetMapping("/detail/{boardNum}")
    public String detail(@PathVariable int boardNum, Model model) {
        Board board = boardService.findById(boardNum);
        model.addAttribute("board", board);
        return "board/detail";
    }

    @GetMapping("/form")
    public String form(Model model) {
        List<Userinfo> users = userinfoService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("board", new Board());
        return "board/form";
    }

    @PostMapping("/save1")
    public String save1(@ModelAttribute("board") Board board) {
        boardService.save(board);
        return "redirect:/board/list";
    }

    @GetMapping("/form/{boardNum}")
    public String form(@PathVariable int boardNum, Model model) {
        List<Userinfo> users = userinfoService.findAll();
        Board board = boardService.findById(boardNum);
        model.addAttribute("users", users);
        model.addAttribute("board", board);
        return "board/form";
    }

    @PostMapping("/save2")
    public String save2(@ModelAttribute("board") Board board) {
        boardService.save(board);
        return "redirect:/board/detail/" + board.getBoardNum();
    }

    @PostMapping("/delete/{boardNum}")
    public String delete(@PathVariable int boardNum) {
        boardService.deleteById(boardNum);
        return "redirect:/board/list";
    }

}
