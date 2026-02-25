package trainssystem;

import trainssystem.TrainCar.TrainCar;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class TrainSchedule {
    // ιδιότητες (properties)
    // δίνονται και μπορείτε να εισάγετε και δικές σας

    private static final LocalTime start = LocalTime.of(8, 0);
    private List<Train> trains;  // λίστα τρένων για το συγκεκριμένο χρονοδιάγραμμα
    private HashMap<String, Integer> trainStopsData; // δεδομένα που αφορούν στάσεις τρένων
    private ArrayList<String> locations; // όλα τα ονόματα περιοχών των σταθμών τρένων

    private ArrayList<Integer> distances;

    public TrainSchedule() {
        this.trains = new ArrayList<>();
        trainStopsData = new HashMap<String, Integer>();
        initTrainStops();
    }

    private void initTrainStops() {
        // τα κλειδιά αντιπροσωπεύουν πραγματικές στάσεις τρένων στις ΗΠΑ και οι τιμές αντιπροσωπεύουν αποστάσεις, κάθε φορά από την προηγούμενη στάση.
        // δηλαδή η Philadelphia απέχει περίπου 95 μίλια από την New York και η Washington απέχει περίπου 140 μίλια από την Philadelphia
        trainStopsData.put("New York, NY", 0);
        trainStopsData.put("Philadelphia, PA", 95);
        trainStopsData.put("Washington, DC", 140);
        trainStopsData.put("Baltimore, MD", 40);
        trainStopsData.put("Richmond, VA", 115);
        trainStopsData.put("Raleigh, NC", 160);
        trainStopsData.put("Charlotte, NC", 170);
        trainStopsData.put("Atlanta, GA", 245);
        trainStopsData.put("New Orleans, LA", 470);
        trainStopsData.put("Memphis, TN", 395);
        trainStopsData.put("St. Louis, MO", 285);
        trainStopsData.put("Chicago, IL", 300);
        trainStopsData.put("Minneapolis, MN", 410);
        trainStopsData.put("Omaha, NE", 345);
        trainStopsData.put("Denver, CO", 535);
        trainStopsData.put("Salt Lake City, UT", 525);
        trainStopsData.put("Reno, NV", 515);
        trainStopsData.put("Sacramento, CA", 125);
        trainStopsData.put("San Francisco, CA", 90);
        trainStopsData.put("Los Angeles, CA", 380);
        trainStopsData.put("San Diego, CA", 125);
        trainStopsData.put("Portland, OR", 975);
        trainStopsData.put("Seattle, WA", 175);
        trainStopsData.put("Vancouver, BC, Canada", 135);
        trainStopsData.put("Edmonton, AB, Canada", 810);
        trainStopsData.put("Saskatoon, SK, Canada", 325);
        trainStopsData.put("Winnipeg, MB, Canada", 365);
        trainStopsData.put("Milwaukee, WI", 90);
        trainStopsData.put("Detroit, MI", 290);
        trainStopsData.put("Cleveland, OH", 165);
        trainStopsData.put("Pittsburgh, PA", 130);
        trainStopsData.put("Buffalo, NY", 115);
        trainStopsData.put("Toronto, ON, Canada", 95);
        trainStopsData.put("Montreal, QC, Canada", 330);
        trainStopsData.put("Boston, MA", 225);
        trainStopsData.put("Providence, RI", 50);
        trainStopsData.put("Hartford, CT", 35);
        trainStopsData.put("New Haven, CT", 30);
        trainStopsData.put("Trenton, NJ", 55);
        trainStopsData.put("Newark, NJ", 10);
        trainStopsData.put("Wilmington, DE", 30);
        trainStopsData.put("Baltimore, MD", 65);
        trainStopsData.put("Harrisburg, PA", 95);
        trainStopsData.put("Cincinnati, OH", 270);
        trainStopsData.put("Louisville, KY", 100);
        trainStopsData.put("Nashville, TN", 180);
        trainStopsData.put("New Orleans, LA", 490);

        locations = new ArrayList<>(trainStopsData.keySet());

        distances = new ArrayList<>(trainStopsData.values());
    }



    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public HashMap<String, Integer> getTrainStopsData() {
        return trainStopsData;
    }

    public void setTrainStopsData(HashMap<String, Integer> trainStopsData) {
        this.trainStopsData = trainStopsData;
    }

    public ArrayList<String> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<String> locations) {
        this.locations = locations;
    }

    // Προσοχή στον υπολογισμό αποστάσεων: Η δομή trainStopsData ορίζει μια σειριακή διαδρομή.
    // Για να βρείτε την απόσταση μεταξύ δύο μη διαδοχικών σταθμών (π.χ. από New York σε Washington),
    // θα πρέπει να αθροίσετε τις αποστάσεις όλων των ενδιάμεσων σταθμών.

    public void addTrain(Train train) {
        trains.add(train);
    }

    public void removeTrain(Train train) {
        trains.remove(train);
    }

    public Train findNextTrain(TrainStop trainStop) {
        LocalTime currentTime = start; //εχω ορίσει μια final static Μεταβλητη για να ξεκινανε στις 08.00 πμ τα δρομολογια
        Train nextTrain = null;
        LocalTime arrival = null;

        for (Train tr : trains) { //προσπελαζω ολα τα τρενα (oλα τα διαθεσιμα τρενα)
            for (TrainStop stop : tr.getRoute()) { //--> εδω λεω και καλα οτι πχ για το Τρενο με train number 1--> προσπελάζω ολες τις στάσεις και παιρνω απο το τρενο την διαδρομη (δηλαδη τις στασεις της διαδρομης του τρενου)
                if (stop.getLocation().equals(trainStop.getLocation())) { //αν η σταση ειναι αυτη που ψαχνω δηλαδη πχ ειμαι Philadelfia και βλεπω οτι το τρενο θα με παει στην σταση Washington που θελω να παω τοτε παω στο επομενο βημα
                    LocalTime arrival1 = stop.getTimeOfArrival(); //τοτε παιρνω την ωρα αφιξης του τρενου στην σταση αυτη
                    if (arrival1.isAfter(currentTime)) { //με το isAfter boolean κοιταζω οτι ειναι αληθες οτι ερχεται μετα την τρεχουσα (εικονικη ωρα) δηλαδη δεν με νοιαζει το τρενο που περασε πριν τις 08.00 αλλα μετα
                        if (arrival == null || arrival1.isBefore(arrival)) { //αμυντικα παω και λεω αν η ωρα αφιξης ειναι null || η αφιξη ειναι νωριτερα απο ας πουμε και ενα αλλο τρενο που με παει στην washington τοτε θα παρω αυτο που με εξυπηρετι καλυτερα
                            arrival = arrival1;
                            nextTrain = tr;
                        }
                    }
                }
            }
            tr.extractPrices(tr);
            // Σημαντικό: Καθώς πρόκειται για προσομοίωση, ορίστε ως "Τρέχουσα ώρα συστήματος" μια εικονική ώρα έναρξης (π.χ. 08:00 π.μ. της τρέχουσας ημέρας)
            // και όχι την ώρα του ρολογιού του υπολογιστή σας. Όλοι οι υπολογισμοί άφιξης/αναχώρησης θα γίνονται με βάση αυτή την εικονική ώρα.
        }
        return nextTrain;
    }

    //    public void moveTrainToNextStation(Train train) {
//        // μετακινεί το τρένο train στην επόμενη στάση του (εκτός αν είναι η τελική του)
//        int currentStop = train.getRoute().indexOf(train.getCurrentStop()); //παιρνω απο τρενο την λιστα της διαδρομης και θελω να δω σε ποιο index βρισκεται το currentStop του τρενου
//        System.out.println("Βρίσκεται τώρα στην στάση πριν την μετακίνηση: " + train.getCurrentStop().getLocation());
//        if (train.getTrainNumber() % 2 != 0) {
//            int nextMovingStops = currentStop + 3;
//            if (nextMovingStops >= train.getRoute().size()) {
//                nextMovingStops = train.getRoute().size() - 1;
//            }
//            TrainStop targetStop = train.getRoute().get(nextMovingStops);
//            train.setCurrentStop(targetStop);
//            System.out.println("Το τρένο τωρα βρισκεται στην στάση: " + train.getCurrentStop().getLocation());
//
//            for (TrainCar car : train.getTrainCars()) {
//
//                int unitsBeforeLoadOrUnload = car.getCurrentUnitsOnCar();
//                targetStop.load(car.getCurrentUnitsOnCar(), car.getCarNumber());
//                System.out.println("Το τρένο μετακινείται 3 στάσεις και φτάνει στην στάση: " + train.getCurrentStop().getLocation());
//                System.out.println("Το τρένο αφού μετακινήθηκε 3 στάσεις και είχε : " + unitsBeforeLoadOrUnload + " φορτία και τώρα φορτώνει " + car.getCurrentUnitsOnCar() + " στο βαγόνι: " + car.getCarNumber());
//                targetStop.unload(car.getCurrentUnitsOnCar(), car.getCarNumber());
//                System.out.println(" Επίσης θα εκφορτώσεις τόσα φορτια/ επιβάτες: " + car.getCurrentUnitsOnCar() + " απο το βαγόνι: " + car.getCarNumber() + " και συνολικα εχει τοσα φορτια: " + car.getCurrentUnitsOnCar());
//            }
//
//        } else if (train.getTrainNumber() % 2 == 0) {
//            int nextMovingStops = currentStop + 2;
//            if (nextMovingStops >= train.getRoute().size()) {
//                nextMovingStops = train.getRoute().size() - 1;
//            }
//            TrainStop targetStop = train.getRoute().get(nextMovingStops);
//            train.setCurrentStop(targetStop);
//
//            for (TrainCar car : train.getTrainCars()) {
//
//                int unitsBeforeLoadOrUnload = car.getCurrentUnitsOnCar();
//                targetStop.load(car.getCurrentUnitsOnCar(), car.getCarNumber());
//                System.out.println("Το τρένο μετακινείται 3 στάσεις και φτάνει στην στάση: " + train.getCurrentStop().getLocation());
//                System.out.println("Το τρένο αφου μετακινήθηκε 3 στάσεις και είχε : " + unitsBeforeLoadOrUnload + " φορτία και τώρα φορτώνει " + car.getCurrentUnitsOnCar() + " στο βαγόνι: " + car.getCarNumber());
//                targetStop.unload(car.getCurrentUnitsOnCar(), car.getCarNumber());
//                System.out.println(" Επίσης θα εκφορτώσεις τόσα φορτια/ επιβάτες: " + car.getCurrentUnitsOnCar() + " απο το βαγόνι: " + car.getCarNumber() + " και συνολικα εχει τοσα φορτια: " + car.getCurrentUnitsOnCar());
//            }
//
//        }
//    }
    public void moveTrainToNextStation(Train train) {
        int currentStopIdx = train.getRoute().indexOf(train.getCurrentStop());
        int jump = (train.getTrainNumber() % 2 != 0) ? 3 : 2;
        int nextIdx = Math.min(currentStopIdx + jump, train.getRoute().size() - 1);

        TrainStop targetStop = train.getRoute().get(nextIdx);
        train.setCurrentStop(targetStop);

        // ΠΟΛΥ ΣΗΜΑΝΤΙΚΟ: Ενημέρωσε τη στάση για τα βαγόνια που "φιλοξενεί"
        targetStop.trainCarsList = train.getTrainCars();

        System.out.println("Το τρένο " + train.getTrainNumber() + " έφτασε στην στάση: " + targetStop.getLocation());

        for (TrainCar car : train.getTrainCars()) {
            // Αντί για car.getCurrentUnitsOnCar(), βάλε έναν τυχαίο αριθμό
            // που αντιπροσωπεύει τον κόσμο/φορτίο που ΠΕΡΙΜΕΝΕΙ στην αποβάθρα.
            int unitsWaitingAtPlatform = new Random().nextInt(50, 150);

            int before = car.getCurrentUnitsOnCar();
            targetStop.load(unitsWaitingAtPlatform, car.getCarNumber());
            int afterLoad = car.getCurrentUnitsOnCar();

            targetStop.unload(afterLoad, car.getCarNumber()); // Ξεφορτώνει ένα ποσοστό από αυτά που έχει μέσα

            System.out.println("Βαγόνι " + car.getCarNumber() + " | Πριν: " + before + " | Τώρα: " + car.getCurrentUnitsOnCar());
        }
    }

    public void moveTrainToFinalStop(Train train) {
        int finalIndex = train.getRoute().size() - 1;
        TrainStop targetLastStop = train.getRoute().get(finalIndex);
        train.setCurrentStop(targetLastStop);
        //System.out.println("Το τρένο " + train.getTrainNumber() + " μετακινείται στην ΤΕΛΙΚΗ στάση: " + targetLastStop.getLocation());

        for (TrainCar car : train.getTrainCars()) {
            int unitsBeforeUnload = car.getCurrentUnitsOnCar();
            targetLastStop.unload(unitsBeforeUnload, car.getCarNumber());
            car.setCurrentUnitsOnCar(0); //για να αδειασουν
            // System.out.println("Το βαγόνι " + car.getCarNumber() + " πλέον αδειασε με  " + car.getCurrentUnitsOnCar() + " φορτια");
        }

    }

    public void printTrainsSchedule() {
        System.out.println("Λίστα τρένων για το συγκεκριμένο χρονοδιάγραμμα: \n");
        for (Train tr : trains) {
            System.out.println("Train number is: " + tr.trainNumber + " |and max speed miles/hr: " + tr.maxSpeedMilesPerHour + " | and ticket cost/mile: " + tr.ticketCostPerMile + " | and earnings: " + tr.earningsSoFar);
        }
    }

}



