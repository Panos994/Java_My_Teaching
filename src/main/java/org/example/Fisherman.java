package org.example;

import java.util.*;

public class Fisherman {
    Random rand = new Random();
    private String name;
    private Stack<Fish> basket; //LIFO
    private ArrayDeque<Fish> net; //FIFO

    private double fishingScore;
    private double netingScore;

    private Weather weatherType;

    private List<Fish> junkList;
    public Fisherman( String name) {
        this.name = name;
        this.basket = new Stack<>(); //αρχικοποιω εδω στοιβα και μετα ουρα
        this.net = new ArrayDeque<>();


    }

    public Fisherman() {
    }

    private List<Fish> initJunks(){ //γιατι ζητηθηκε private access modifier  ?
        List<Fish> junks = new ArrayList<>();
        HashMap<String, Double> junksMap = new HashMap<>();
        junksMap.put("Boot", -0.5);
        junksMap.put("Seaweed", -0.1);
        junksMap.put("Bottle", -0.3);
        junksMap.put("Wheel", -0.9);
        junksMap.put("Tin Can", -0.2);
        junksMap.put("Plastic Bag", -0.4);
        List<String> junkNamesList = new ArrayList<>(junksMap.keySet()); //https://www.baeldung.com/java-hashmap-random-key-value-entry -- μετατρεπω τα κλειδια του map σε λιστα
        for(int i = 0; i < 100; i++){
            int randonIndex = rand.nextInt(junkNamesList.size()); //βαζω τα indexes της λιστας τυχαια
            String junkName = junkNamesList.get(randonIndex); //και δημιουργω για καθε αντικειμενο τυχαια το ονομα των σκουπιδιων
            double val = junksMap.get(junkName); //αρνητικη τιμη
            Fish temp = new Fish(junkName,val, 0.0);
            junks.add(temp);
        }

//        for(Fish fishes : junks){
//            System.out.println(fishes.getType());
//        }
        this.junkList = junks; //γεμιζω τη λιστα που δηλωσα στην κλαση
        for(Map.Entry<String, Double> kv : junksMap.entrySet()){
            System.out.println(">>> Σκουπίδι: " + kv.getKey() + " και αρνητική τιμή >>> : " + kv.getValue());
        }
        return junks;
    }
    private Fish getJunk(){
        if(this.junkList == null){ //αν null καλω την init για να γεμισω
            this.junkList = initJunks();
        }
        return this.junkList.get(rand.nextInt(junkList.size())); //επιστροφη τυχαια απο την λιστα indexes για να φερω τυχαια τα σκουπιδια
    }
    public double fishing(Fish f){
        double diff = f.getDifficulty();
        if(weatherType == Weather.Storm){
            diff = Math.min(5.5, diff * 1.5); //εδω μαλλον θελει 1.5? δηλαδη 1 + την αυξηση 0.5 ?
        } else if (weatherType == Weather.Rainy) {
            diff = Math.min(5.5,diff * 1.15); // αντιστοιχα 1.15?
        } else if (weatherType == Weather.Cloudy){
            diff = Math.max(0.5, diff * 0.75); //ενω εδω 1 - 0.25 = 0.75 ?
        }
        double luck = rand.nextDouble(0.5, 5.5);

        if(luck >= diff){
            basket.push(f);
            double points = f.getTotalPoints();
            fishingScore+=points;
            System.out.println("Πιάστηκε το ψάρι: " + f.getType() + " και κέρδισα πόντους: " +  String.format("%.2f",points));
           return points; //επιστρεφω ποντους που κερδισε
        } else if(rand.nextBoolean()){
            Fish junk = getJunk();
            basket.push(junk);
            fishingScore += junk.getWeight(); // Προσθέτει την αρνητική τιμή (π.χ. -0.5)
            System.out.println("!!! Σκουπίδια: " + junk.getType());
            return junk.getWeight();
        }
        return 0.0;
    }

    public void neting(Stack<Fish> waters){
        int tries = (int) (waters.size() * 0.1);
        if(tries > 50){
            tries = 50;
        }
        for(int i = 0; i < tries; i++){
            Fish f = waters.pop();
            double points = fishing(f);
            if(points != 0){
                Fish caught = basket.pop(); //βγαζει απο την κορυψη της στοιβας..?
                net.addLast(caught);
                netingScore += points;
            }
        }
    }

    public void printBasket(){
        for(Fish fishes : basket){
            System.out.println("Το καλάθι έχει τα ακόλουθα ψάρια: " + fishes.getType() + ", " + fishes.getWeight() + ", " + fishes.getDifficulty());
        }
    }

    public void printNet(){
        for(Fish fishes : net){
            System.out.println("Το καλάθι έχει τα ακόλουθα ψάρια: " + fishes.getType() + ", " + fishes.getWeight() + ", " + fishes.getDifficulty());
        }
    }

    public void initReset(){
        basket.clear();
        net.clear();
        fishingScore = 0.0;
        netingScore = 0.0;

    }

    public double getNetingScore() {
        return netingScore;
    }

    public void setNetingScore(double netingScore) {
        this.netingScore = netingScore;
    }

    public double getFishingScore() {
        return fishingScore;
    }

    public void setFishingScore(double fishingScore) {
        this.fishingScore = fishingScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weather getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(Weather weatherType) {
        this.weatherType = weatherType;
    }
}
