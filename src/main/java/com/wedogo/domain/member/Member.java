package com.wedogo.domain.member;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "userinfo")
public class Member {

    @NotEmpty
    @Column(name = "user_name")
    private String username;

    @Id
    @NotEmpty
    @Range(min = 8, max = 20)
    @Column(name = "user_id")
    private String userid;

    @NotEmpty
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{10,16}$|^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,16}$",
            message = "영문 대소문자/숫자/특수문자를 혼용하여 3종류 8~16자로 입력해주세요.")
    @Column(name = "user_pwd")
    private String userpassword;

    @NotEmpty
    @Column(name = "user_gen")
    private String usergen;

    @NotEmpty
    @Pattern(regexp = "\\d{3}-\\d{4}-\\d{4}", message = "올바른 휴대폰 번호를 입력해주세요.")
    @Column(name = "user_phone")
    private String userphone;

    @NotEmpty
    @Email(message = "이메일 형식에 맞지 않습니다.")
    @Column(name = "user_email")
    private String useremail;

}
