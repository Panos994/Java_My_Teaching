package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlanetSystem {

    private Star star;
    private List<Planet> planetList = new ArrayList<>();

    public PlanetSystem(Star star, List<Planet> planetList) {
        this.star = star;
        this.planetList = planetList;
    }

    public PlanetSystem() {
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public List<Planet> getPlanetList() {
        return planetList;
    }

    public void setPlanetList(List<Planet> planetList) {
        this.planetList = planetList;
    }

    public Planet getPlanet(String planetName){
        Planet temp = new Planet(new Planet("Mercury", 0.39, 5.43, 0.24, 58.6, false, true, false, false, "Thin (O2, Na, H2)"));
        for(Planet planet : planetList){
            if(planetName.equals(planet.getName())){
                return temp;
            }
        }
        return null;
    }

    public Satellite getSatellite(String satelliteName){
        for(Planet planet : planetList){
            for(Satellite satellite : planet.getSatelliteList()){
                if(satelliteName.equals(satellite.getName())){
                    return satellite;
                }
            }
        }
        return null;
    }

    public void initStarAndPlanetsFromFile(File file, PlanetSystem planetSystem) { //https://www.w3schools.com/java/java_files_read.asp
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
                if(fields.length > 10){
                    String[] satellites = fields[10].split(";");
                    for(String satellite : satellites){
                        String[] fields2 = satellite.split(":");
                        String satName = fields2[0];
                        int radius = Integer.parseInt(fields2[1]);
                        int daysOfRotations = Integer.parseInt(fields2[2]);
                        boolean isNotNormal = (fields2.length > 3) ? Boolean.parseBoolean(fields2[3]) : false;
                        newPlanet.addSatellite(new Satellite(satName, radius, daysOfRotations, isNotNormal));
                    }
                }
                getPlanetList().add(newPlanet);
            }
            System.out.println("-".repeat(500));
            System.out.printf("%-20s", "Planets in our trip are:");
            System.out.println();
            System.out.printf("%-20s | %-12s | %-12s | %-25s | %-25s | %-12s | %-12s | %-12s | %-12s | %-12s%n", "NAME", "DISTANCE", "DENSITY", "YEARS OF ROTATION", "DAYS OF ROTATION", "RING", "LAND PLANET", "AIR PLANET", "MIDGET PLANET", "ATMOSPHERE");
            for(Planet p : getPlanetList()){
                System.out.printf("%-20s | %-12s | %-12s | %-25s | %-25s | %-12s | %-12s | %-12s | %-12s | %-12s%n",p.getName(), p.getAvgDistanceAU(), p.getDensity(), p.getYearsOfRotation(), p.getDaysOfRotation(),p.isRing(), p.isLandPlanet(), p.isAirPlanet(), p.isMidgetPlanet(),p.getAtmosphere());
//                if(p.getName().equals("Earth")){
//                    Satellite moon = new Satellite("Moon", 1737,28);
//                    p.addSatellite(moon);
//                } else if(p.getName().equals("Mars")){
//                    Satellite fovos = new Satellite("Fovos", 11,1);
//                    p.addSatellite(fovos);
//                } else if(p.getName().equals("Jupiter")){
//                    Satellite io = new Satellite("IO",1821,2);
//                    Satellite europe = new Satellite("Europe",1560,4);
//                    Satellite kallisto = new Satellite("Kallisto",2410,17);
//                    p.addSatellite(io);
//                    p.addSatellite(europe);
//                    p.addSatellite(kallisto);
//                }
                if(!p.getSatelliteList().isEmpty()){

                    for(Satellite satellite : p.getSatelliteList()){
                        System.out.println("------");
                        System.out.println(" has these/this satellites >>>> " + satellite.getName() + " and radius is " + satellite.getRadius() + " and days of a complete rotation is " + satellite.getDaysOfACompleteRotation());
                        System.out.println("------");
                    }
                }
            }
            //System.out.printf("%-20s", getPlanetSystem().getPlanetList());
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
        Star solarSystemStar = new Star("Sun", 5000000000.0, 1.410, 1410000000000000000.0);
        System.out.println("And star of this solar system is " +  solarSystemStar.getName() + " and its age is approximately " + solarSystemStar.getAge() + " and density is " + solarSystemStar.getDensity() + " *10^27, and volume is " + solarSystemStar.getVolume());
        totalSolarDensity();
    }
    public void totalSolarDensity(){
        double totalDensity = 0;
        for(Planet p : planetList){
            if(p.getSatelliteList().size() > 2){
                System.out.println("-".repeat(700));
                System.out.println();
                totalDensity+=p.getDensity();
                System.out.println("Name of planet: " + p.getName());
                for(Satellite satellite : p.getSatelliteList()){
                    System.out.println("satellites name: " + satellite.getName());
                }
            }
        }
        System.out.println("Solar system's total density is " + totalDensity);
    }

    @Override
    public String toString() {
        return "PlanetSystem{" +
                "star=" + star +
                ", planetList=" + planetList +
                '}';
    }
}
