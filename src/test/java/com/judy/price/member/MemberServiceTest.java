package com.judy.price.member;

import com.judy.price.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.judy.price.member.Grade.*;
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
    void joinFind() {
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
    @DisplayName("회원 등급 테스트_o")
    void grade_o() {
        //given
        Member member1 = new Member(1L, "member1", true, 2000);
        Member member2 = new Member(2L, "member2", false, 1930);
        Member member3 = new Member(3L, "member3", false, 1984);
        Member member4 = new Member(4L, "member4", false, 2005);
        Member member5 = new Member(5L, "member5", false, 2010);
        Member member6 = new Member(6L, "member2", false, 2019);
        //then
        assertThat(member1.getGrade()).isEqualTo(ETC);
        assertThat(member2.getGrade()).isEqualTo(OLDMAN);
        assertThat(member3.getGrade()).isEqualTo(ADULT);
        assertThat(member4.getGrade()).isEqualTo(YOUTH);
        assertThat(member5.getGrade()).isEqualTo(CHILD);
        assertThat(member6.getGrade()).isEqualTo(ETC);
    }

    @Test
    @DisplayName("회원 등급 테스트_isETC 변경")
    void grade_isETC() {
        //given
        Member member1 = new Member(1L, "member1", true, 2000);
        //when
        member1.setETC(false);
        //then
        assertThat(member1.getGrade()).isEqualTo(ADULT);
    }

    @Test
    @DisplayName("회원 등급 테스트_birth 변경")
    void grade_birth() {
        //given
        Member member1 = new Member(1L, "member1", false, 2000);
        //when
        member1.setBirth(1920);
        //then
        assertThat(member1.getGrade()).isEqualTo(OLDMAN);
    }

}