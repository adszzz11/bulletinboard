package com.toffee.nuts.bulletinboard.security;

import com.toffee.nuts.bulletinboard.domain.Member;


public interface AuthManager {
    String generate(Member member);
    ClientStatus checkCurrentState(String sessionId);

    void updateCurrentState(String sessionId, ClientStatus status);

    void destroy(String sessionId);


}
