package org.example.W3Schools.JavaSmallProjectAndEx.ExX30;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PremiumMemberShip extends GymMemberShip{
    private PersonalTrainer personalTrainer;
    private boolean isSpaAvailable;

    public PremiumMemberShip(String memberName, MemberShipType type, LocalDateTime duration, PersonalTrainer personalTrainer, boolean isSpaAvailable) {
        super(memberName, type, duration);
        this.personalTrainer = personalTrainer;
        this.isSpaAvailable = isSpaAvailable;
    }

    @Override
    public void calculateMembershipFees(MemberShipType type) {
        super.calculateMembershipFees(type);
        if(type == MemberShipType.PREMIUM) {
            double extra = 0;
            if(personalTrainer != null && personalTrainer.isAvailable()) {
                extra += 20; // έξτρα χρέωση για personal trainer
                System.out.println("Personal trainer is available and you get an extra charge");
            }
            if(isSpaAvailable) {
                extra += 15; // έξτρα χρέωση για spa
                System.out.println("Spa is available and you get an extra charge");
            }
            setFee(getFee() + extra);
            System.out.println("Additional fees for Premium services: " + extra);
            System.out.println("Total fee with Premium services: " + getFee());
        }
    }

    @Override
    public void checkForOffers(MemberShipType type) {
        super.checkForOffers(type);
        if(type == MemberShipType.PREMIUM){
            isSpaAvailable = true;
            System.out.println("Spa is available --> " + isSpaAvailable);
            System.out.println("Also personal trainer is available --> " + personalTrainer.isAvailable());
        }
    }
}
