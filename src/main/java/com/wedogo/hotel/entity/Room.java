package com.wedogo.hotel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Room {
    private String hotelName;
    private String roomName;
    private String roomPrice;
    private String roomContent1;
    private String roomContent2;
    private String roomContent3;
    private String roomImage1;
    private String roomImage2;
    private String roomImage3;
    private String roomImage4;
    private String roomSize;
    @Id
    private String resDigits;

    public Room(String hotelName, String roomName, String roomPrice, String roomContent1, String roomContent2, String roomContent3,
                String roomImage1, String roomImage2, String roomImage3, String roomImage4, String roomSize, String resDigits) {
        this.hotelName = hotelName;
        this.roomName = roomName;
        this.roomPrice = roomPrice;
        this.roomContent1 = roomContent1;
        this.roomContent2 = roomContent2;
        this.roomContent3 = roomContent3;
        this.roomImage1 = roomImage1;
        this.roomImage2 = roomImage2;
        this.roomImage3 = roomImage3;
        this.roomImage4 = roomImage4;
        this.roomSize = roomSize;
        this.resDigits = resDigits;
    }
}
