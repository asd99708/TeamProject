package com.wedogo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserInfoDTO {
    Long idnum;
    String id;
    String passward;
    String username;
    String nickname;
    String email;
    String profileImage;
    int rate;
}
