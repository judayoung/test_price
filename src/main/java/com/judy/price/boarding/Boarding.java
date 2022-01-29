package com.judy.price.boarding;

import java.util.Date;

public class Boarding {

    private Long member_card_num;
    private Date date;
    private int distance;
    private int totalFare;

    public Boarding(Long member_card_num, Date date, int distance, int totalFare) {
        this.member_card_num = member_card_num;
        this.date = date;
        this.distance = distance;
        this.totalFare = totalFare;
    }

    public Boarding() {
    }

    public Long getMember_card_num() {
        return member_card_num;
    }

    public void setMember_card_num(Long member_card_num) {
        this.member_card_num = member_card_num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(int totalFare) {
        this.totalFare = totalFare;
    }

    @Override
    public String toString() {
        return "Boarding{" +
                "member_card_num=" + member_card_num +
                ", date=" + date +
                ", distance=" + distance +
                ", totalFare=" + totalFare +
                '}';
    }
}
