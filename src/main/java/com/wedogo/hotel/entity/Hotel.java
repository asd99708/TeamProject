package com.wedogo.hotel.entity;

import com.wedogo.board.entity.Userinfo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "room_max", nullable = false)
    private int roomMax;

    @Column(name = "room_content", nullable = false)
    private String roomContent;

    @Column(name = "room_image1", nullable = false)
    private String roomImage1;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private Userinfo userinfo;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Room> rooms;

    // Add constructors, getters, and setters for each field
}
