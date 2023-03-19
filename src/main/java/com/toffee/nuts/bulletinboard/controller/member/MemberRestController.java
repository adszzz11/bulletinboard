package com.toffee.nuts.bulletinboard.controller.member;

import com.toffee.nuts.bulletinboard.domain.Member;
import com.toffee.nuts.bulletinboard.service.member.MemberService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberRestController {

    MemberService memberService;

    @PostMapping("/member/create")
    public void createMember(@RequestBody @Validated Member member) {
        memberService.createMember(member);
    }

    @PostMapping("/member/findpassword")
    public String findmember(@RequestBody @Validated String userId) throws Exception {
        Member findMember = memberService.findMemberWithUserId(userId);
        return findMember.getPassword();
    }
}
