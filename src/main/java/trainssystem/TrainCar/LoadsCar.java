package trainssystem.TrainCar;


public class LoadsCar extends TrainCar{

    private double earningsFromLoadCar = 0.0;
    public LoadsCar(int carNumber, String carType) {
        super(carNumber, carType);
    }

    @Override
    public boolean loadCar(int units) {
        if(currentUnitsOnCar + units <= capacity){
            currentUnitsOnCar+=units;
            earningsFromLoadCar+= units * 5.0; //βαζω καρφωτα μια τιμη
            System.out.println(units + " επιβάτες επιβιβάστηκαν ");
            return true;
        }
        System.out.println("Δεν υπάρχει χώρος για τους επιβάτες/ φορτίο αυτό : " + units);
        return false;
    }
    @Override
    public boolean unloadCar(int units) {
        if(currentUnitsOnCar >= units){
            currentUnitsOnCar-= units;
            earningsFromLoadCar+= units * 5.0; //βαζω καρφωτα μια τιμη
            System.out.println(units + " επιβάτες αποβιβάζονται ");
            return true;
        }
        System.out.println("Δεν υπάρχουν τόσοι επιβάτες στο βαγόνι");
        return false;
    }

    @Override
    public boolean hasCafeteria() {
        if(cafe.equals("Στεργίου")){
            System.out.println("Υπάρχει καφετέρια Στεργίου!");
            return true;
        }
        System.out.println("Το βαγόνι δεν έχει καφετέρα!");
        return false;
    }

    @Override
    public boolean hasEticketCharge() {
        if(hasEticket){
            System.out.println("Σε αυτά τα βαγόνια περιλμβάνεται και eticket για φόρτιση εισητηρίου!");
        }
        System.out.println("Δεν δέχονται αυτά τα βαγόνια eticket!");
        return false;
    }

    @Override
    public boolean hasVendingMachine() {
        return false;
    }


    public double getEarningsFromLoadCar() {
        return earningsFromLoadCar;
    }
}
