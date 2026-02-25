package trainssystem.TrainCar;

import java.util.Random;

public class PassengersCar extends TrainCar{
    private int totalServedCount = 0;

    public PassengersCar(int carNumber, String carType) {
        super(carNumber, carType);
    }



    @Override
    public boolean loadCar(int units) {
        if(currentUnitsOnCar + units <= capacity){
            currentUnitsOnCar+=units;
            totalServedCount+=units;
            System.out.println(units + " φορτία επιβιβάστηκαν ");
            return true;
        }
        System.out.println("Δεν υπάρχει χώρος για φορτίο αυτό : " + units);
        return false;
    }
    @Override
    public boolean unloadCar(int units) {
        if(currentUnitsOnCar >= units){
            currentUnitsOnCar-= units;
            totalServedCount+=units;
            System.out.println(units + " φορτία αποβιβάζονται ");
            return true;
        }
        System.out.println("Δεν υπάρχουν τόσα φορτία στο βαγόνι");
        return false;
    }

    @Override
    public boolean hasCafeteria() {
        if(cafe.equals("Στεργίου")){
            System.out.println("Υπάρχει καφετέρια Στεργίου για τους επιβάτες όσο ταξιδεύπουν!");
            return true;
        }
        System.out.println("Το βαγόνι δεν έχει καφετέρα!");
        return false;
    }

    @Override
    public boolean hasEticketCharge() {
        if(hasEticket){
            System.out.println("Σε αυτά τα βαγόνια περιλμαβάνεται και eticket για φόρτιση εισητηρίου για τους επιβάτες!");
        }
        System.out.println("Δεν δέχονται αυτά τα βαγόνια eticket!");
        return false;
    }
    @Override
    public boolean hasVendingMachine() {
        if(vendingMachine.equals("Vending AE")){
            System.out.println("Υπάρχει αυτόματος πωλητής καφέ στο βαγόνι για τους επιβάτες όσο ταξιδεύπουν!");
            return true;
        }
        System.out.println("Το βαγόνι δεν διαθέτει αυτόματο πωλητή !");
        return false;
    }

    public int getTotalServed() {
       return totalServedCount;
    }
}
