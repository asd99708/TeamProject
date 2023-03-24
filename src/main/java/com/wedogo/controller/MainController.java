package com.wedogo.controller;


import com.wedogo.domain.member.Member;
import com.wedogo.web.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String home(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if(session==null){
            return "main/index.html";
        }
        Member loginMember = (Member)session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(loginMember == null){
            return "main/index.html";
        }
        model.addAttribute("member", loginMember);
        return "main/index.html";

    }

    @GetMapping("/registerhome")
    public String registerhome() {
        return "register/registerhome.html";
    }

    @GetMapping("/boardlist")
    public String boardlist(){
        return "board/list.html";
    }

    @GetMapping("/boardwrite")
    public String boardwrite(){
        return "board/write.html";
    }

    @GetMapping("/boardview")
    public String boardview(){
        return "board/view.html";
    }

    @GetMapping("/viewpage1")
    public String viewpage1(){
        return "view/viewpage1.html";
    }

    @GetMapping("/paymentpage")
    public String paymentpage() { return "Payment/paymentpage.html";}

    @GetMapping("/paymenthome")
    public String paymenthome() { return "Payment/paymenthome.html";}


}
