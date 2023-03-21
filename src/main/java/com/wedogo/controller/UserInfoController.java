package com.wedogo.controller;

import com.wedogo.Service.UserInfoService;
import com.wedogo.dto.UserInfoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.lang.reflect.Member;

@Controller
@AllArgsConstructor
public class UserInfoController {
    private UserInfoService userInfoService;
    @GetMapping("/register")
    public String Register(UserInfoDTO userInfoDTO){
        return "register/register";
    }

//    @PostMapping("/register")
//    public String create(@Valid @ModelAttribute UserInfoDTO userInfoDTO, BindingResult result, Model model){
//
//        if (result.hasErrors()) {
//            return "register/register";
//        }
//
//        Member member = Member.builder()
//                .usernickname(userInfoDTO.getUsernickname())
//                .username(userInfoDTO.getUsername())
//                .userid(userInfoDTO.getUserid())
//                .password(userInfoDTO.getUserpassword())
//                .gender(userInfoDTO.getGender())
//                .userphonenum(userInfoDTO.getUserphonenum())
//                .email(userInfoDTO.getEmail())
//                .build();
//
//        member.updateRole(MemberRoll.ROLE_NORMAL);
//        UserInfoService.signUp(member);
//        return "/login/login.html";
//    }
        @GetMapping("/login")
        public String login(){
            return "login/login";
    }
}
