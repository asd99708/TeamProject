package com.wedogo.controller;


import com.wedogo.domain.member.Member;
import com.wedogo.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") Member member) {
        return "/register/register";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Member member, BindingResult result, Model model) {
        Member existingUser = memberRepository.findByUserid(member.getUserid());
        if (existingUser != null) {
            model.addAttribute("errorMessage", "이미 사용중인 id입니다.");
            return "/register/add";
        }
        memberRepository.save(member);
        return "redirect:/"; // Redirect to the homepage or another page after successful registration
    }
}