package trainssystem;

import trainssystem.TrainCar.LoadsCar;
import trainssystem.TrainCar.PassengersCar;
import trainssystem.TrainCar.TrainCar;
import trainssystem.intercitytrains.EuroCity;
import trainssystem.intercitytrains.IntercityTrain;
import trainssystem.regionaltrains.LocalTrains;
import trainssystem.regionaltrains.RegionalTrain;

import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.*;

public class TrainApplication {
    public static void initIntercityTrains(List<Train> trains) {
        Random rand = new Random();
        int start = trains.size();
        for (int i = 0; i < 5; i++) {
            double maxSpeed = rand.nextDouble(170.0, 320.0);
            double deviation = rand.nextDouble(0.02, 0.05);
            maxSpeed += maxSpeed * deviation; //
            int kms = rand.nextInt(500, 2000);
            String randomSeat = (rand.nextBoolean()) ? "Seat A" : "Seat B";
            Train intercity = new EuroCity(i, randomSeat, maxSpeed, "Blue and Gray Color", kms);
            int totalCars = rand.nextInt(10, 30);
            int restaurantIdx = rand.nextInt(3); // για αν θα ειναι στο βαγονι 1 ή 2 ή 3 το εστιατόριο
            for (int j = 0; j < totalCars; j++) {
                if (j == restaurantIdx) {
                    intercity.addTrainsCars(new PassengersCar(j, "Restaurant"));
                } else {
                    if (rand.nextDouble() < 0.4) {
                        intercity.addTrainsCars(new PassengersCar(j, " Bαγόνι επιβατών"));
                    } else {
                        intercity.addTrainsCars(new LoadsCar(j, "Ουδέτερο βαγόνι"));
                    }
                }
            }
            trains.add(intercity);
        }

        for (int i = start; i < trains.size(); i++) {
            if (trains.get(i) instanceof IntercityTrain intercity) {
                https:
//www.geeksforgeeks.org/java/instanceof-keyword-in-java/  -- το είδα εδώ αλλα θελω να συζητησουμε λιγο παραπανω
                intercity.printIntercityTrain();

            }
        }
    }
    public static void initRegionalTrains(List<Train> trains) {
        Random rand = new Random();
        int start = trains.size();
        for (int i = 5; i < 10; i++) {
            double maxSpeed = rand.nextDouble(100.0, 140.0);
            double deviation = rand.nextDouble(0.05, 0.1);
            maxSpeed += maxSpeed * deviation; // custom Λογικη δικιά μου (δεν ημουν σιγουρος)
            int kms = rand.nextInt(50, 100);
            Train intercity = new LocalTrains(i, true, maxSpeed, "White and Gray Color", kms);
            int totalCars = rand.nextInt(5, 20);
            int restaurantIdx = rand.nextInt(3); // για αν θα ειναι στο βαγονι 1 ή 2 ή 3 το εστιατόριο
            for (int j = 0; j < totalCars; j++) {
                if (j == restaurantIdx) {
                    intercity.addTrainsCars(new PassengersCar(j, " Restaurant"));
                } else {
                    if (rand.nextDouble() < 0.6) {
                        intercity.addTrainsCars(new PassengersCar(j, " Bαγόνι επιβατών"));
                    } else {
                        intercity.addTrainsCars(new LoadsCar(j, " Ουδέτερο βαγόνι"));
                    }
                }
            }
            trains.add(intercity);
        }

        for (int i = start; i < trains.size(); i++) {
            if (trains.get(i) instanceof RegionalTrain regionalTrain) {
                https:
//www.geeksforgeeks.org/java/instanceof-keyword-in-java/  -- το είδα εδώ αλλα θελω να συζητησουμε λιγο παραπανω
                regionalTrain.printRegionalTrain();
            }
        }

    }
    public static void generateRoutesWithCommonStops(List<Train> trains, TrainSchedule trainSchedule) {
        Random rand = new Random();
        String locationName = "";
        int i = 0;
        ArrayList<String> allLocations = trainSchedule.getLocations(); //παιρνω και τα βαζω σε μια λιστα τα locations
        //int end = rand.nextInt(4, allLocations.size());

        for (i = 0; i < trains.size(); i++) {
            List<TrainStop> route = new ArrayList<>();
            LocalTime runningTime = LocalTime.of(8, 0);
            route.add(new TrainStop("New York, NY", runningTime));
            int end = rand.nextInt(4, allLocations.size());
            int currentIdx = 0;
            for (int j = 0; j <= end; j++) {
                if (trains.get(i) instanceof EuroCity) {
                    int jumps = rand.nextInt(2, 3);
                    currentIdx += rand.nextInt(4) + jumps; //Πηδαει στασεις πχ το τυχαιο bound που εβαλα + 3 στασεις
                } else {
                    currentIdx += rand.nextInt(2) + 1; //ειδαλλως εδω πηδαει 1 ή 2 σταθμους
                }
                //αμυντικα επειδη μου εσκαγε ελεγχος για να μην εκτος οριων απτη λιστα java.lang.IndexOutOfBoundsException
                if (currentIdx >= allLocations.size()) {
                    currentIdx = allLocations.size() - 1;
                    locationName = allLocations.get(currentIdx);

                    if(!route.get(route.size()-1).getLocation().equals(locationName)){
                        runningTime = runningTime.plusMinutes(10);
                        route.add(new TrainStop(locationName,runningTime));

                    }
                    break;
                }
//                int jIndex = currentIdx;
//                for (int k = j + 1; k <= end; k++) { //j = Vancouver ===> next stop -- end stop
//                    if (allLocations.get(jIndex).equals(allLocations.get(k))) {
//                        continue;
//                    }
//                    locationName = allLocations.get(jIndex);
//                }
//                // String locationName = allLocations.get(jIndex);
//                runningTime = runningTime.plusMinutes(10);
//                TrainStop stop = new TrainStop(locationName, runningTime);
//                route.add(stop);
//                //
//                if (currentIdx == allLocations.size() - 1) { //an ftaso sto orio tis listas break
//
//                    break;
//                }
                locationName = allLocations.get(currentIdx);
                runningTime = runningTime.plusMinutes(10);
                route.add(new TrainStop(locationName,runningTime));
            }


            trains.get(i).setRoute(route);
            trains.get(i).setCurrentStop(route.get(0));

        }


    }
    public static void printMinDistanceTrain(List<Train> trains, TrainSchedule schedule) {
        int min = Integer.MAX_VALUE; //Κατι που δεν θα φτάσει ποτέ
        List<Train> nextTrain = new ArrayList<>();
        for (Train tr : trains) {
            int currentIndexInRoutesSize = tr.getRoute().indexOf(tr.getCurrentStop());

            TrainStop nextStop = tr.getRoute().get(currentIndexInRoutesSize + 1); //δηλαδη + 1 για να παρω την επομενη σταση
            Integer distanceNext = schedule.getTrainStopsData().get(nextStop.getLocation()); //απο το Map παιρνω το distance

            if (distanceNext < min) {
                min = distanceNext;
                nextTrain.add(tr);
            } else if (distanceNext == min) {
                nextTrain.add(tr); //περιπτωση ισοψηφιας
            }

        }
        for (Train minDistanceTrain : nextTrain) {
            schedule.removeTrain(minDistanceTrain); //απο το χρονοδιαγραμμα --> που εχω την removeTrain(Train tr){...}
            System.out.println(" Το τρένο με κωδικο " + minDistanceTrain.getTrainNumber() + " ειναι ετοιμο για αναχώρηση και είναι τυπος " + minDistanceTrain.getClass().getSimpleName()
                    + " με τωρινη σταση " + minDistanceTrain.getCurrentStop().getLocation() + " και επομενη κοντινότερη σταση εχει απόσταση --> " + min + " μιλια");
        }
    }
    public static void printMaxDistanceTrain(List<Train> trains, TrainSchedule schedule) {
        int max = Integer.MIN_VALUE; //Κατι που δεν θα φτάσει ποτέ
        double minTicketCostPerMile = Integer.MAX_VALUE;
        List<Train> nextTrain = new ArrayList<>();
        for (Train tr : trains) {
            int currentIndexInRoutesSize = tr.getRoute().indexOf(tr.getCurrentStop());

            TrainStop nextStop = tr.getRoute().get(currentIndexInRoutesSize + 1); //δηλαδη + 1 για να παρω την επομενη σταση
            Integer distanceNext = schedule.getTrainStopsData().get(nextStop.getLocation()); //απο το Map παιρνω το distance

            if (distanceNext > max && tr.getTicketCostPerMile() < minTicketCostPerMile) {
                minTicketCostPerMile = tr.getTicketCostPerMile();
                max = distanceNext;
                nextTrain.add(tr);
            } else if (distanceNext == max && tr.getTicketCostPerMile() < minTicketCostPerMile) {
                nextTrain.add(tr); //περιπτωση ισοψηφιας
            }

        }
        for (Train maxDistanceTrain : nextTrain) {
            schedule.removeTrain(maxDistanceTrain); //απο το χρονοδιαγραμμα --> που εχω την removeTrain(Train tr){...}
            System.out.println(" Το τρένο με κωδικο " + maxDistanceTrain.getTrainNumber() + " ειναι ετοιμο για αναχώρηση και είναι τυπος " + maxDistanceTrain.getClass().getSimpleName()
                    + " με τωρινη σταση " + maxDistanceTrain.getCurrentStop().getLocation() + " και επομενη μακρινότερη σταση εχει απόσταση --> " + max + " μιλια" + " και κόστος εισητηρίου " + String.format("%.2f", minTicketCostPerMile));
        }
    }
    public static void main(String[] args) {
        Random rand = new Random();
        final String cafeteria = "Στεργίου"; // θα τα βγαλω δεν τα χρειαζομαι εν τελει
        final String vendingMachine = "Vending AE"; // θα τα βγαλω δεν τα χρειαζομαι εν τελει
        List<Train> trains = new ArrayList<>();
        System.out.print("\t \t \t |Intercity Trains Χαρακτηριστικά| \t \t \t \n \n");
        initIntercityTrains(trains); // Αυτή η μέθοδος θα προσθέτει 5 τρένα και θα εκτυπώνει ΜΟΝΟ αυτά
        System.out.print("\t \t \t |Regional Trains Χαρακτηριστικά| \t \t \t \n \n");
        initRegionalTrains(trains);
        TrainSchedule schedule = new TrainSchedule();
        generateRoutesWithCommonStops(trains, schedule);
        for (Train tr : trains) {
            List<String> names = new ArrayList<>();
            for (TrainStop stop : tr.getRoute()) {
                names.add(stop.getLocation());
            }
            System.out.println("Τrain Type:" + tr.getClass().getSimpleName() + " | Train: " + tr.getTrainNumber() + " | route size is: " + tr.getRoute().size() + " | Station names: " + names);
            System.out.println();
        }

        for (Train tr : trains) {
            schedule.addTrain(tr);
        }
        schedule.printTrainsSchedule();
        System.out.println();
        for (Train tr : trains) {
            System.out.println("Ο κωδικός τρένου: " + tr.trainNumber + "  έχει ώρα άφιξης/ αναχώρησης και κόστος εισητηρίου: \n");
            int distancev2 = 0;
            for (TrainStop stop : tr.getRoute()) {
                Train next = schedule.findNextTrain(stop);
                distancev2 = schedule.getTrainStopsData().get(stop.getLocation());

                double totalCostPerMile = distancev2 * tr.ticketCostPerMile;
                System.out.println("Σταθμός:" + stop.getLocation() + "Ωρα άφιξης: " + stop.getTimeOfArrival() + " | ώρα αναχώρησης: " + stop.getTimeOfDeparture() + " | κόστος εισητηρίου: " + String.format("%.2f",tr.getTicketCostPerMile()));
                //System.out.println("Κόστος εισητηρίου  αυτής διαδρομής είναι: " + ticketCost + " ευρώ");
            }
        }
        for (Train tr : trains) {
            System.out.println("\n Μετακίνηση Τρένων Ξεκινάει" + "\n");
            System.out.println("Τρένο με κωδικό: " + tr.getTrainNumber());
            schedule.moveTrainToNextStation(tr);
        }
        for (Train tr : trains) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Εσοδα του τρένου με κωδικό: " + tr.getTrainNumber() + " | είναι --> " + tr.getEarningsSoFar() + " ευρώ \n");
        }
        //HashMap<String, Integer> map = schedule.getTrainStopsData();
        System.out.println("--------------- Παρακάτω είναι τα χαρακτηριστικά του τρένου που θα ξεκινήσει για την κοντινότερη επόμενη στάση -------------");
        printMinDistanceTrain(trains, schedule);
        System.out.println("--------------- Παρακάτω είναι τα χαρακτηριστικά του τρένου που θα ξεκινήσει για την μακρινότερη επόμενη στάση -------------");
        printMaxDistanceTrain(trains, schedule);

        System.out.println("-------------------------- REGIONAL WIFI TRAINS ABOVE --------------------------------");
        List<Train> regionalTrWithWifi = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (Train tr : trains) {
            if (tr instanceof RegionalTrain regionalTrain) {
                if (regionalTrain.isHasWifi()) {
                    if (regionalTrain.getRoute().size() < min) {
                        min = regionalTrain.getRoute().size();
                        regionalTrWithWifi.clear(); //για να σβησω τα προηγουμενα μεγαλυτερα
                        regionalTrWithWifi.add(regionalTrain);
                    }
                }
            }
        }
        for (Train trRegWifi : regionalTrWithWifi) {
            System.out.println("Tρενo/α regional τύπου με wifi είναι το/τα με κωδικο: " + trRegWifi.getTrainNumber() + " με λιγότερες στάσεις --> count στάσεων είναι: " + min);
        }
        System.out.println();
        System.out.println("-------------------------- INTERCITY SEAT A CLASS TRAINS ABOVE --------------------------------");
        List<Train> intercityWithSeatA = new ArrayList<>();
        double max = Integer.MIN_VALUE;
        for (Train tr : trains) {
            if (tr instanceof IntercityTrain intr) {
                if (intr.getSeatClass().equals("Seat A")) {
                    //double costPerMileIntr = intr.getTicketCostPerMile() * 2.0;
                    //IntercityTrain.isIntercitywithSeatA(intr);
                    int currentIndex = intr.getRoute().indexOf(intr.getCurrentStop()); //τωρινη στάση
                    if (currentIndex < intr.getRoute().size() - 1) { //δηλαδη τωρα εβαλα αν υπαρχει επομενη σταση (συγκρινω με το τελος της λιστας)
                        String locationNextStop = intr.getRoute().get(currentIndex + 1).getLocation();//ονομα επομενης στασης
                        int miles = schedule.getTrainStopsData().get(locationNextStop); //μιλια επομενης στασης

                        double totalCostForNextStop = (intr.ticketCostPerMile * 2) * miles;
                        if (totalCostForNextStop > max) {
                            max = totalCostForNextStop;
                            intercityWithSeatA.clear();
                            intercityWithSeatA.add(intr);
                        }
                    }
                }
            }
        }
        for (Train trInSeatA : intercityWithSeatA) {
            System.out.println("\nΤρενα Intercity με Seat A o κωδικος τους ειναι: " + trInSeatA.getTrainNumber() + " και ακριβοτερο κοστος εισητηριου για την επομενη σταση ειναι: " + String.format("%.2f", max));
        }
        System.out.println("\n" + " -------------------------------------------ΜΕΤΑΚΙΝΗΣΗ ΤΡΕΝΩΝ ΣΤΗΝ ΤΕΛΙΚΗ ΤΟΥΣ ΣΤΑΣΗ-----------------------------------------------------------------");
        for (Train tr : trains) {
            schedule.moveTrainToFinalStop(tr);
            int totalPassengers = 0;
            double totalEarnings = 0;

            for (TrainCar car : tr.getTrainCars()) {
                if (car instanceof PassengersCar pcar) {
                    totalPassengers += pcar.getTotalServed();
                } else if (car instanceof LoadsCar lcar) {
                    totalEarnings += lcar.getEarningsFromLoadCar();
                }
            }
            System.out.println("----- το τρένο με κωδικό " + tr.getTrainNumber() + " ---- \n");
            System.out.println("συνολικά έσοδα της διαδρομής " + String.format("%.2f", tr.getEarningsSoFar()));
            System.out.println("Εχει τώρα μετα την εκφορτωση συνολικούς επιβάτες " + totalPassengers);
            System.out.println("Έχει έσοδα απο φορτια (μη επιβάτες) : " + totalEarnings);
        }
        System.out.println();
        System.out.printf("| %-20s | %-15s | %-20s | %-15s | %-15s |\n", "προτελευταία στάση", "ώρα άξιξης", "τελική στάση", "ώρα άξιξης", "κόστος εισητηρίου");
        for (Train tr : trains) { //https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Java-print-table-format-printf-chart-console-scanner-println-line
            List<TrainStop> routes = tr.getRoute();
            int semiFinalIndex = tr.getRoute().size() - 2;
            TrainStop targetSemiFinalStop = tr.getRoute().get(semiFinalIndex);
            tr.setCurrentStop(targetSemiFinalStop);
            int lastStopIndex = tr.getRoute().size() - 1;
            TrainStop targetFinalStop = tr.getRoute().get(lastStopIndex);
            tr.setCurrentStop(targetFinalStop);
            double costTicket = tr.getTicketCostPerMile();
            int distance = 0;
            for (TrainStop tstops : routes) {
                distance = schedule.getTrainStopsData().get(tstops.getLocation());
            }
            double totalCostOfTickerPerRoute = costTicket * distance;
            System.out.printf("| %-20s | %-15s | %-20s | %-15s | %-10.2f |\n", targetSemiFinalStop.getLocation(), targetFinalStop.getTimeOfDeparture(), targetFinalStop.getLocation(), targetFinalStop.getTimeOfArrival(), totalCostOfTickerPerRoute);
        }
    }
}
