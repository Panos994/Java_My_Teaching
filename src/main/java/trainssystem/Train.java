package trainssystem;

import trainssystem.TrainCar.TrainCar;
import trainssystem.regionaltrains.LocalTrains;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Train {
    Random rand = new Random();

    protected int trainNumber; //accessible within the same class, same package subclass, same package non-subclasses, different package subclass AND NOT different package non-subclass
    protected int maxSpeedMilesPerHour;   // τελική ταχύτητα τρένου (μίλια ανά ώρα)
    protected int currentSpeedMilesPerHour;   // μέση ταχύτητα τρένου (μίλια ανά ώρα) από σταθμό σε σταθμό.
    protected List<TrainCar> trainCars; // βαγόνια
    protected List<TrainStop> route;  // η συνολική διαδρομή με σταθμούς που πρόκειται να εξυπηρετήσει το τρένο
    protected TrainStop currentStop;  // η τρέχουσα στάση που βρίσκεται το τρένο
    protected double ticketCostPerMile; // Κόστος εισιτηρίου ανά μίλι για ΕΝΑΝ επιβάτη (ή μονάδα φορτίου).

    // Σημείωση: Τα συνολικά έσοδα (earningsSoFar) υπολογίζονται δυναμικά ως:
    // ticketCostPerMile * διανυθέντα μίλια * τρέχουσες μονάδες φορτίου (units).
    protected double earningsSoFar; // τα συνολικά έσοδα του τρένου κατά την τρέχουσα στάση που βρίσκεται στην διαδρομή του.

    // Κατασκευαστής (constructor)
    protected Train(int trainNumber) {
        this.trainNumber = trainNumber;
        this.trainCars = new ArrayList<>();
        this.maxSpeedMilesPerHour = rand.nextInt(140,320);
        this.currentSpeedMilesPerHour = rand.nextInt(100,200);
        this.route = new ArrayList<>();
        //this.ticketCostPerMile = rand.nextDouble(5, 10);
        //this.currentStop = currentStop;
        this.earningsSoFar = ticketCostPerMile * currentSpeedMilesPerHour; //θελει και τα units εδω
    }

    // Μέθοδοι (methods)
    // υλοποιήστε τους getters & setters και όσες άλλες μεθόδους χρειαστείτε
    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getMaxSpeedMilesPerHour() {
        return maxSpeedMilesPerHour;
    }

    public void setMaxSpeedMilesPerHour(int maxSpeedMilesPerHour) {
        this.maxSpeedMilesPerHour = maxSpeedMilesPerHour;
    }

    public int getCurrentSpeedMilesPerHour() {
        return currentSpeedMilesPerHour;
    }

    public void setCurrentSpeedMilesPerHour(int currentSpeedMilesPerHour) {
        this.currentSpeedMilesPerHour = currentSpeedMilesPerHour;
    }

    public List<TrainCar> getTrainCars() {
        return trainCars;
    }

    public void setTrainCars(List<TrainCar> trainCars) {
        this.trainCars = trainCars;
    }

    public List<TrainStop> getRoute() {
        return route;
    }

    public void setRoute(List<TrainStop> route) {
        this.route = route;
    }

    public TrainStop getCurrentStop() {
        return currentStop;
    }

    public void setCurrentStop(TrainStop currentStop) {
        this.currentStop = currentStop;
    }

    public double getTicketCostPerMile() {

        return ticketCostPerMile;
    }


    public void extractPrices(Train tr) {
        double ticketCost = 0.0;
        int routeSize = tr.getRoute().size();
        //System.out.println(tr.trainNumber + " Το επόμενο τρένο έχει ώρα άφιξης/ αναχώρησης και κόστος εισητηρίου: \n");
        if (routeSize < 10) {
            ticketCost = 10.0;
        } else if (routeSize < 20) {
            ticketCost = 15.0;
        } else if (routeSize < 30) {
            ticketCost = 20.0;
        } else if (routeSize < 40) {
            ticketCost = 30.0;
        } else {
            ticketCost = 40.0;
        }
        //System.out.println("Κόστος εισητηρίου  για το τρενο: " + tr.getTrainNumber() + " ειναι " + ticketCost + " ευρώ");
    }

    public void setTicketCostPerMile(double ticketCostPerMile) {
        this.ticketCostPerMile = ticketCostPerMile;
    }

    public double getEarningsSoFar() {
        return earningsSoFar;
    }

    public void setEarningsSoFar(double earningsSoFar) {
        this.earningsSoFar = earningsSoFar;
    }



    public void addTrainsCars(TrainCar car){
        trainCars.add(car);
    }
    public void removeTrainsCars(TrainCar car){
        trainCars.remove(car);
    }
    public void updateTrainsCars(TrainCar newCar, int index){
        if(index >= 0 && index < trainCars.size()){
            trainCars.set(index, newCar);
        }

    }

}
