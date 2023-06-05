package com.toffee.nuts.bulletinboard.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Member extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String userId;
    private String nickName;
    private String password;
    private String dstAddr;

//    @OneToMany
//    private ArrayList<Comment> comments;


    public Member(String username, String userId, String nickName, String password, String dstAddr) {
        this.username = username;
        this.userId = userId;
        this.nickName = nickName;
        this.password = password;
        this.dstAddr = dstAddr;
    }

//    @OneToMany
//    private ArrayList<Board> boards;

    public void updateMember(Member member) {
        if(!this.username.equals(member.getUsername())) this.username = member.getUsername();
        if(!this.nickName.equals(member.getNickName())) this.nickName = member.getNickName();
        if(!this.password.equals(member.getPassword())) this.password = member.getPassword();
        if(!this.dstAddr.equals(member.getDstAddr())) this.dstAddr = member.getDstAddr();
    }
    public void changePassword(String password) {
        this.password = password;
    }

}
