package com.wedogo.controller;

import com.wedogo.hotel.entity.Room;
import com.wedogo.hotel.repository.RoomRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

public class HotelController {
    private RoomRepository roomRepository;
    public HotelController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @PostMapping("/hotelpage")
    public String hotelpage(@RequestParam("hotelName") String hotelName, Model model) {
        List<Room> rooms = roomRepository.findByHotelNameContaining(hotelName);
        model.addAttribute("rooms", rooms);
        return "hotel/hotelpage";
    }
}
