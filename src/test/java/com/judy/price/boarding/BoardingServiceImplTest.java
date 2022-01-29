package com.judy.price.boarding;

import com.judy.price.AppConfig;
import com.judy.price.member.Member;
import com.judy.price.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class BoardingServiceImplTest {

    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService=ac.getBean(MemberService.class);
    BoardingService boardingService=ac.getBean(BoardingService.class);

    @Test
    @DisplayName("Boarding이 입력된 대로 잘 생성되는지 확인.")
    void createBoarding(){

        // given : 가상의 회원 생성
        Member member=new Member(1L, "member", true, 1980);
        memberService.join(member);
        int distance=58;
        // then
        System.out.println(boardingService.createBoarding(member.getCard_num(), distance));
        assertThat(boardingService.createBoarding(member.getCard_num(), distance).getTotalFare()).isEqualTo(0);
    }

}