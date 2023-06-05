package com.toffee.nuts.bulletinboard.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.toffee.nuts.bulletinboard.domain.Board;
import lombok.RequiredArgsConstructor;

public record BoardCreateDto(
        @JsonProperty("title") String title
        , @JsonProperty("author") String author
        , @JsonProperty("username") String username
        , @JsonProperty("pwd") String pwd
        , @JsonProperty("context") String context
//        , @JsonProperty("comment") Comment comment
) {


    public static BoardCreateDto getBoardCreateDto(Board board) {
        return new BoardCreateDto(board.getTitle(), board.getAuthor(), board.getUsername(), board.getPwd(), board.getContext());

//        this.comment = board.getComment();
    }


//    private Comment comment;

}
