package com.wedogo.domain.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {
    @NotEmpty
    private String user_id;
    @NotEmpty
    private String user_password;
}
