package com.toffee.nuts.bulletinboard.service.member;

import com.toffee.nuts.bulletinboard.domain.Member;
import com.toffee.nuts.bulletinboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member login(String userId, String password) throws Exception {
        Member findMember = findMemberWithUserId(userId);
        if (findMember.getPassword().equals(password))
            return findMember;
        throw new Exception("password not match");
    }

    @Override
    public boolean logout(String userId) throws Exception {
        findMemberWithUserId(userId);
//        TODO 토큰 조회하는 로직 추가
//        TODO 토큰 제거하는 로직 추가
        return true;
    }

    @Override
    public String findPasswordWithUserId(String userId) throws Exception {
        Member findMember = findMemberWithUserId(userId);
        return findMember.getPassword();
    }

    @Override
    public void changePassword(Long id, String password) throws Exception {
        Member findMember = findMember(id);
        findMember.changePassword(password);
    }

    @Override
    public void createMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void deleteMember(Member member) {
        memberRepository.delete(member);
    }

    @Override
    public Member findMemberWithUserId(String userId) throws Exception {
        Optional<Member> findMember = memberRepository.findMemberByUserId(userId);
        if (findMember.isEmpty()) throw new Exception("cannot find member");
        return findMember.get();
    }

    @Override
    public Member findMember(Long id) throws Exception {
        Optional<Member> findMember = memberRepository.findById(id);
        if (findMember.isEmpty()) throw new Exception("cannot find member");
        return findMember.get();
    }
    @Override
    public void updateMember(Member member) throws Exception {
        Optional<Member> findMember = memberRepository.findById(member.getId());
        if (findMember.isEmpty()) throw new Exception("cannot find member");
        findMember.get().updateMember(member);
//        TODO 검증 로직 추가할까?
    }
}
