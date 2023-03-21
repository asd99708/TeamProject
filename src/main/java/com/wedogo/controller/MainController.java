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
}
