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
}
