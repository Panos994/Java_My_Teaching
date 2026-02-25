package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Planet {

    private String name;
    private double avgDistanceAU;

    private double density;

    private double yearsOfRotation;

    private double daysOfRotation;
    private boolean ring;
    private boolean landPlanet;

    private boolean airPlanet;

    private boolean midgetPlanet;

    private String atmosphere;

    private List<Satellite> satelliteList;

    public Planet(String name, double avgDistanceAU, double density, double yearsOfRotation, double daysOfRotation, boolean ring, boolean landPlanet, boolean airPlanet, boolean midgetPlanet, String atmosphere) {
        this.name = name;
        this.avgDistanceAU = avgDistanceAU;
        this.density = density;
        this.yearsOfRotation = yearsOfRotation;
        this.daysOfRotation = daysOfRotation;
        this.ring = ring;
        this.landPlanet = landPlanet;
        this.airPlanet = airPlanet;
        this.midgetPlanet = midgetPlanet;
        this.atmosphere = atmosphere;
        this.satelliteList = new ArrayList<>();
    }

    public Planet(String name, double yearsOfRotation) {
        this.name = name;
        this.yearsOfRotation = yearsOfRotation;
    }

    public Planet(Planet mercury) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvgDistanceAU() {
        return avgDistanceAU;
    }

    public void setAvgDistanceAU(double avgDistanceAU) {
        this.avgDistanceAU = avgDistanceAU;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getYearsOfRotation() {
        return yearsOfRotation;
    }

    public void setYearsOfRotation(double yearsOfRotation) {
        this.yearsOfRotation = yearsOfRotation;
    }

    public double getDaysOfRotation() {
        return daysOfRotation;
    }

    public void setDaysOfRotation(double daysOfRotation) {
        this.daysOfRotation = daysOfRotation;
    }

    public boolean isRing() {
        return ring;
    }

    public void setRing(boolean ring) {
        this.ring = ring;
    }

    public boolean isLandPlanet() {
        return landPlanet;
    }

    public void setLandPlanet(boolean landPlanet) {
        this.landPlanet = landPlanet;
    }

    public boolean isAirPlanet() {
        return airPlanet;
    }

    public void setAirPlanet(boolean airPlanet) {
        this.airPlanet = airPlanet;
    }

    public boolean isMidgetPlanet() {
        return midgetPlanet;
    }

    public void setMidgetPlanet(boolean midgetPlanet) {
        this.midgetPlanet = midgetPlanet;
    }

    public String getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(String atmosphere) {
        this.atmosphere = atmosphere;
    }

    public List<Satellite> getSatelliteList() {
        return satelliteList;
    }

    public void setSatelliteList(List<Satellite> satelliteList) {
        this.satelliteList = satelliteList;
    }

    public void addSatellite(Satellite satellite) {
        satelliteList.add(satellite);
    }

    public void printAirRingRadiusBiggerThanSpecificSatt(Planet planet) {
        int totalPlanets = 0;
        if (planet.isAirPlanet() && planet.isRing()) {
            Satellite satellite1 = new Satellite("ΠΟΛΥΔΕΥΚΗΣ", 2, 1);
            Satellite satellite2 = new Satellite("ΤΙΤΑΝΙΑ", 789, 2);
            for (Satellite satellite : planet.getSatelliteList()) {
                if (satellite.getRadius() >= satellite1.getRadius() && satellite.getRadius() <= satellite2.getRadius()) {
                    System.out.println("Planet that are air planets, has a ring and has bigger radius than Polydeukus and Titania are: " + planet.getName());
                    System.out.println("satellite names are " + satellite.getName());
                    System.out.println("-------------------------------------------------");
                    totalPlanets++;
                    System.out.println("Total planets with these characteristics are: " + totalPlanets);
                }
            }
        }
    }

    public void printSatellitesRotationBiggerThanAprhoditeSun(Planet planet) {
        Planet aphrodite = new Planet("Aphrodite", 0.615);
        Planet uranus = new Planet("Uranus", 84.0);
        Satellite mnimi = new Satellite("Mnimi", 3);
        int totalBiggerThanMnimiDaysRotation = 0;
        if (this.yearsOfRotation > aphrodite.getYearsOfRotation() && this.yearsOfRotation < uranus.getYearsOfRotation()) {
            for (Satellite s : planet.getSatelliteList()) {
                if (s.getDaysOfACompleteRotation() > mnimi.getDaysOfACompleteRotation()) {
                    totalBiggerThanMnimiDaysRotation++;
                }
            }
            if (totalBiggerThanMnimiDaysRotation > 3) {
                System.out.println("Total satellites with rotation > 3: " + totalBiggerThanMnimiDaysRotation);
                for (Satellite s : this.satelliteList) {
                    if (s.getDaysOfACompleteRotation() > mnimi.getDaysOfACompleteRotation()) {
                        System.out.println("Satellite name: " + s.getName() + " | Rotation period " + s.getDaysOfACompleteRotation());
                    }
                }
            }
        }
    }

    public void printSatThatAtmosphereHasO2andCH4(Planet planet) {
        Satellite ydra = new Satellite("Ydra", 5, 10, false);
        Satellite kerveros = new Satellite("Kerveros", 13, 3, false); //ypothesi oti o kerveros exei fora 0 ennoontas oti einai antitheti

        if (this.getAtmosphere().contains("O2") || this.getAtmosphere().contains("CH4")) {
            for (Satellite s : planet.getSatelliteList()) {
                if (s.getRadius() > ydra.getRadius() && s.isNotNormal() != kerveros.isNotNormal()) {
                    System.out.println("Satellite name that has O2 or CH4, and radius is bigger than Ydra's satellite radius and has a opposite direction of Kerveros satellite is/ are: " + s.getName() + " | Radius: " + s.getRadius());
                }
            }
        }
    }

    public void printCaptainAge(double age) {
        if (this.name.equals("Mercury") || this.name.equals("Jupiter") || this.name.equals("Uranus") || this.name.equals("Neptune")) {
            age = age / this.yearsOfRotation;
            System.out.println("Captain's age if it was in this planet " + this.getName() + " would be " + String.format("%.2f", age));
        }
    }

    public void printEarthDay() {
        if (this.name.equals("Jupiter") || this.name.equals("Uranus") || this.name.equals("Neptune")) {
            double daysOfRotation2 = this.daysOfRotation * 24;
            System.out.println("One day in the planet: " + this.getName() + " endures : " + String.format("%.2f", daysOfRotation2) + " days ");
        }
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", avgDistanceAU=" + avgDistanceAU +
                ", density=" + density +
                ", yearsOfRotation=" + yearsOfRotation +
                ", daysOfRotation=" + daysOfRotation +
                ", ring=" + ring +
                ", landPlanet=" + landPlanet +
                ", airPlanet=" + airPlanet +
                ", midgetPlanet=" + midgetPlanet +
                ", atmosphere='" + atmosphere + '\'' +
                ", satelliteList=" + satelliteList +
                '}';
    }
}
