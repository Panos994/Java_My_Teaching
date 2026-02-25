package trainssystem.regionaltrains;

import trainssystem.Train;
import trainssystem.TrainCar.TrainCar;

public abstract class RegionalTrain extends Train {

    protected final static double maximumIntercitySpeed = 100.0;

    protected final static int stops = 40;

    protected boolean hasWifi; // αν διαθέτει WiFi σύνδεση
    // αν το τρένο διαθέτει wifi τότε επιβαρύνει το κόστος του εισητηρίου με 1.5 δολλάρια / ευρώ επιπλέον
    // για τα βαγόνια που εξυπηρετούν επιβάτες (όχι φορτία ή άλλου τύπου φορτίο).

    protected double maxSpeed;
    protected String color;
    protected int km;

    protected RegionalTrain(int trainNumber, boolean hasWifi, double maxSpeed, String color, int km) {
        super(trainNumber);
        this.hasWifi = hasWifi;
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.km = km;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }


    public boolean isIntercity(double max){
        if(max > maximumIntercitySpeed){
            System.out.println("It is an regional train because its max speed is " + max);
            return true;
        }
        return false;
    }

    public void intercityStops(int currentStops){
        if(currentStops <= stops){
            System.out.println("Count of regional train stops: " + currentStops);
        } else {
            System.out.println("This is not an regional train");
        }
    }

    public void rangeOfMaxKilometers(){
        if(km >= 20 && km < 80){
            System.out.println("This distance is inside regional range");
        } else {
            System.out.println("This distance is not inside regional range");
        }
    }

    public void printRegionalTrain(){
        System.out.println( "RegionalTrain{" +
                "hasWifi=" + hasWifi +
                ", maxSpeed=" + maxSpeed +
                ", color='" + color + '\'' +
                ", km=" + km +
                ", trainNumber=" + trainNumber +
                ", maxSpeedMilesPerHour=" + maxSpeedMilesPerHour +
                ", currentSpeedMilesPerHour=" + currentSpeedMilesPerHour +
                ", route=" + route +
                ", currentStop=" + currentStop +
                ", ticketCostPerMile=" + String.format("%.2f",ticketCostPerMile) +
                ", earningsSoFar=" + String.format("%.2f",earningsSoFar) +
                "} " + super.toString());

        if(trainCars!= null & !trainCars.isEmpty()){
            for(TrainCar trainCar : trainCars){
                trainCar.printTrainCar();
            }
        }else{
        System.out.println("Το τρένο αυτό δεν έχει βαγόνι");

    }
        System.out.println("------------------------------------------------------------------- \n");
    }
}
