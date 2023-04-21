package com.wedogo.hotel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "room")
public class Room {

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "room_price")
    private String roomPrice;

    @Column(name = "room_content1")
    private String roomContent1;

    @Column(name = "room_content2")
    private String roomContent2;

    @Column(name = "room_content3")
    private String roomContent3;

    @Column(name = "room_image1")
    private String roomImage1;

    @Column(name = "room_image2")
    private String roomImage2;

    @Column(name = "room_image3")
    private String roomImage3;

    @Column(name = "room_image4")
    private String roomImage4;

    @Column(name = "room_image5")
    private String roomImage5;

    @Column(name = "room_image6")
    private String roomImage6;

    @Column(name = "room_size")
    private String roomSize;
    @Id
    @Column(name = "res_digits")
    private String resDigits;

    @Column(name = "room_max")
    private String roomMax;

    // getters and setters
}
