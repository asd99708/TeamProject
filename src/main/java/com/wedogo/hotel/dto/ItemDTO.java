package com.wedogo.hotel.dto;



import com.wedogo.hotel.entity.ItemEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ItemDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public static ItemDTO toitemDTO(ItemEntity itemEntity) {
        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setHotelName(itemEntity.getHotelName());
        itemDTO.setRoomName(itemEntity.getRoomName());
        itemDTO.setRoomPrice(itemEntity.getRoomPrice());
        itemDTO.setRoomContent1(itemEntity.getRoomContent1());
        itemDTO.setRoomContent2(itemEntity.getRoomContent2());
        itemDTO.setRoomContent3(itemEntity.getRoomContent3());
        itemDTO.setRoomImage1(itemEntity.getRoomImage1());
        itemDTO.setRoomImage2(itemEntity.getRoomImage2());
        itemDTO.setRoomImage3(itemEntity.getRoomImage3());
        itemDTO.setRoomImage4(itemEntity.getRoomImage4());
        itemDTO.setRoomImage4(itemEntity.getRoomImage5());
        itemDTO.setRoomImage4(itemEntity.getRoomImage6());
        itemDTO.setRoomSize(itemEntity.getRoomSize());
        itemDTO.setResDigits(itemEntity.getResDigits());


        return itemDTO;
    }
}
