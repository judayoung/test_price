package com.judy.price.member;

public interface MemberService {

    void join(Member member);
    Member findMember(Long card_num);

}
