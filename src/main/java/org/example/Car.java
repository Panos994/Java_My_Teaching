package org.example;

public class Car {
    private double speed;
    private double reactionTime;
    private double deceleration;

    public Car(double speed, double reactionTime, double deceleration){
        this.speed = speed;
        this.reactionTime = reactionTime;
        this.deceleration = deceleration;
    }

    public double getSpeed(){
        return speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }

    public double getReactionTime() {
        return reactionTime;
    }

    public void setReactionTime(int reactionTime) {
        this.reactionTime = reactionTime;
    }

    public double getDeceleration() {
        return deceleration;
    }

    public void setDeceleration(int deceleration) {
        this.deceleration = deceleration;
    }
}
