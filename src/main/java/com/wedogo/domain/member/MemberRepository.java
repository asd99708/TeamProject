package com.wedogo.domain.member;

import com.wedogo.domain.login.LoginForm;
import com.wedogo.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member save(Member member);

    Member findByUserid(String userid);


}
