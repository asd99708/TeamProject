package com.wedogo.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserInfoDTO {
    @NotBlank(message = "닉네임을 입력해주세요.")
    private String usernickname;
    @NotBlank(message = "이름을 입력해주세요.")
    private String username;

    @NotBlank(message = "아이디를 입력해주세요.")
    private String userid;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{10,16}$|^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,16}$",
            message = "영문 대소문자/숫자/특수문자를 혼용하여 2종류 10~16자 또는 3종류 8~16자로 입력해주세요.")
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String userpassword;

    private String userpasswordCheck;

    @NotBlank(message = "성별을 선택해주세요.")
    private String gender;

    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "\\d{3}-\\d{4}-\\d{4}", message = "올바른 휴대폰 번호를 입력해주세요.")
    private String userphonenum;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;

    @Builder
    public UserInfoDTO(String usernickname, String username,String userid, String userpassword,String gender, String email) {
        this.usernickname = usernickname;
        this.username = username;
        this.userid = userid;
        this.userpassword = userpassword;
        this.gender = gender;
        this.email = email;
//        this.profileImage = profileImage;
    }
}
