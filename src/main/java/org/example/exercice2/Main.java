package org.example.exercice2;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        int age = 4;
        BlackPanther bp = new BlackPanther("Midnight ", age, "Senegal", 55.0, "female", false);
        BlackPanther bp2 = new BlackPanther("Shadow", age, "Senegal", 55.0, "male", false);
        BlackPanther bp3 = new BlackPanther("Ngozi", age, "Vietnam", 55.0, "female", false);
        bp.eatAnimal(7);
        bp2.eatAnimal(5);
        bp3.eatAnimal(13);
        System.out.println();
        System.out.println(bp3.breed(bp));
        System.out.println(bp3.breed(bp2));
        System.out.println(bp2.breed(bp));
        System.out.println(bp2.breed(bp3));
        System.out.println("\n" + "----------------------");
        System.out.println("First Panther --> " + bp.searchFood(1) + "\n");
        System.out.println("Second Panther --> " + bp3.searchFood(1) + "\n");


        System.out.println(bp2.breed(bp));
        System.out.println(bp2.breed(bp3));

        if (bp.isProduced) {
            System.out.println("First Panther is not produced and searching --> " + bp.searchFood(2) + "\n");
        } else if (bp2.isProduced) {
            System.out.println("Second Panther is not produced and searching --> " + bp2.searchFood(2) + "\n");
        } else if (bp3.isProduced) {
            System.out.println("Third Panther is not produced and searching --> " + bp3.searchFood(2) + "\n");
        }

//        BlackPanther heaviest;
//        if(bp.weight > bp2.weight && bp.weight > bp3.weight){
//            heaviest = bp;
//        } else if (bp2.weight > bp3.weight && bp2.weight > bp3.weight){
//            heaviest = bp2;
//        } else {
//            heaviest = bp3;
//        }
//        System.out.println(heaviest.getData());
        // https://www.geeksforgeeks.org/java/java-comparator-interface/
        List<BlackPanther> myList = new ArrayList<>();
        myList.add(bp);
        myList.add(bp2);
        myList.add(bp3);
        Collections.sort(myList);
        for (BlackPanther panthers : myList) {
            System.out.println(panthers.getData());
        }
    }
}
