package com.wedogo.domain.login;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "userinfo")
public class LoginForm {

    @Id
    @NotEmpty
    @Column(name = "user_id")
    private String userid;

    @NotEmpty
    @Column(name = "user_pwd")
    private String userpassword;

    @Column(name = "user_name")
    private String username;
}
