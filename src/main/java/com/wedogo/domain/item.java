package com.wedogo.domain;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
public class item {
    @NotBlank
    private String username;

    @NotBlank(message = "아이디를 입력해주세요.")
    @Range(min = 8, max = 20)
    private String userid;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{10,16}$|^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,16}$",
            message = "영문 대소문자/숫자/특수문자를 혼용하여 3종류 8~16자로 입력해주세요.")
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

}
