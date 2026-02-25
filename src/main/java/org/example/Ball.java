package org.example;

public class Ball implements Comparable<Ball>{

    private String color;
    private MaterialBall material;
    private double weight;

    public Ball(String color, double weight, MaterialBall material) {
        this.color = color;
        this.weight = weight;
        this.material = material;
    }

    public Ball() {
    }

    public Ball(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public MaterialBall getMaterial() {
        return material;
    }

    public void setMaterial(MaterialBall material) {
        this.material = material;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean changeColorByMoreThanWeight(String color, double number){
        if(weight >= number){
            this.color = color;
            return true;
        }
        return false;
    }

    public void printAll(){
        System.out.println("Ball's color is " + color + " , weight " + weight + " and material is " + material);
    }

    @Override
    public int compareTo(Ball o) {
        return this.color.compareTo(o.getColor());
    }



}
