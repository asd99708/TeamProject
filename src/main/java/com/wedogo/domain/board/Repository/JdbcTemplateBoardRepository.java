package com.wedogo.domain.board.Repository;


import com.wedogo.domain.board.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JdbcTemplateBoardRepository implements BoardRepository{
    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Board> selectAll() {
        return jdbcTemplate.query("select userinfo.user_id, " +
                "userinfo.user_name, " +
                "board.board_title," +
                "board.board_content," +
                "board.board_createDate," +
                "board.board_count from board, userinfo", BoardRowMapper());
    }

    @Override
    public Optional<Board> selectOne(String id){
        List<Board> result = jdbcTemplate.query("select userinfo.user_id, " +
                "userinfo.user_name, " +
                "board.board_title," +
                "board.board_content," +
                "board.board_createDate," +
                "board.board_count from board, userinfo where userinfo.user_id=?",BoardRowMapper(),id);
        return result.stream().findAny();
    }


    @Override
    public void updateViewCnt(String id){
        jdbcTemplate.update("update board set count = count + 1 where user_id=?",id);

    }
}
