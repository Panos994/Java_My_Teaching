package org.example;

import java.util.*;

public class Fish {

    Random rand = new Random();
    private String type;
    private double weight;
    private double difficulty;

    private List<Fish> junkList;
    public Fish() {
    }

    public Fish(String type, double weight, double difficulty) {
        this.type = type;
        this.weight = weight;
        this.difficulty = difficulty;
    }

    public double getTotalPoints(){
        if(weight < 0 || difficulty < 0){
            return -1;
        }
        return weight * difficulty;
    }

    public void print(){
        System.out.printf("|  %-15s | Βάρος: %.2f kg | Δυσκολία: %.2f | Πόντοι: %.2f | \n",type,weight,difficulty,getTotalPoints());
    }


    public static Fish fishWeight(){
        HashMap<String, Double> fishTypeWeightMap = new HashMap<>();
        fishTypeWeightMap.put("Μαρίδα",     0.10 + Math.random() * 0.15);   // 0.10 – 0.25
        fishTypeWeightMap.put("Γαύρος",     0.15 + Math.random() * 0.15);   // 0.15 – 0.30
        fishTypeWeightMap.put("Σαρδέλα",    0.20 + Math.random() * 0.15);   // 0.20 – 0.35
        fishTypeWeightMap.put("Σαφρίδι",    0.20 + Math.random() * 0.20);   // 0.20 – 0.40
        fishTypeWeightMap.put("Κουτσομούρα",0.30 + Math.random() * 0.30);   // 0.30 – 0.60
        fishTypeWeightMap.put("Μπαρμπούνι", 0.35 + Math.random() * 0.35);   // 0.35 – 0.70
        fishTypeWeightMap.put("Σκουμπρί",   0.40 + Math.random() * 0.50);   // 0.40 – 0.90
        fishTypeWeightMap.put("Πέρκα",      0.60 + Math.random() * 0.60);   // 0.60 – 1.20
        fishTypeWeightMap.put("Τσιπούρα",   0.80 + Math.random() * 1.20);   // 0.80 – 2.00
        fishTypeWeightMap.put("Λαβράκι",    1.00 + Math.random() * 1.50);   // 1.00 – 2.50
        fishTypeWeightMap.put("Βακαλάος",   2.00 + Math.random() * 3.00);   // 2.00 – 5.00
        fishTypeWeightMap.put("Συναγρίδα",  1.50 + Math.random() * 2.50);   // 1.50 – 4.00
        fishTypeWeightMap.put("Στήρα",      2.50 + Math.random() * 3.50);   // 2.50 – 6.00
        fishTypeWeightMap.put("Ροφός",      4.00 + Math.random() * 8.00);   // 4.00 – 12.00
        fishTypeWeightMap.put("Σφυρίδα",    3.00 + Math.random() * 5.00);   // 3.00 – 8.00
        fishTypeWeightMap.put("Μαγιάτικο",  5.00 + Math.random() * 10.00);  // 5.00 – 15.00
        fishTypeWeightMap.put("Τόνος",      10.00 + Math.random() * 20.00); // 10.00 – 30.00
        fishTypeWeightMap.put("Ξιφίας",     15.00 + Math.random() * 25.00); // 15.00 – 40.00
        fishTypeWeightMap.put("Σαλάχι",     8.00 + Math.random() * 17.00);  // 8.00 – 25.00
        fishTypeWeightMap.put("Καρχαρίας",  20.00 + Math.random() * 30.00); // 20.00 – 50.00

        List<String> keys = new ArrayList<>(fishTypeWeightMap.keySet());
        String randomFishType = keys.get(new Random().nextInt(keys.size()));
        double randomWeight = fishTypeWeightMap.get(randomFishType);

        double diff = (randomWeight / 50.0) * 5.0 + 0.5;

        return new Fish(randomFishType, randomWeight, diff);
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }
}
