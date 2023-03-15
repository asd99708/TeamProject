package com.wedogo.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserInfoDTO {
    @NotBlank(message = "이름을 입력해주세요.")
    private String username;

    @NotBlank(message = "아이디를 입력해주세요.")
    private String userid;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{10,16}$|^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,16}$",
            message = "영문 대소문자/숫자/특수문자를 혼용하여 2종류 10~16자 또는 3종류 8~16자로 입력해주세요.")
    private String userpassword;

    private String userpasswordCheck;

    @NotBlank(message = "성별을 선택해주세요.")
    private String gender;

    @NotBlank(message = "우편번호를 입력해주세요.")
    private String postcode;

    @NotBlank(message = "집주소를 입력해주세요.")
    private String userhome;

    private String userAddress;

    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "\\d{3}-\\d{4}-\\d{4}", message = "올바른 휴대폰 번호를 입력해주세요.")
    private String phone;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Pattern(regexp = "\\w+@\\w+\\.\\w+(\\.\\w+)?", message = "올바른 이메일 형식을 입력해주세요.")
    private String email;

    @Builder
    public UserInfoDTO(String id, String pwd, String username, String usernickname, String email,byte[] profileImage){
        this.username = username;
        this.userid = id;
        this.userpassword = pwd;
//        this.usernickname = usernickname;
        this.email = email;
//        this.profileImage = profileImage;
    }
}
