package com.wedogo.hotel.repository;

import com.wedogo.hotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
    List<Room> findByResDigits(String resDigits);
}