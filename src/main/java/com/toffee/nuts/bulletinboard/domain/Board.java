package com.toffee.nuts.bulletinboard.domain;

import com.toffee.nuts.bulletinboard.dto.BoardDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    // 게시물 변경을 위한 id, pwd 정보 사용
    //TODO: login 시스템 들어올 시 userId 값으로 변경할 수 있도록 변경
    private String username;
    private String pwd;
    //작성자(수정가능)
    //TODO: login 시스템 들어올 시 자동 mapping
    private String author;

    private String title;
    //내용
    //TODO: 게시글 작성 에 MarkDown 적용
    //TODO: 사진, 영상 등 첨부할 때 어떻게 처리할 것인지 고민하기
    private String context;

//    @OneToMany
//    private ArrayList<Comment> comments;
    //TODO: 댓글

    public Board(String username, String pwd, String author, String title, String context) {
        this.username = username;
        this.pwd = pwd;
        this.author = author;
        this.title = title;
        this.context = context;
    }

    public void updateBoard(Board board) {
        if (!board.getUsername().equals(this.username)) {
            this.username = board.getUsername();
        }
        if (!board.getAuthor().equals(this.author)) {
            this.author = board.getAuthor();
        }
        if (!board.getContext().equals(this.context)) {
            this.context = board.getContext();
        }
        if (!board.getTitle().equals(this.title)) {
            this.title = board.getTitle();
        }
        if (!board.getPwd().equals(this.pwd)) {
            this.pwd = board.getPwd();
        }

    }
    public void updateBoard(BoardDto board) {
        if (!board.username().equals(this.username)) {
            this.username = board.username();
        }
        if (!board.author().equals(this.author)) {
            this.author = board.author();
        }
        if (!board.context().equals(this.context)) {
            this.context = board.context();
        }
        if (!board.title().equals(this.title)) {
            this.title = board.title();
        }
        if (!board.pwd().equals(this.pwd)) {
            this.pwd = board.pwd();
        }
    }

}
