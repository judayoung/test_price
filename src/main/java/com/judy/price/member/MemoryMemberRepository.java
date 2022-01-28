package com.judy.price.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store=new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getCard_num(), member);
    }

    @Override
    public Member findByCard_num(Long card_num) {
        return store.get(card_num);
    }

}
