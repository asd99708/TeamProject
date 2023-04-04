package com.wedogo.board.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Userinfo {
    @Id
    private String user_id;

    private String user_pwd;

    private String user_name;

    private String user_gen;

    private String user_phone;

    private String user_email;

    private Timestamp user_date;

    // getters and setters
}