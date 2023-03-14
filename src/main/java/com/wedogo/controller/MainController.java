package com.wedogo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String home() {
        return "main/index.html";
    }

    @GetMapping("/registerhome")
    public String registerhome() {
        return "register/registerhome.html";
    }

    @GetMapping("/register")
    public String register(){
        return "register/register.html";
    }

    @GetMapping("/login")
    public String login(){
        return "login/login.html";
    }

    @GetMapping("/list")
    public String list(){
        return "board/list.html";
    }

    @GetMapping("/write")
    public String write(){
        return "board/write.html";
    }

    @GetMapping("/view")
    public String view(){
        return "board/view.html";
    }
}
