package com.wedogo.board.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_num")
    private int boardNum;

    @Column(name = "board_title", length = 30, nullable = false)
    private String boardTitle;

    @Column(name = "board_content", length = 300, nullable = false)
    private String boardContent;

    @Column(name = "board_createDate")
    private String boardCreateDate;

    @Column(name = "board_count", nullable = false)
    private int boardCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Userinfo user;

    // getter, setter, constructor

    public Board() {}

    public Board(int boardNum, String boardTitle, String boardContent, String boardCreateDate, int boardCount, Userinfo user) {
        this.boardNum = boardNum;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardCreateDate = boardCreateDate;
        this.boardCount = boardCount;
        this.user = user;
    }
}