package org.example.W3Schools.JavaSmallProjectAndEx.ExX30;

import lombok.*;

import java.time.LocalDateTime;

enum MemberShipType {
    YEARLY, MONTHLY, PREMIUM
}

@Getter
@Setter
@NoArgsConstructor

@ToString
public class GymMemberShip {
    private String memberName;
    private MemberShipType type;
    private LocalDateTime duration;
    private double fee;

    public GymMemberShip(String memberName, MemberShipType type, LocalDateTime duration) {
        this.memberName = memberName;
        this.type = type;
        this.duration = duration;
    }

    public void calculateMembershipFees(MemberShipType type){
        if(type == MemberShipType.MONTHLY){
            fee = 69;
        } else if(type == MemberShipType.YEARLY) {
            fee = 50 * 12;
        } else if(type == MemberShipType.PREMIUM){
            fee = 90 * 12;
        }
        System.out.println("Your Membership fee is: " + fee + " for your Membership which is the --> " + type + " membership!");
    }

    public void checkForOffers(MemberShipType type){
        if(type == MemberShipType.MONTHLY && duration.isBefore(LocalDateTime.of(2026, 12, 10, 10,5))){
            fee = 69 - 10;
        } else if(type == MemberShipType.YEARLY && duration.isBefore(LocalDateTime.of(2026, 12, 10, 10,5))) {
            fee = (50 * 12) - 50;
        } else if(type == MemberShipType.PREMIUM){
            fee = 90 * 12;
        }
        System.out.println("Your Membership fee is: " + fee + " for your Membership which is the --> " + type + " membership!");
    }
}
