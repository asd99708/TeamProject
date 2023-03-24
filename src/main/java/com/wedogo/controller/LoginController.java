package com.wedogo.controller;

import com.wedogo.domain.login.LoginForm;
import com.wedogo.domain.login.LoginService;
import com.wedogo.domain.member.Member;
import com.wedogo.web.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;



    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm")LoginForm form){
        return"login/login";
    }

    @GetMapping("/kakaologin")
    public String kakaologinForm(){
        return "login/kakaologin";
    }

    @PostMapping("/login")
    public String login (@Valid @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return "login/login.html";
        }
        Member loginMember = loginService.login(form.getUserid(),form.getUserpassword());
        log.info("login? {}", loginMember);
        if(loginMember == null){
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
            return  "login/login.html";
        }
        // 로그인 성공 처리

        //세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
        HttpSession session = request.getSession();
        // 세션에 로그인 횡눤 정보 보관
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        //세션을 삭제한다.
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return "redirect:/";
    }
}