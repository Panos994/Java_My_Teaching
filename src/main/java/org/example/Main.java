package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {//throws FileNotFoundException {
        //File file = new File("file.txt");
        File file2 = new File("solarsystem.txt");
        Planet base = new Planet("Earth", 1);
        PlanetSystem planetSystem = new PlanetSystem();
        SpaceShip spaceShip = new SpaceShip("PegasusΙΙΙ", "Panos Foteinopoulos Captain", 29, planetSystem, base, null, 0.05);
        try {
            File outPut = new File("output.txt");
            PrintStream printStream = new PrintStream(outPut); // αντι να καταληξει στην κονσολα το βαζω στο αρχειο https://www.bing.com/search?q=PrintStream%20Java&qs=n&form=QBRE&sp=-1&ghc=1&lq=0&pq=printstream%20jav&sc=2-15&sk=&cvid=BC7AA64EA38A463ABCE8F8A931F52B81
            System.setOut(printStream); // και εδω ουσιαστικα αντι να τυπωσει κονσολα τυπωνει στο αρχειο www.tutorialspoint.com/java/lang/system_setout.htm
            //spaceShip.initPlanets();
            //spaceShip.initPlanetsFromFile(file2);


            planetSystem.initStarAndPlanetsFromFile(file2, planetSystem);
            spaceShip.startTrip();
            System.out.println("-".repeat(500));
            for (Planet p : planetSystem.getPlanetList()) {
                p.printAirRingRadiusBiggerThanSpecificSatt(p);
            }
            System.out.println("-".repeat(500));
            for (Planet p : planetSystem.getPlanetList()) {
                p.printSatellitesRotationBiggerThanAprhoditeSun(p);
            }
            System.out.println(">".repeat(550));
            for (Planet p : planetSystem.getPlanetList()) {
                p.printSatThatAtmosphereHasO2andCH4(p);
            }
            System.out.println("|".repeat(600));
            for (Planet p : planetSystem.getPlanetList()) {
                p.printCaptainAge(spaceShip.getCaptainAge());
            }
            System.out.println("=".repeat(650));
            for (Planet p : planetSystem.getPlanetList()) {
                p.printEarthDay();
            }
            System.out.println("=".repeat(650));
            for(Planet p : planetSystem.getPlanetList()){
                for(Satellite s : p.getSatelliteList()){
                    s.printLunarMonth();
                }
            }
            System.out.println("-".repeat(450));
            System.out.println("Trip has started!");
            spaceShip.startTripV2();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error of creating the output file");
        }
    }
}