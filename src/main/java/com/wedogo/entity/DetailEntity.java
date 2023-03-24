package com.wedogo.entity;

import com.wedogo.dto.DetailDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="room")
public class DetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_number")
    private Long roomNumber;

    @Column
    private String roomName;
    @Column
    private String roomPrice;
    @Column
    private String roomContent;
    @Column
    private String roomImage1;
    @Column
    private String roomImage2;
    @Column
    private String roomImage3;
    @Column
    private String roomImage4;
    @Column
    private String roomSize;
    @Column
    private String resDigits;


    public static DetailEntity toDetailEntity(DetailDTO detailDTO){
        DetailEntity detailEntity = new DetailEntity();
        detailEntity.setRoomNumber(detailDTO.getRoomNumber());
        detailEntity.setRoomName(detailDTO.getRoomName());
        detailEntity.setRoomPrice(detailDTO.getRoomPrice());
        detailEntity.setRoomContent(detailDTO.getRoomContent());
        detailEntity.setRoomImage1(detailDTO.getRoomImage1());
        detailEntity.setRoomImage2(detailDTO.getRoomImage2());
        detailEntity.setRoomImage3(detailDTO.getRoomImage3());
        detailEntity.setRoomImage4(detailDTO.getRoomImage4());
        detailEntity.setRoomSize(detailDTO.getRoomSize());
        detailEntity.setResDigits(detailDTO.getResDigits());
        return detailEntity;
    }

    public static DetailEntity toUpdateDetailEntity(DetailDTO detailDTO){
        DetailEntity detailEntity = new DetailEntity();
        detailEntity.setRoomNumber(detailDTO.getRoomNumber());
        detailEntity.setRoomName(detailDTO.getRoomName());
        detailEntity.setRoomPrice(detailDTO.getRoomPrice());
        detailEntity.setRoomContent(detailDTO.getRoomContent());
        detailEntity.setRoomImage1(detailDTO.getRoomImage1());
        detailEntity.setRoomImage2(detailDTO.getRoomImage2());
        detailEntity.setRoomImage3(detailDTO.getRoomImage3());
        detailEntity.setRoomImage4(detailDTO.getRoomImage4());
        detailEntity.setRoomSize(detailDTO.getRoomSize());
        detailEntity.setResDigits(detailDTO.getResDigits());
        return detailEntity;
    }
}