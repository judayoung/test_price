package com.judy.price.fare;

import com.judy.price.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceFarePolicyTest {

    DistanceFarePolicy farePolicy=new DistanceFarePolicy();

    @Test
    @DisplayName("회원은 등급에 따라 요금이 달라져야 한다.")
    void getFare() {
        Member etc=new Member(1L, "etc", true, 1980);
        Member oldman=new Member(2L, "oldMan", false, 1930);
        Member adult=new Member(2L, "adult", false, 1980);
        Member youth=new Member(2L, "youth", false, 2007);
        Member child=new Member(2L, "child", false, 2012);

        assertThat(farePolicy.getFare(etc, 58)).isEqualTo(0);
        assertThat(farePolicy.getFare(oldman, 58)).isEqualTo(0);
        assertThat(farePolicy.getFare(adult, 58)).isEqualTo(farePolicy.basicFare+900);
        assertThat(farePolicy.getFare(youth, 58)).isEqualTo((farePolicy.basicFare+900-350)*8/10);
        assertThat(farePolicy.getFare(child, 58)).isEqualTo((farePolicy.basicFare+900-350)*5/10);
    }

    @Test
    @DisplayName("성인 요금은 거리(3구간)에 따라 요금이 달라져야 한다.")
    void getAdultFare() {
        assertThat(farePolicy.getAdultFare(8)).isEqualTo(farePolicy.basicFare);
        assertThat(farePolicy.getAdultFare(14)).isEqualTo(farePolicy.basicFare + 100);
        assertThat(farePolicy.getAdultFare(16)).isEqualTo(farePolicy.basicFare + 200);
        assertThat(farePolicy.getAdultFare(50)).isEqualTo(farePolicy.basicFare + 800);
        assertThat(farePolicy.getAdultFare(58)).isEqualTo(farePolicy.basicFare + 900);
    }
}