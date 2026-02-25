package trainssystem;

import trainssystem.TrainCar.TrainCar;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TrainStop {

    // ιδιότητες (properties)
    // δίνονται και μπορείτε να εισάγετε και δικές σας
    private static final LocalTime START_TIME = LocalTime.of(8, 0);
    private String location; // όνομα σταθμού που ανήκει στα περιεχόμενα της λίστας locations της κλάσης TrainSchedule
    private LocalTime timeOfArrival; // ώρα σε μορφή Date dd/MM/yyyy HH:mm:ss άφιξης ενός τρένου  - Θεωρήστε ότι:
    // Ώρα Άφιξης = Ώρα Αναχώρησης από προηγούμενο σταθμό + (Απόσταση / Μέση Ταχύτητα).
    // Ώρα Αναχώρησης = Ώρα Άφιξης + 10 λεπτά (χρόνος στάσης).
    private LocalTime timeOfDeparture;  // ώρα σε μορφή Date dd/MM/yyyy HH:mm:ss αναχώρησης ενός τρένου
    // Οι ώρες άφιξης και αναχώρησης που θα βάλετε θα πρέπει να ακολουθούν την κοινή λογική και τις προδιαγραφές της εργασίας
    // σύμφωνα με τις πληροφορίες της εργασίας. Θεωρήστε ότι κάθε τρένο παραμένει σε κάθε στάση 10' λεπτά.

    List<TrainCar> trainCarsList;
    // Μέθοδοι (methods)
    // υλοποιήστε τους getters & setters, constructors και όσες άλλες μεθόδους χρειαστείτε

    public TrainStop(String location, LocalTime arrivalTime) {
        this.location = location;
        this.timeOfArrival = arrivalTime;
        this.timeOfDeparture = arrivalTime.plusMinutes(10);
        this.trainCarsList = new ArrayList<>();
    }
    public TrainStop(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalTime getTimeOfArrival() {
        return timeOfArrival;
    }

    public void setTimeOfArrival(LocalTime timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }

    public LocalTime getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public void setTimeOfDeparture(LocalTime timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    public void load(int units, int trainCarNumber) {
        Random rand = new Random();
        for(TrainCar trainCar : trainCarsList){
            if(trainCarNumber == trainCar.getCarNumber()){
               // int currentUnits = trainCar.getCurrentUnitsOnCar();
                double loadPercentage = rand.nextDouble(0.05, 0.1);
                int finalUnitsToLoad = (int) (units * loadPercentage);
                trainCar.loadCar(finalUnitsToLoad);
            }
        }
        // units μονάδες φόρτωσης (άνθρωποι, εμπορεύματα κλπ ανάλογα με τον τύπο του βαγονιού) σε συγκεκριμένο βαγόνι trainCarNumber ενός τρένου
        // που φορτώνονται στο τρένο που έχει σταθμεύσει σε αυτό το σταθμό.
    }

    public void unload(int units, int trainCarNumber) {
        Random rand = new Random();
        for(TrainCar trainCar : trainCarsList){
            if(trainCarNumber == trainCar.getCarNumber()){
                //int currentUnits = trainCar.getCurrentUnitsOnCar();
                double loadPercentage = rand.nextDouble(0.025, 0.05);
                int finalUnitsToLoad = (int) (units * loadPercentage);
                trainCar.unloadCar(finalUnitsToLoad);
            }
        }
        // units μονάδες φόρτωσης (άνθρωποι, εμπορεύματα κλπ ανάλογα με τον τύπο του βαγονιού) σε συγκεκριμένο βαγόνι trainCarNumber ενός τρένου
        // που εκφορτώνονται στο τρένο που έχει σταθμεύσει σε αυτό το σταθμό.
    }


}
