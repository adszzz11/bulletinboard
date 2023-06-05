package com.toffee.nuts.bulletinboard.dto;

import com.toffee.nuts.bulletinboard.domain.Board;

public record BoardDescDto(
        Long id
        , String title
        , String author
//        ,Integer commentCount
//        ,Integer likeCount
) {
    public static BoardDescDto getBoardDescDto(Board board) {
        return new BoardDescDto(board.getId(), board.getTitle(), board.getAuthor());
    }
}