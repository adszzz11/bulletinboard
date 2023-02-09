package com.toffee.nuts.bulletinboard.dto;

import com.toffee.nuts.bulletinboard.domain.Board;
import com.toffee.nuts.bulletinboard.domain.Comment;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

@Data
@RequiredArgsConstructor
public class BoardDto {

    private Integer id;
    private String title;
    private String author;
    private String context;

    public BoardDto(Board board) {
        this.id = board.getId();
        this.author = board.getAuthor();
        this.title = board.getTitle();
        this.context = board.getContext();
//        this.comment = board.getComment();
    }


//    private Comment comment;

}
