package com.toffee.nuts.bulletinboard.service.member;

public interface MemberService {

    void updateToken();
    void deleteToken();
    void createToken();

    void login();
    void logout();
    void findPassword();
    void changePassword();
    void deleteMember();

}
