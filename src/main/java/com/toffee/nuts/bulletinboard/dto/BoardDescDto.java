package com.toffee.nuts.bulletinboard.dto;

import com.toffee.nuts.bulletinboard.domain.Board;
import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Data
public class BoardDescDto {

    private Integer id;
    private String title;
    private String author;

    public BoardDescDto(Board board) {
        this.id = board.getId();
        this.author = board.getAuthor();
        this.title = board.getTitle();
    }

}
