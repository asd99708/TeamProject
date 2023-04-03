package com.wedogo.domain.board.Repository;


import com.wedogo.domain.board.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    @Override
    public void insertOne(Board board){
        jdbcTemplate.update("insert into board,userinfo (board.board_title,board.board_content,userinfo.user_name) values(?,?,?)",
                board.getTitle(), board.getContent(), board.getName());
    }

    @Override
    public void deleteOne(String id){ jdbcTemplate.update("delete form board where user_id = ?",id);}

    public void updateOne(Board board){
        jdbcTemplate.update("update board set board_title=?, board_content=? where user_id=?",
                board.getTitle(), board.getContent(), board.getId());
    }

    private RowMapper<Board> BoardRowMapper() {
        return new RowMapper<Board>() {
            @Override
            public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                Board board = new Board();
                board.setId(rs.getString("user_id"));
                board.setName(rs.getString("user_name"));
                board.setTitle(rs.getString("board_title"));
                board.setContent(rs.getString("board_content"));
                board.setCreateDate(rs.getString("board_createDate"));
                board.setCount(rs.getString("board_count"));
                return board;
            }
        };
    }
}
