package com.wedogo.controller;
import com.wedogo.domain.member.Member;
import com.wedogo.hotel.entity.Hotel;
import com.wedogo.hotel.repository.HotelRepository;
import com.wedogo.hotel.repository.RoomRepository;
import com.wedogo.web.SessionConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private HotelRepository hotelRepository;
    private RoomRepository roomRepository; // assuming you have a repository class for the Room entity

    @GetMapping
    public String home(HttpServletRequest request, Model model) {
        List<Hotel> hotels = hotelRepository.findAll();
        Collections.shuffle(hotels);
        List<Hotel> randomHotels = hotels.subList(0, Math.min(hotels.size(), 3));
        model.addAttribute("hotels", randomHotels);

        HttpSession session = request.getSession(false);
        if(session==null){
            return "main/index.html";
        }
        Member loginMember = (Member)session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(loginMember == null){
            return "main/index.html";
        }
        model.addAttribute("member", loginMember);
        return "main/index.html";

    }


    @GetMapping("/registerhome")
    public String registerhome() {
        return "register/registerhome.html";
    }

    @GetMapping("/boardlist")
    public String boardlist(){
        return "board/list.html";
    }

    @GetMapping("/boardwrite")
    public String boardwrite(){
        return "board/write.html";
    }

    @GetMapping("/boardview")
    public String boardview(){
        return "board/view.html";
    }

    @GetMapping("/viewpage1")
    public String viewpage1(){
        return "view/viewpage1.html";
    }

    @GetMapping("/paymentpage")
    public String paymentpage() { return "Payment/paymentpage.html";}

    @GetMapping("/paymenthome")
    public String paymenthome() { return "Payment/paymenthome.html";}


}
