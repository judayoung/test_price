package com.judy.price.fare;

import com.judy.price.member.Grade;
import com.judy.price.member.Member;

import static com.judy.price.member.Grade.*;

public class DistanceFarePolicy implements FarePolicy{

    @Override
    public int getFare(Member member, int distance) {
        Grade grade = member.getGrade();
        int fare=0;  // ETC, OLDMAN

        if(grade != ETC && grade != OLDMAN){
            fare=getAdultFare(distance);

            if(grade==YOUTH){
                fare= (fare-350) * 8 / 10;
            }else if(grade==CHILD){
                fare= (fare-350) * 5 / 10;
            }
        }

        return fare;
    }

    public int getAdultFare(int distance){
        int fare=1250;  // 10km 이내
        int oneStep=10;
        int twoStep=50;
        int farePerDistance=100;

        if(distance > oneStep && distance < twoStep){
            int extraFare = (distance-oneStep)/5 * farePerDistance;
            fare += extraFare;
        }else if(distance > twoStep){
            fare += (twoStep-oneStep)/5 * farePerDistance;
            int extraFare = (distance-twoStep)/8 * farePerDistance;
            fare += extraFare;
        }
        return fare;
    }
}
