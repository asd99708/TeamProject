package com.wedogo.domain.board.Service;


import com.wedogo.domain.board.Board;
import com.wedogo.domain.board.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> BoardList(){
        return boardRepository.selectAll();
    }
    public Optional<Board> BoardOne(String id){
        return boardRepository.selectOne(id);
    }

    public void ViewcntUpdate(String id){
        boardRepository.updateViewCnt(id);
    }
    public void BoardAdd(Board board){
        boardRepository.insertOne(board);
    }
    public void BoardDelete(String id){
        boardRepository.deleteOne(id);
    }

    public void BoardUpdate(Board board){
        boardRepository.updateOne(board);
    }
}
