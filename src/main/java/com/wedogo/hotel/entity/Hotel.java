package com.wedogo.hotel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "hotel")
public class Hotel {
    @Id
    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "room_max")
    private int roomMax;

    @Column(name = "room_content")
    private String roomContent;

    @Column(name = "room_image1")
    private String roomImage1;

    // Add getters and setters for each field
}