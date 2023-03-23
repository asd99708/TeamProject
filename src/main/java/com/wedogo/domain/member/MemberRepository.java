package com.wedogo.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Member save(Member member) {
        String sql = "INSERT INTO userinfo(user_id, user_pwd, user_name, user_gen, user_phone, user_email) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, member.getUserid(), member.getUserpassword(), member.getUsername(), member.getGender(), member.getUserphonenum(), member.getUseremail());
        log.info("save: member={}", member);
        return member;
    }

    public Member findById(Long id) {
        String sql = "SELECT * FROM userinfo WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum)->
                new Member(
                        rs.getString("user_id"),
                        rs.getString("user_pwd"),
                        rs.getString("user_name"),
                        rs.getString("user_gen"),
                        rs.getString("user_phone"),
                        rs.getString("user_email")
                ));
    }

    public Optional<Member> findByLoginId(String userId) {
        String sql = "SELECT * FROM userinfo WHERE user_id=?";
        List<Member> members = jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) ->
                new Member(
                        rs.getString("user_id"),
                        rs.getString("user_pwd"),
                        rs.getString("user_name"),
                        rs.getString("user_email"),
                        rs.getString("user_gen"),
                        rs.getString("user_phone")
                ));
        return members.stream().findFirst();
    }

    public List<Member> findAll() {
        String sql = "SELECT * FROM userinfo";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Member(
                        rs.getString("user_id"),
                        rs.getString("user_pwd"),
                        rs.getString("user_name"),
                        rs.getString("user_email"),
                        rs.getString("user_gen"),
                        rs.getString("user_phone")
                ));
    }

    public void clearStore() {
        String sql = "DELETE FROM userinfo";
        jdbcTemplate.update(sql);
    }
}
