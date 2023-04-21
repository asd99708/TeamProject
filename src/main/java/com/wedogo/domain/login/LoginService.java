package com.wedogo.domain.login;

import com.wedogo.domain.member.Member;
import com.wedogo.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository loginRepository;

    // 로그인 실패 시 null 반환
    public LoginForm login(String userid, String userpassword){
        Optional<LoginForm> optionalMember = loginRepository.findByUserid(userid);
        if (optionalMember.isPresent() && optionalMember.get().getUserpassword().equals(userpassword)) {
            return optionalMember.get();
        } else {
            return null;
        }
    }
}