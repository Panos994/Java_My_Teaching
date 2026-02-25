package trainssystem.intercitytrains;

import trainssystem.Train;
import trainssystem.TrainCar.TrainCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public abstract class IntercityTrain extends Train {
    Random rand = new Random();
    protected final static double maximumIntercitySpeed = 200.0;

    protected final static int stops = 15;
    protected String seatClass;  // κατηγορία κλάσης θέσης A, B.
    // Η κλάση Α διπλασιάζει το κόστος του εισιτηρίου των επιβατών ή φορτίων κλπ ανάλογα με τον τύπο του.
    protected double maxSpeed;
    protected String color;
    protected int km;


    protected IntercityTrain(int trainNumber, String seatClass, double maxSpeed, String color, int km) {
        super(trainNumber);
        this.seatClass = seatClass;

        this.maxSpeed = maxSpeed;
        this.color = color;
        this.km = km;

    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public boolean isIntercity(double max){
        if(max > maximumIntercitySpeed){
            System.out.println("It is an intercity train because its max speed is " + max);
            return true;
        }
        return false;
    }

    public static void isIntercitywithSeatA(IntercityTrain tr){
        if(tr.getSeatClass().equals("A class seat")){
            System.out.println("It is a seat A class in the intercity train because its cost of ticket is double with initial cost of--> \n " + tr.getTicketCostPerMile());
            double costA = tr.getTicketCostPerMile() * 2;
            System.out.println("and the seat A class becomes ---> \n " + costA);
        } else {
            System.out.println("It is not a seat A class but a B class in an intercity train\n");
        }
    }

    public void intercityStops(int currentStops){
        if(currentStops <= stops){
            System.out.println("Count of intercity train stops: " + currentStops);
        } else {
            System.out.println("This is not an intercity train");
        }
    }

    public void rangeOfMaxKilometers(){
       if(km >= 1000 && km < 5000){
           System.out.println("This distance is inside intercity range");
       } else {
           System.out.println("This distance is not inside intercity range");
       }
    }
    public void printIntercityTrain(){
        for(int i = 0; i < 100; i++){
            System.out.print(">>");
        }
        System.out.println();

        String ticketFormatted = String.format("%.2f", ticketCostPerMile);
        String earningsFormatted = String.format("%.2f", earningsSoFar);
        System.out.println("IntercityTrain{" +
                "seatClass='" + seatClass + '\'' +
                "| maxSpeed=" + maxSpeed +
                "| color='" + color + '\'' +
                "| km=" + km +
                "| trainNumber=" + trainNumber +
                "| maxSpeedMilesPerHour=" + maxSpeedMilesPerHour +
                "| currentSpeedMilesPerHour=" + currentSpeedMilesPerHour +
                "| route=" + route +
                "| currentStop=" + currentStop +
                "| ticketCostPerMile=" + ticketFormatted +
                "| earningsSoFar=" + earningsFormatted +
                "} \n");

        if(trainCars!=null && !trainCars.isEmpty()){
            for(TrainCar car : trainCars){
                car.printTrainCar();
            }
        }else{
            System.out.println("Το τρένο αυτό δεν έχει βαγόνι");

        }
        System.out.println("------------------------------------------------------------------- \n");
    }

}
