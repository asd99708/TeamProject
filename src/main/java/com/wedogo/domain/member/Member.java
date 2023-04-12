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


    @Column(name = "user_name")
    private String username;

    @Id
    @Column(name = "user_id")
    private String userid;

    @Column(name = "user_pwd")
    private String userpassword;

    @Column(name = "user_gen")
    private String usergen;


    @Column(name = "user_phone")
    private String userphone;

    @Email(message = "이메일 형식에 맞지 않습니다.")
    @Column(name = "user_email")
    private String useremail;

}
