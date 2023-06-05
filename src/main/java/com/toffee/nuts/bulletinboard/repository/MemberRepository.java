package com.toffee.nuts.bulletinboard.repository;


import com.toffee.nuts.bulletinboard.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findMemberByUserId(String userId);
}
