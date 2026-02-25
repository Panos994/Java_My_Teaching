package org.example;

import java.util.Scanner;

public class VelocityCar {
    public static String suddenStop(){
        Scanner sc = new Scanner(System.in);
        String result = "";
        System.out.println("Please give me the distance between vehicle and deer in meters: ");
        double distance = sc.nextDouble(); //αρχική απόσταση με το ελάφι
        System.out.println("Please give me your speed, reaction time and deceleration: ");
        double speed = sc.nextDouble();
        double reaction = sc.nextDouble();
        double deceleration = sc.nextDouble();
        Car myCar = new Car(speed, reaction, deceleration);

        double dantidrasi = myCar.getSpeed() * myCar.getReactionTime(); //πχ εδω 50.0
        double dfrenarisma = (myCar.getSpeed()*myCar.getSpeed()) / (2 * myCar.getDeceleration());
        double totalDistance = dantidrasi + dfrenarisma;   //βρισκω συνολικη απόσταση βάση του pdf
        double remainingDistance = distance - totalDistance;
        if(remainingDistance >=0){
            if(remainingDistance >= 10){
                result = "Aww what was this??";
            } else if(remainingDistance >=0 && remainingDistance <10){
                result = "Aww that was close!";
            }
        } else {
            double dfrenarismaBeforeCrash = distance - dantidrasi; //αποσταση κατα το φρεναρισμα
            double speed2 = Math.sqrt((myCar.getSpeed()*myCar.getSpeed()) - (2 * myCar.getDeceleration() * dfrenarismaBeforeCrash));
            if(speed2 < 10){
                result = "Deer jumped really far!";
            } else if (speed2 >= 10){
                result = "Crash was inevitable!";
            }
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(suddenStop());
    }

}
