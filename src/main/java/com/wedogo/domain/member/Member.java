package com.wedogo.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
@Data
public class Member {
    @NotEmpty
    private String username;
    @NotEmpty
    private String userid;
    @NotEmpty
    private String userpassword;
    @NotEmpty
    private String gender;
    @NotEmpty
    private String userphonenum;
    @NotEmpty
    private String useremail;

    public Member(String userId, String userPwd, String userName, String userGen, String userPhone, String userEmail) {
        this.userid = userId;
        this.userpassword = userPwd;
        this.username = userName;
        this.gender = userGen;
        this.userphonenum = userPhone;
        this.useremail = userEmail;

    }
}
