package com.wedogo.controller;


import com.wedogo.hotel.entity.Room;
import com.wedogo.hotel.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Slf4j
@Controller
public class RoomController {
    @Autowired
    private RoomRepository roomRepository; // assuming you have a repository class for the Room entity

    @PostMapping("/viewpage")
    public String viewPage(@RequestParam("hotelName") String resDigits, Model model) {
        List<Room> room = roomRepository.findByResDigits(resDigits);
        model.addAttribute("room", room);
        return "hotel/viewpage"; // 이동할 뷰 페이지의 이름
    }


}
