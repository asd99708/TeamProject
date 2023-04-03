package com.wedogo.domain.board.Repository;

import com.wedogo.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BoardRepository  {
    public List<Board> selectAll();

    public Optional<Board> selectOne(String id);
    public void updateViewCnt(String id);
    public void insertOne(Board board);
    public void updateOne(Board board);
    public void deleteOne(String id);

}
