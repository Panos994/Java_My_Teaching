package org.example;

import java.util.*;

public class Main {
    public static void createWaters(Stack<Fish> waters){
        //2
        for(int i =0; i < 1000; i++){
            waters.push(Fish.fishWeight()); //generation of random fishes -- με συνθεση να το ξανα δουμε λιγο
        }
        //3
        for(Fish f : waters){
            f.print(); // ------> // *** πως να το εκτυπωσω ***
        }
    }
    public static void fishermanContest(Weather today, Stack<Fish> waters){
        //4
        Fisherman thanasis = new Fisherman("Thanasis");
        thanasis.setWeatherType(today);
        //5
        thanasis.fishing(waters.pop());
        //6
        System.out.println("\n Θανάσης πετονιά score: " + String.format("%.2f", thanasis.getFishingScore()));
        //7
        thanasis.neting(waters);  // γενικα βγαζει σκουπιδια οτι πιάστηκαν και επισης δεν εμφανιζω και τι έπιασε (αν έπιασε ψάρι)
        //8
        System.out.println("\n Θανάσης δίχτυ score: " + String.format("%.2f", thanasis.getNetingScore()));
        //9
        Fisherman giorgis = new Fisherman("Giorgis");
        giorgis.setWeatherType(today);
        Fisherman kostis = new Fisherman("Kostis");
        kostis.setWeatherType(today);
        Fisherman vasilis = new Fisherman("Vasilis");
        vasilis.setWeatherType(today);
        Fisherman nikos = new Fisherman("Nikos");
        nikos.setWeatherType(today);
        Fisherman maria = new Fisherman("Maria");
        maria.setWeatherType(today);
        //10
        Boat galini = new Boat("Galini");
        //11
        galini.addFisherman(thanasis);
        galini.addFisherman(giorgis);
        galini.addFisherman(kostis);
        galini.addFisherman(vasilis);
        galini.addFisherman(nikos);
        galini.addFisherman(maria);
        //12
        galini.startFishingContest(waters, 5);
        //13
        System.out.println("\n Θανάσης πετονιά score " + thanasis.getFishingScore());
        System.out.println("\n Γιώργης πετονιά score " + giorgis.getFishingScore());
        System.out.println("\n kostis πετονιά score " + kostis.getFishingScore());
        System.out.println("\n vasilis πετονιά score " + vasilis.getFishingScore());
        System.out.println("\n nikos πετονιά score " + nikos.getFishingScore());
        System.out.println("\n maria πετονιά score " + maria.getFishingScore()); // γενικα βγαζει σκουπιδια οτι πιάστηκαν και επισης δεν εμφανιζω και τι έπιασε (αν έπιασε ψάρι)
        //14
        galini.getFishingWinner();
        //15
        galini.startNetingContent(waters);
        //16
        System.out.println("\n Θανάσης πετονιά score " + thanasis.getNetingScore());
        System.out.println("\n Γιώργης πετονιά score " + giorgis.getNetingScore());
        System.out.println("\n kostis πετονιά score " + kostis.getNetingScore());
        System.out.println("\n vasilis πετονιά score " + vasilis.getNetingScore());
        System.out.println("\n nikos πετονιά score " + nikos.getNetingScore());
        System.out.println("\n maria πετονιά score " + maria.getNetingScore());
        //17
        galini.getNetingWinner();
        //18 ? ? ?

        //19
        List<Fisherman> fishermanList = new ArrayList<>();
        fishermanList.add(thanasis);
        fishermanList.add(giorgis);
        fishermanList.add(kostis);
        fishermanList.add(vasilis);
        fishermanList.add(nikos);
        fishermanList.add(maria);


        fishermanList.sort(Comparator.comparing(Fisherman::getNetingScore));
        System.out.println(" ΝΙΚΗΤΕΣ ΑΓΩΝΑ ΠΕΤΟΝΙΑΣ ");
        for(Fisherman fs : fishermanList){
            System.out.print(fs.getName() + " : " + String.format("%.2f", fs.getNetingScore()));
        }

        System.out.println("\n ΝΙΚΗΤΕΣ ΑΓΩΝΑ ΔΙΧΤΙΟΥ ");
        fishermanList.sort(Comparator.comparing(Fisherman::getFishingScore));
        for(Fisherman fs : fishermanList){
            System.out.print(fs.getName() + " : " + String.format("%.2f", fs.getNetingScore()));
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        //1
        Weather today = Weather.values()[rand.nextInt(Weather.values().length)]; //https://codingtechroom.com/tutorial/java-java-enum-random-value
        System.out.println("Ο καιρός σήμερα έιναι: " + today + "\n");
//        Weather today;
//        int options = rand.nextInt(4);
//        if(options == 0){
//            today = Weather.Storm;
//        } else if (options == 1){
//            today= Weather.Rainy;
//        } else if (options == 2){
//            today = Weather.Cloudy;
//        } else{
//            today = Weather.Sunny;
//        }
//        System.out.println("Ο καιρός σήμερα έιναι: " + today);
        //2
        System.out.println(" Παρακάτω έχουμε τους τύπους ψαριών");
        Stack<Fish> waters = new Stack<>();
        createWaters(waters);
        fishermanContest(today, waters);
        //επισης και στην main να εχει static Μεθοδους  -- να ειναι Modular
    }
}