package com.wedogo.dto;

import com.wedogo.entity.DetailEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class DetailDTO {
    private Long roomNumber;
    private String roomName;
    private String roomPrice;
    private String roomContent;
    private String roomImage1;
    private String roomImage2;
    private String roomImage3;
    private String roomImage4;
    private String roomSize;
    private String resDigits;

    public static DetailDTO toDetailDTO(DetailEntity detailEntity) {
        DetailDTO detailDTO = new DetailDTO();
        detailDTO.setRoomNumber(detailEntity.getRoomNumber());
        detailDTO.setRoomName(detailEntity.getRoomName());
        detailDTO.setRoomPrice(detailEntity.getRoomPrice());
        detailDTO.setRoomContent(detailEntity.getRoomContent());
        detailDTO.setRoomImage1(detailEntity.getRoomImage1());
        detailDTO.setRoomImage2(detailEntity.getRoomImage2());
        detailDTO.setRoomImage3(detailEntity.getRoomImage3());
        detailDTO.setRoomImage4(detailEntity.getRoomImage4());
        detailDTO.setRoomSize(detailEntity.getRoomSize());
        detailDTO.setResDigits(detailEntity.getResDigits());
        return detailDTO;
    }


}