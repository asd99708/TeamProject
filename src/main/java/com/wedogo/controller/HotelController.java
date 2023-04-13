package com.wedogo.controller;

import com.wedogo.hotel.entity.Room;
import com.wedogo.hotel.repository.RoomRepository;
import groovy.transform.AnnotationCollector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
@Slf4j
@Controller
public class HotelController {
    private RoomRepository roomRepository;
    public HotelController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @PostMapping("/hotelpage")
    public String hotelpage(String hotelName, Model model) {
        List<Room> rooms = roomRepository.findByHotelNameContaining(hotelName);
        log.info("rooms = {}",rooms);
        model.addAttribute("rooms", rooms);
        return "/hotel/hotelpage";
    }
    @GetMapping("/hotelpage")
    public String hotelpage1(String hotelName, Model model) {
        List<Room> rooms = roomRepository.findByHotelNameContaining(hotelName);
        log.info("rooms = {}",rooms);
        model.addAttribute("rooms", rooms);
        return "/hotel/hotelpage";
    }
}
