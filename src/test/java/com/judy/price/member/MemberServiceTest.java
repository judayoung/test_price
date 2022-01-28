package com.judy.price.member;

import com.judy.price.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.judy.price.member.Grade.ETC;
import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    void beforeEach(){
        AppConfig appConfig=new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    @DisplayName("회원가입 테스트")
    void join() {
        //given : 가상의 멤버 만들기
        Member member1 = new Member(1L, "member1", true, 2000);
        //when : 가입한 멤버와 id로 찾은 멤버
        memberService.join(member1);
        Member findMember1 = memberService.findMember(1L);
        System.out.println("member1 = "+member1);
        System.out.println("findMember1 = "+findMember1);
        //then
        assertThat(member1).isEqualTo(findMember1);
    }

    @Test
    @DisplayName("회원 등급 - ETC 테스트")
    void findMember() {
        //given
        Member member1 = new Member(1L, "member1", true, 2000);
        //when
        member1.setETC(false);
        System.out.println("member grade (set isETC->false) : "+member1.getGrade());
        //then
        assertThat(member1.getGrade()).isEqualTo(ETC);
    }
}