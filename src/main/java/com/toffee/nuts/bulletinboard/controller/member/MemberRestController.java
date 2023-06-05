package com.toffee.nuts.bulletinboard.controller.member;

import com.toffee.nuts.bulletinboard.domain.Member;
import com.toffee.nuts.bulletinboard.service.member.MemberService;
import com.toffee.nuts.bulletinboard.service.member.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberRestController {


    private final MemberServiceImpl memberService;

    @PostMapping("/create")
    public void createMember(@RequestBody @Validated Member member) {
        memberService.createMember(member);
    }

    @PostMapping("/find/password")
    public String findMemberByPassword(@RequestBody @Validated String userId) throws Exception {
        Member findMember = memberService.findMemberWithUserId(userId);
        return findMember.getPassword();
    }

    @PostMapping("/find/userid")
    public String findMemberById(@RequestBody @Validated String userId) throws Exception {
        Member findMember = memberService.findMemberWithUserId(userId);
        return findMember.getPassword();
    }

    @PostMapping("/remove")
    public String remove(@RequestBody @Validated Member member) {
        memberService.deleteMember(member);
        return "true";
    }
}
