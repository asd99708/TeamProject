package com.wedogo.controller;

import com.wedogo.dto.UserInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserInfoController {

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute(new UserInfoDTO());
        return "register/register";
    }

    @PostMapping("/register")
    public String registerSubmit(@Valid @ModelAttribute UserInfoDTO userInfoDTO,Errors errors) {
        if (errors.hasErrors()) {
            return "register/register.html";
        }
        // TODO: 회원 가입 처리
        return "redirect:/";
    }
}