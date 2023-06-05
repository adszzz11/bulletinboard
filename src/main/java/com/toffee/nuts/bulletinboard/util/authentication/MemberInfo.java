package com.toffee.nuts.bulletinboard.util.authentication;

import com.toffee.nuts.bulletinboard.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberInfo {
    Member member;
    ClientStatus status;
}
