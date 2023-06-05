package com.toffee.nuts.bulletinboard.util.authentication;

import com.toffee.nuts.bulletinboard.domain.Member;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface AuthManager {
    String generate(Member member);
    ClientStatus checkCurrentState(String sessionId);

    void updateCurrentState(String sessionId, ClientStatus status);

    void destroy(String sessionId);


}
