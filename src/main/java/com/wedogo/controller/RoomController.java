package com.wedogo.controller;


import com.wedogo.hotel.entity.Room;
import com.wedogo.hotel.repository.HotelRepository;
import com.wedogo.hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Slf4j
@Controller
@RequiredArgsConstructor
public class RoomController {
    @Autowired
    private RoomRepository roomRepository; // assuming you have a repository class for the Room entity

    @PostMapping("/viewpage")
    public String viewPage(String resDigits, Model model) {
        log.info(resDigits);
        List<Room> rooms = roomRepository.findByResDigits(resDigits);
        log.info("room = {}", rooms);
        model.addAttribute("rooms", rooms);
        return "hotel/viewpage"; // 이동할 뷰 페이지의 이름
    }


}
