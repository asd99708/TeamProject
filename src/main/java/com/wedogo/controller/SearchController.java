package com.wedogo.controller;

import com.wedogo.hotel.entity.Hotel;
import com.wedogo.hotel.repository.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Controller
public class SearchController {

    private HotelRepository hotelRepository;

    @PostMapping("/search")
    public String performSearch(
            @RequestParam(name = "address") String address,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkin,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkout,
            @RequestParam int adults,
            @RequestParam int children,
            Model model) {

        address = "%" + address.trim().toLowerCase() + "%";
        List<Hotel> hotels = hotelRepository.findByAddressIgnoreCaseContaining(address);
        log.info("hotels = {}", hotels);

        model.addAttribute("checkin", checkin);
        model.addAttribute("checkout", checkout);
        model.addAttribute("adults", adults);
        model.addAttribute("children", children);
        model.addAttribute("hotels", hotels);

        return "Search/MainSearch";
    }
}
