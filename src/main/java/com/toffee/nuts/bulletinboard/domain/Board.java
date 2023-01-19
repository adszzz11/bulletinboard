package com.toffee.nuts.bulletinboard.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

@Entity
@RequiredArgsConstructor
public class Board {

    @Id @GeneratedValue
    private AtomicLong id;


    // 게시물 변경을 위한 id, pwd 정보 사용
    //TODO: login 시스템 들어올 시 userId 값으로 변경할 수 있도록 변경
    private String username;
    private String pwd;
    //작성자(수정가능)
    //TODO: login 시스템 들어올 시 자동 mapping
    private String author;

    private String title;
    //내용
    private String context;

    //TODO: 댓글
}
