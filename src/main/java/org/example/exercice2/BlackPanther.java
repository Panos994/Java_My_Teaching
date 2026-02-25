package org.example.exercice2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class BlackPanther implements Comparable<BlackPanther> {
    String name;
    int age;
    String place;
    Double weight;
    String gender;            //  0xAAFF
    boolean isProduced;  // [     [  [Shadow] [ 5  ] [Africa [] [] [] ]                                ]

    //  name     age    place
    //                            ------ bp1 --------------------
    public BlackPanther(String name, int age, String place, Double weight, String gender, boolean isProduced) {
        this.name = name;
        this.age = age;
        this.place = place;
        this.weight = weight;
        this.gender = gender;
        this.isProduced = isProduced;
    }

    public BlackPanther() {
    }

    public void eatAnimal(double weightOfFood) {
        weight += weightOfFood * 0.10;
    }

    public String breed(BlackPanther bp) {
        String res;
        if (!(gender.equals(bp.gender)) && place.equals(bp.place)) {
            isProduced = true;
            bp.isProduced = true;
            res = "Η αναπαραγωγή του " + this.name + " και του " + bp.name + " πραγματοποιήθηκε";
        } else {
            isProduced = false;
            res = "Αδύνατη η αναπαραγωγή του " + this.name + " με τον " + bp.name;
        }
        return res;
    }

    public String searchFood(int years) {
        Random rand = new Random();
        String res = "";
        for (int i = 0; i < years; i++) { //δηλαδη πχ στο test case της ασκησης αφου θελει "ψάχνουν για φαγητό για 1 έτος" θα ειναι 1 επαναληψη (a = 1)
            int outcome = rand.nextInt(100); // 0....|.....|...50........... 99

            if (outcome < 15) { //δηλαδη αν ο ψευδοτυχαίος ερθει κατω απο 15 τοτε εφαγε 20 κιλα φαγητο και δείχνω και την ηλικία του
                eatAnimal(20);
                res += name + " ate food of 20 kg at age of: " + age + " ";    //χρειάζομαι το += επειδή σε κάθε επανάληψη κραταω τι εγινε καθε έτος "έφαγε 20 κιλά" ή "δεν έφαγε"
            } else if (outcome < 40) {  //αθροίζω μεχρι το 100
                eatAnimal(10);
                res += name + " ate food of 10 kg at age of: " + age + " ";
            } else if (outcome < 75) {
                eatAnimal(5);
                res += name + " ate food of 5 kg at age of: " + age + " ";
            } else {
                //eatAnimal(0);
                res += "Still searching for food at age of:" + age + " ";
            }
            age++;
        }
        return res;
    }

    public String getData() {
        String res = " ";
        String resIsProduced = " ";
        if (isProduced == false) {
            resIsProduced = "is not produced";
        } else if (isProduced == true) {
            resIsProduced = " is produced";
        }
        res = "Name is " + name + ", age is " + age + ", weight is " + weight + ", gender " + gender + " and this blackpanther " + resIsProduced;
        return res;
    }

    //https://www.geeksforgeeks.org/java/java-comparator-interface/   --- χρησιμοποιησα μια λιστα και απλα εκανα Collections.sort(myList) και μου εβγαζε error Οτι θελουμε το Interface Comparator
    @Override
    public int compareTo(BlackPanther o) {
        return this.weight.compareTo(o.weight);
    }


}
