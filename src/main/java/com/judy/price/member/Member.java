package com.judy.price.member;

import java.util.Calendar;

import static com.judy.price.member.Grade.*;

public class Member {

    private static int YEAR = Calendar.YEAR;

    private Long card_num;
    private String name;
    private Boolean isETC;
    private int birth;
    private Grade grade;

    public Member() {
    }

    // 1. 회원이 생성될 때 등급결정
    // Member member1=new Member(card_num,name,isETC,birth);
    // member1.getGrade(); -> 등급이 정해져야 한다.
    public Member(Long card_num, String name, Boolean isETC, int birth) {
        this.card_num = card_num;
        this.name = name;
        this.isETC = isETC;
        this.birth = birth;
        this.grade = calculateGrade(isETC, birth);
    }

    // 등급 계산기
    private Grade calculateGrade(Boolean isETC, int birth){
        Grade grade=null;

        if(isETC){
            grade=ETC;
        }else{
            int age=YEAR-birth;

            if(age>=60){
                grade=OLDMAN;
            }else if(age >= 20){
                grade=ADULT;
            }else if(age >= 14){
                grade=YOUTH;
            }else if(age >= 8){
                grade=CHILD;
            }else{
                grade=ETC;
            }
        }

        return grade;
    }

    // idETC나 birth를 바꾸면 Grade도 바뀌어야 한다.
    public Boolean getETC() {
        return isETC;
    }
    public void setETC(Boolean isETC) {
        this.isETC = isETC;
        this.grade=calculateGrade(this.isETC, this.birth);
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
        this.grade=calculateGrade(this.isETC, this.birth);
    }

    public Grade getGrade() {
        return grade;
    }

    // grade는 임의로 변경할 수 없게 주석처리한다.
//    public void setGrade(Grade grade) {
//        this.grade = grade;
//    }

    public long getCard_num() {
        return card_num;
    }

    public void setCard_num(long card_num) {
        this.card_num = card_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Member{" +
                "card_num=" + card_num +
                ", name='" + name + '\'' +
                ", isETC=" + isETC +
                ", birth=" + birth +
                ", grade=" + grade +
                '}';
    }
}
