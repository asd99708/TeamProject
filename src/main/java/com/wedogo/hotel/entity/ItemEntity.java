package com.wedogo.hotel.entity;


import com.wedogo.hotel.dto.ItemDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "room")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @Column(name = "res_digits")
    private String resDigits;

    public static ItemEntity toItemEntity(ItemDTO itemDTO) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setHotelName(itemDTO.getHotelName());
        itemEntity.setRoomName(itemDTO.getRoomName());
        itemEntity.setRoomPrice(itemDTO.getRoomPrice());
        itemEntity.setRoomContent1(itemDTO.getRoomContent1());
        itemEntity.setRoomContent2(itemDTO.getRoomContent2());
        itemEntity.setRoomContent3(itemDTO.getRoomContent3());
        itemEntity.setRoomImage1(itemDTO.getRoomImage1());
        itemEntity.setRoomImage2(itemDTO.getRoomImage2());
        itemEntity.setRoomImage3(itemDTO.getRoomImage3());
        itemEntity.setRoomImage4(itemDTO.getRoomImage4());
        itemEntity.setRoomImage5(itemDTO.getRoomImage5());
        itemEntity.setRoomImage6(itemDTO.getRoomImage6());
        itemEntity.setRoomSize(itemDTO.getRoomSize());
        itemEntity.setResDigits(itemDTO.getResDigits());
        return itemEntity;
    }
}