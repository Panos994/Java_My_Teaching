package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.AnnotatedArrayType;
import java.math.BigDecimal;
import java.util.*;
import java.util.Scanner;

public class SpaceShip {

    private static final double AU_KM = 149597870.7;
    private String spaceShipName;
    private String captainName;
    private int captainAge;

    private PlanetSystem planetSystem;
    private Planet basePlanet;
    private Planet targetPlanet;
    private double tripSpeedAU;

    public SpaceShip(String spaceShipName, String captainName, int captainAge, PlanetSystem planetSystem, Planet basePlanet, Planet targetPlanet, double tripSpeedAU) {
        this.spaceShipName = spaceShipName;
        this.captainName = captainName;
        this.captainAge = captainAge;
        this.planetSystem = planetSystem;
        this.basePlanet = basePlanet;
        this.targetPlanet = targetPlanet;
        this.tripSpeedAU = tripSpeedAU;
    }

    public SpaceShip(String spaceShipName, String captainName, int captainAge, Planet basePlanet, Planet targetPlanet, double tripSpeedAU) {
        this.spaceShipName = spaceShipName;
        this.captainName = captainName;
        this.captainAge = captainAge;
        this.basePlanet = basePlanet;
        this.targetPlanet = targetPlanet;
        this.tripSpeedAU = tripSpeedAU;

    }

    public SpaceShip() {
        this.planetSystem = new PlanetSystem();
    }

    public String getSpaceShipName() {
        return spaceShipName;
    }

    public void setSpaceShipName(String spaceShipName) {
        this.spaceShipName = spaceShipName;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public int getCaptainAge() {
        return captainAge;
    }

    public void setCaptainAge(int captainAge) {
        this.captainAge = captainAge;
    }

    public PlanetSystem getPlanetSystem() {
        return planetSystem;
    }

    public void setPlanetSystem(PlanetSystem planetSystem) {
        this.planetSystem = planetSystem;
    }

    public Planet getBasePlanet() {
        return basePlanet;
    }

    public void setBasePlanet(Planet basePlanet) {
        this.basePlanet = basePlanet;
    }

    public Planet getTargetPlanet() {
        return targetPlanet;
    }

    public void setTargetPlanet(Planet targetPlanet) {
        this.targetPlanet = targetPlanet;
    }

    public double getTripSpeedAU() {
        return tripSpeedAU;
    }

    public void setTripSpeedAU(double tripSpeedAU) {
        this.tripSpeedAU = tripSpeedAU;
    }

    public List<Planet> initPlanets() {
        Random rand = new Random();
        List<Planet> planets = Arrays.asList(
                new Planet("Mercury", 0.39, 5.43, 0.24, 58.6, false, true, false, false, "Thin"),
                new Planet("Venus", 0.72, 5.24, 0.62, 243, false, true, false, false, "CO2"),
                new Planet("Earth", 1.0, 5.51, 1.0, 1.0, false, true, true, false, "N2/O2"),
                new Planet("Mars", 1.52, 3.93, 1.88, 1.03, false, true, false, false, "CO2"),
                new Planet("Jupiter", 5.20, 1.33, 11.86, 0.41, true, false, true, false, "H2")
        );

        int numberOfPlanets = 5;
        for (int i = 0; i < numberOfPlanets; i++) {
            Planet randomPlanetGeneration = planets.get(rand.nextInt(planets.size()));
            planetSystem.getPlanetList().add(new Planet(randomPlanetGeneration.getName(), randomPlanetGeneration.getAvgDistanceAU(), randomPlanetGeneration.getDensity(), randomPlanetGeneration.getYearsOfRotation(), randomPlanetGeneration.getDaysOfRotation(), randomPlanetGeneration.isRing(), randomPlanetGeneration.isLandPlanet(), randomPlanetGeneration.isAirPlanet(), randomPlanetGeneration.isMidgetPlanet(), randomPlanetGeneration.getAtmosphere()));
        }
        System.out.println("Whole trip has this planets stations: " + planets.toString());
        return planets;


    }

    public void initPlanetsFromFile(File file) { //https://www.w3schools.com/java/java_files_read.asp
        //file = new File("file.txt");

        try (Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                String[] fields = data.split(",");

                String name = fields[0];
                double distance = Double.parseDouble(fields[1]);
                double density = Double.parseDouble(fields[2]);
                double yearsOfRotation = Double.parseDouble(fields[3]);
                double daysOfRotation = Double.parseDouble(fields[4]);
                boolean ring = Boolean.parseBoolean(fields[5]);
                boolean landPlanet = Boolean.parseBoolean(fields[6]);
                boolean airPlanet = Boolean.parseBoolean(fields[7]);
                boolean midgetPlanet = Boolean.parseBoolean(fields[8]);
                String atmosphere = fields[9];
                Planet newPlanet = new Planet(name, distance, density, yearsOfRotation, daysOfRotation, ring, landPlanet, airPlanet, midgetPlanet, atmosphere);
                planetSystem.getPlanetList().add(newPlanet);
            }
            System.out.println("-".repeat(500));
            System.out.printf("%-20s", "Planets in our trip are:");
            System.out.println();
            System.out.printf("%-20s | %-12s | %-12s | %-25s | %-25s | %-12s | %-12s | %-12s | %-12s | %-12s%n", "NAME", "DISTANCE", "DENSITY", "YEARS OF ROTATION", "DAYS OF ROTATION", "RING", "LAND PLANET", "AIR PLANET", "MIDGET PLANET", "ATMOSPHERE");
            for (Planet p : getPlanetSystem().getPlanetList()) {
                System.out.printf("%-20s | %-12s | %-12s | %-25s | %-25s | %-12s | %-12s | %-12s | %-12s | %-12s%n", p.getName(), p.getAvgDistanceAU(), p.getDensity(), p.getYearsOfRotation(), p.getDaysOfRotation(), p.isRing(), p.isLandPlanet(), p.isAirPlanet(), p.isMidgetPlanet(), p.getAtmosphere());
            }
            //System.out.printf("%-20s", getPlanetSystem().getPlanetList());
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    public Planet travel(Planet base, Planet target) {
        double distance = Math.abs(base.getAvgDistanceAU() - target.getAvgDistanceAU());
        double distanceKM = Math.abs(distance * AU_KM);
        System.out.println();
        System.out.println("Trip distance for " + base.getName() + " and " + target.getName() + " is: " + String.format("%.2f", distanceKM) + " kilometers");
        int travelYears = (int) Math.ceil(distance);
        for (int i = 1; i < travelYears; i++) {
            System.out.println("Travelling at year number: " + i + " for target planet, so " + i + "  years have passed");
        }
        System.out.println("Finally we arrived at final target planet ===> " + target.getName());
        return target;
    }

    public void startTrip() {
        List<Planet> route = planetSystem.getPlanetList();
        Planet currentBase = route.get(0);
        for (int i = 1; i < route.size(); i++) {
            Planet target = route.get(i);
            currentBase = travel(currentBase, target);
            System.out.println("Ready for next planet, and current location is: " + currentBase.getName());
            System.out.println();
            System.out.println("-".repeat(500));
        }
        System.out.println("Whole trip completed successfuly!");
    }

    public void startTripV2() {
        List<Planet> route = new ArrayList<>();
        Planet earth = null;
        for (Planet p : planetSystem.getPlanetList()) {
            if (p.isLandPlanet()) { //na vro gioinous planites
                route.add(p);
            }
            if (p.getName().equals("Earth")) {
                earth = p; // kai edo an einai i Gh na tin apothikeyso
            }
        }
        System.out.println("Years needed from earth to land planets");
        Planet furtherPlanet = route.get(0);
        double max = 0.0;
        for (Planet pl : route) {
            if (pl.getName().equals("Earth")) {
                continue;
            }
            double distAu = Math.abs(earth.getAvgDistanceAU() - pl.getAvgDistanceAU());
            System.out.println("From Earth to " + pl.getName() + " we need " + String.format("%.2f", distAu) + " years");
            if (distAu > max) {
                max = distAu;
                furtherPlanet = pl;
            }
        }
        System.out.println("Furthest target planet is: " + furtherPlanet.getName());
        Planet currentLocation = travel(earth, furtherPlanet); //ταξιδεθω απο γη στον μακρυτερο
        //taksinomo meta planites βαση του avgdistanceAU
        route.sort(Comparator.comparingDouble(Planet::getAvgDistanceAU));

        if (!currentLocation.getName().equals("Earth")) { //αν δεν ειμαι στην γη να επιστρεψω προς την γη
            travel(currentLocation, earth);
        }

        System.out.println("Whole trip completed successfuly and returned to Earth!");
    }

    @Override
    public String toString() {
        return "SpaceShip{" +
                "spaceShipName='" + spaceShipName + '\'' +
                ", captainName='" + captainName + '\'' +
                ", captainAge=" + captainAge +
                ", planetSystem=" + planetSystem +
                ", basePlanet=" + basePlanet +
                ", targetPlanet=" + targetPlanet +
                ", tripSpeedAU=" + tripSpeedAU +
                '}';
    }
}
