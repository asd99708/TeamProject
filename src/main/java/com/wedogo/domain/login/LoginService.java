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
    public Member login(String userId, String userpassword){
        Optional<Member> optionalMember = memberRepository.findByLoginId(userId);
        if (optionalMember.isPresent() && optionalMember.get().getUserpassword().equals(userpassword)) {
            return optionalMember.get();
        } else {
            return null;
        }
    }
}