package com.wedogo.controller;

import com.wedogo.domain.member.Member;
import com.wedogo.dto.DetailDTO;
import com.wedogo.service.DetailService;
import com.wedogo.web.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/view")
public class DetailController {

    private final DetailService detailService;

//    @GetMapping
//    public String firstdetail(HttpServletRequest request, Model model) {
//        HttpSession session = request.getSession(false);
//        if (session == null) {
//            return "main/viewpage1.html";
//        }
//
//        Member loginMember = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
//        if (loginMember == null) {
//            return "main/index.html";
//        }
//        model.addAttribute("member", loginMember);
//        return "main/index.html";
//
//    }

    @GetMapping("/uploadform")
    public String uploadForm() {
        return "uploadform";
    }

    @PostMapping("/uploadform")
    public String upload(@ModelAttribute DetailDTO detailDTO) throws IOException {
        System.out.println("detailDTO = " + detailDTO);
        detailService.save(detailDTO);
        return "view/viewpage1";
    }


    @GetMapping("/view/viewpage1")
    public String findAll(Model model) {
        List<DetailDTO> detailDTOList = detailService.findAll();
        model.addAttribute("detailList", detailDTOList);
        return "layout/list";
    }

    @GetMapping("/view/{roomNumber")
    public String findById(@PathVariable Long roomNumber, Model model) {
        DetailDTO detailDTO = detailService.findByRoomnumber(roomNumber);
        model.addAttribute("detail", detailDTO);
        return "/view/uploadform";
    }

    @GetMapping("/view/uploadform")
    public String updateForm(@PathVariable Long roomNumber, Model model) {
        DetailDTO detailDTO = detailService.findByRoomnumber(roomNumber);
        model.addAttribute("updateDetail", detailDTO);
        return "/view/uploadform";

    }

    @GetMapping("/view/uploadform")
    public String update(@ModelAttribute DetailDTO detailDTO, Model model) {
        DetailDTO detail = detailService.update(detailDTO);
        model.addAttribute("detail", detail);
        return "detail";
    }

    @GetMapping("view/uploadform/{roomNumber")
    public String delete(@PathVariable Long roomNumber) {
        detailService.deleteById(roomNumber);
        return "redirect:/";
    }
}