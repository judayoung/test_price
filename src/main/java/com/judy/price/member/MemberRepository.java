package com.judy.price.member;

public interface MemberRepository {

    void save(Member member);
    Member findByCard_num(Long card_num);

}
