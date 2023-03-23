package com.wedogo.domain.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {
    @NotEmpty
    private String userid;
    @NotEmpty
    private String userpassword;
}
