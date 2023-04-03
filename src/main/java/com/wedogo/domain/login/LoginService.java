package com.wedogo.domain.login;

import com.wedogo.domain.member.Member;
import com.wedogo.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    // 로그인 실패 시 null 반환
    public Member login(String user_Id, String user_password){
        Optional<Member> optionalMember = memberRepository.findByLoginId(user_Id);
        if (optionalMember.isPresent() && optionalMember.get().getUser_password().equals(user_password)) {
            return optionalMember.get();
        } else {
            return null;
        }
    }
}