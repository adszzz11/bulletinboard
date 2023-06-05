package com.toffee.nuts.bulletinboard.util.authentication;

import com.toffee.nuts.bulletinboard.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class SessionAuthManager implements AuthManager {

    Map<String, MemberInfo> sessions = new ConcurrentHashMap<>();

    @Override
    public String generate(Member member) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, new MemberInfo(member, ClientStatus.USING));
        return sessionId;
    }

    @Override
    public ClientStatus checkCurrentState(String sessionId) {
        return sessions.get(sessionId).getStatus();

    }


    @Override
    public void updateCurrentState(String sessionId, ClientStatus status) {
        sessions.get(sessionId).setStatus(status);
    }

    @Override
    public void destroy(String sessionId) {
        sessions.remove(sessionId);
    }
}
