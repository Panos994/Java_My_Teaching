package trainssystem.TrainCar;

import java.util.Random;
public abstract class TrainCar {
    Random rand = new Random();
    // ιδιότητες (properties)
    // δίνονται και μπορείτε να εισάγετε και δικές σας
    protected int carNumber; // νούμερο βαγονιού ανάλογα με τη θέση που βρίσκεται στο τρένο
    protected String carType; // τύπος βαγονιού που φανερώνει το φορτίο του (άνθρωποι, αποσκευές, κλπ)
    protected int capacity;  // γενική χωρητικότητα (ανάλογα με τον τύπο του) σε καθίσματα ή θέσεις φορτίων κλπ.
    // κάθε βαγόνι έχει χωρητικότητα έναν τυχαίο αριθμό στο κλειστό διάστημα [25, 165]
    protected int currentUnitsOnCar; // η τρέχουσα κατάσταση της πληρότητας της χωρητικότητας του βαγονιού

    protected String cafe;
    protected String vendingMachine;
    protected boolean hasEticket;

    // Μέθοδοι (methods)
    // υλοποιήστε τους getters & setters, constructors και όσες άλλες μεθόδους χρειαστείτε

    // Κατασκευαστής (constructor)
    protected TrainCar(int carNumber, String carType) {
        this.carNumber = carNumber;
        this.capacity = rand.nextInt(25,165);
        this.carType = carType;
        this.cafe = "No";
        this.vendingMachine = "No";
        this.currentUnitsOnCar = rand.nextInt(0,15);
    }



    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentUnitsOnCar() {
        return currentUnitsOnCar;
    }

    public void setCurrentUnitsOnCar(int currentUnitsOnCar) {
        this.currentUnitsOnCar = currentUnitsOnCar;
    }

    public String getCafe() {
        return cafe;
    }

    public void setCafe(String cafe) {
        this.cafe = cafe;
    }

    public String getVendingMachine() {
        return vendingMachine;
    }

    public void setVendingMachine(String vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public boolean isHasEticket() {
        return hasEticket;
    }

    public void setHasEticket(boolean hasEticket) {
        this.hasEticket = hasEticket;
    }

    abstract public boolean loadCar(int units);
    // φόρτωση - επιβίβαση (ανθρώπων ή άλλου τύπου φορτίο) στο βαγόνι, υπό τον περιορισμό της χωρητικότητας του και του τύπου του

    abstract public boolean unloadCar(int units);
    // εκφόρτωση - αποβίβαση (ανθρώπων ή άλλου τύπου φορτίο) στο βαγόνι, υπό τον περιορισμό της πληρότητας που έχει εκείνη την στιγμή

    abstract public boolean hasCafeteria();
    abstract public boolean hasEticketCharge();

    abstract public boolean hasVendingMachine();

    public void printTrainCar(){
        System.out.println("TrainCar{" +
                "carNumber=" + carNumber +
                ", carType='" + carType + '\'' +
                ", capacity=" + capacity +
                ", currentUnitsOnCar=" + currentUnitsOnCar +
                ", cafe='" + cafe + '\'' +
                ", vendingMachine='" + vendingMachine + '\'' +
                ", hasEticket=" + hasEticket +
                '}');
    }
}
