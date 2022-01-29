package com.judy.price.fare;

import com.judy.price.member.Member;

public interface FarePolicy {

    /*
    return 거리에 따른 요금
     */
    int getFare(Member member, int distance);

}
