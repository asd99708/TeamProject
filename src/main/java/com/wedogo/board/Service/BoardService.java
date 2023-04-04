package com.wedogo.board.Service;

import com.wedogo.board.entity.Board;
import com.wedogo.board.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Board save(Board board) {
        return boardRepository.save(board);
    }

    public Board findById(int boardNum) {
        return boardRepository.findById(boardNum)
                .orElseThrow(() -> new IllegalArgumentException("Invalid board number: " + boardNum));
    }

    @Transactional
    public void deleteById(int boardNum) {
        boardRepository.deleteById(boardNum);
    }

    @Transactional
    public void increaseCount(int boardNum) {
        Board board = findById(boardNum);
        board.setBoardCount(board.getBoardCount() + 1);
        boardRepository.save(board);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Page<Board> findAllPaged(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return boardRepository.findAll(pageable);
    }


    // 다른 비즈니스 로직 메서드들...
}