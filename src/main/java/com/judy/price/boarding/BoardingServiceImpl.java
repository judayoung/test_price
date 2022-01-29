package com.judy.price.boarding;

import com.judy.price.fare.FarePolicy;
import com.judy.price.member.Member;
import com.judy.price.member.MemberService;

import java.util.Date;

public class BoardingServiceImpl implements BoardingService{

    MemberService memberService;
    FarePolicy farePolicy;

    public BoardingServiceImpl(MemberService memberService, FarePolicy farePolicy) {
        this.memberService = memberService;
        this.farePolicy = farePolicy;
    }

    @Override
    public Boarding createBoarding(Long member_card_num, int distance) {
        Member member=memberService.findMember(member_card_num);
        Date date=new Date();
        int totalFare=farePolicy.getFare(member,distance);

        return new Boarding(member_card_num,date,distance,totalFare);
    }
}
