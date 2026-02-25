package org.example;

public class Satellite {
    private String name;
    private int radius;

    private int daysOfACompleteRotation; // περίοδος(ημέρες) μιας πλήρους περιστροφής του δορυφόρου γύρω από τον πλανήτη του)

    //προσθήκη αν ειναι αντιθετη η κανονικη φορα
    private boolean isNotNormal;

    public Satellite(String name, int radius, int daysOfACompleteRotation) {
        this.name = name;
        this.radius = radius;
        this.daysOfACompleteRotation = daysOfACompleteRotation;
    }

    public Satellite(String name, int radius, int daysOfACompleteRotation, boolean isNotNormal) {
        this.name = name;
        this.radius = radius;
        this.daysOfACompleteRotation = daysOfACompleteRotation;
        this.isNotNormal = isNotNormal;
    }

    public Satellite() {
    }
    public Satellite(String name) {
        this.name = name;
    }


    public Satellite(String name, int daysOfACompleteRotation) {
        this.name = name;
        this.daysOfACompleteRotation = daysOfACompleteRotation;
    }

    public String getName() {
        return name;
    }

    public boolean isNotNormal() {
        return isNotNormal;
    }

    public void setNotNormal(boolean notNormal) {
        isNotNormal = notNormal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getDaysOfACompleteRotation() {
        return daysOfACompleteRotation;
    }

    public void setDaysOfACompleteRotation(int daysOfACompleteRotation) {
        this.daysOfACompleteRotation = daysOfACompleteRotation;
    }

    public void printLunarMonth(){
        if(this.getName().equals("Europa") || this.getName().equals("Callisto") || this.getName().equals("Lysithea") || this.getName().equals("Niso") || this.getName().equals("Kalliroi") || this.getName().equals("Epimitheas")){
            double lunarMonths = this.daysOfACompleteRotation / 29.5;
            System.out.println("Satellite " + this.name + " has lunar Months : " + String.format("%.2f",lunarMonths));
        }
    }

    @Override
    public String toString() {
        return "Satellite{" +
                "name='" + name + '\'' +
                ", radius=" + radius +
                ", daysOfACompleteRotation=" + daysOfACompleteRotation +
                '}';
    }
}
