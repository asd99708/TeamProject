package com.wedogo.controller;

import com.wedogo.domain.login.LoginForm;
import com.wedogo.hotel.entity.Room;
import com.wedogo.hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Slf4j
@Controller
@RequiredArgsConstructor
public class RoomController {
    @Autowired
    private RoomRepository roomRepository; // assuming you have a repository class for the Room entity
//    @GetMapping("/room1")
//    public String room1form(){
//        return"view/viewpage1.html";
//    }

    @GetMapping("/room1")
    public String room1(@RequestParam(name = "resDigits", defaultValue = "") String resDigits, Model model) {
        if (resDigits.isEmpty()) {
            // If resDigits is not provided, use a default value
            resDigits = "A00001";
        }
        List<Room> rooms = roomRepository.findByResDigits(resDigits);
        model.addAttribute("rooms", rooms);
        model.addAttribute("resDigits", resDigits);
        return "view/viewpage1";
    }
}
