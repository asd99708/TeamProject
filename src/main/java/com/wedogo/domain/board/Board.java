package com.wedogo.domain.board;

import lombok.*;

import java.util.Date;

@Data
public class Board {
    private String id;
    private String name;
    private String title;
    private String content;
    private String createDate;
    private String count;

    public Board() {
    }

    public Board(String id,String name, String title, String content, String createDate, String count) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.count = count;
    }
}
