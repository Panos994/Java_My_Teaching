package org.example.W3Schools.JavaSmallProjectAndEx.ExX30;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        PersonalTrainer pt = new PersonalTrainer("Makis Papakis","Kick Boxing", true);
        PremiumMemberShip pm = new PremiumMemberShip("Georgios Kakoydis", MemberShipType.PREMIUM, LocalDateTime.of(2026, 12, 10, 10,5),pt,true);

        pm.checkForOffers(pm.getType());
        pm.calculateMembershipFees(pm.getType());

    }
}
