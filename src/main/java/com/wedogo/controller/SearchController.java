package com.wedogo.controller;

import com.wedogo.hotel.entity.Address;
import com.wedogo.hotel.repository.AddressRepository;
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

    private AddressRepository addressRepository;

    @PostMapping("/search")
    public String performSearch(
            @RequestParam String address,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkin,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkout,
            @RequestParam int adults,
            @RequestParam int children,
            Model model) {


        List<Address> searchs = addressRepository.findByAddress(address);
        log.info("searchs = {}",searchs);

        model.addAttribute("checkin", checkin);
        model.addAttribute("checkout", checkout);
        model.addAttribute("adults", adults);
        model.addAttribute("children", children);
        model.addAttribute("searchs", searchs);

        return "search-results";
    }
}
