package com.toffee.nuts.bulletinboard.service.member;

import com.toffee.nuts.bulletinboard.domain.Member;

public interface MemberService {

//    TODO Authentication 시 사용
//    void updateToken();
//    void deleteToken();
//    void createToken();



    Member login(String userId, String password) throws Exception;
    boolean logout(String userId) throws Exception;
    String findPasswordWithUserId(String userId) throws Exception;
    void changePassword(Long id, String password) throws Exception;
    void createMember(Member member);
    void deleteMember(Member member);
    Member findMemberWithUserId(String userId) throws Exception;
    Member findMember(Long id) throws Exception;
    void updateMember(Member member) throws Exception;


//    TODO 관리자용 Member로직. select를 여기 service에 추가해야할까?
//    void getMemberDescList(Pageable pageable);


}
