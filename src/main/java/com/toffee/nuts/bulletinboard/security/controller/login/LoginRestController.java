package com.toffee.nuts.bulletinboard.security.controller.login;

import com.toffee.nuts.bulletinboard.domain.Member;
import com.toffee.nuts.bulletinboard.service.member.MemberServiceImpl;
import com.toffee.nuts.bulletinboard.security.session.SessionAuthManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@SessionAttributes("member")
@Slf4j
@RequiredArgsConstructor
public class LoginRestController {

    private final MemberServiceImpl memberService;
    private final SessionAuthManager authManager;

    @GetMapping("/login/test")
    public void initData() {
        memberService.createMember(new Member("sm", "sm", "sm", "aaaa", "01034087477"));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam @Validated String userId, @RequestParam @Validated String password) {
        log.info("userId={}, password={}", userId, password);
        try {
            Member member = memberService.login(userId, password);
            //Token

            //Session
            String sessionId = authManager.generate(member);


            HttpHeaders headers = new HttpHeaders();
            headers.set("sessionId", sessionId);

            return new ResponseEntity<>("success", headers, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("fail", null, HttpStatus.OK);

    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(@RequestParam String sessionId) {
        try {
            authManager.destroy(sessionId);
            return new ResponseEntity<>("Success", null, HttpStatus.OK);
        } catch (Exception e) {

        }
        return new ResponseEntity<>("Fail", null, HttpStatus.OK);
    }

}
