package com.wedogo.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
@Data
public class Member {
    @NotEmpty
    private String user_name;
    @NotEmpty
    private String user_id;
    @NotEmpty
    private String user_password;
    @NotEmpty
    private String user_gen;
    @NotEmpty
    private String user_phone;
    @NotEmpty
    private String user_email;

    public Member(String user_id, String user_password, String user_name, String user_gen, String user_phone, String user_email) {
        this.user_id = user_id;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_gen = user_gen;
        this.user_phone = user_phone;
        this.user_email = user_email;

    }
}
