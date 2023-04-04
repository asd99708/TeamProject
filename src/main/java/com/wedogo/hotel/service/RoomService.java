package com.wedogo.hotel.service;

import com.wedogo.board.entity.Board;
import com.wedogo.hotel.entity.Room;
import com.wedogo.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllEmployees() {
        return roomRepository.findAll();
    }
    public Room findById(String resDigits) {
        return roomRepository.findById(resDigits)
                .orElseThrow(() -> new IllegalArgumentException("resDigits : " + resDigits));
    }

}
