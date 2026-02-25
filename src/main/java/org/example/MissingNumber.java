package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MissingNumber {
    //Ex3
    public void findMissing(ArrayList<Integer> list) {
        Collections.sort(list);
        int d = 0;
        int miss = 0;
        int min = list.get(1) - list.get(0);    //αρχικοποιώ με την μικρότερη διαφορά - minDistance αλλιως
        for (int i = 0; i < list.size() - 1; i++) {
            d = list.get(i + 1) - list.get(i); //αριθμητικη πρόοδος τύπος Μαθηματικά - https://www.cuemath.com/algebra/arithmetic-progressions/
            if (min > d) {
                min = d;
            }
        }
        //System.out.println(min);
        d = min;
        //System.out.println(d);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) > d) { ////αριθμητικη πρόοδος τύπος Μαθηματικά   ειναι μεγαλύτερο απο την μικρότερη διαφορά τοτε σημαίνει ότι έσπασε το consecutive nums
                miss = list.get(i) + d;   //αρα παιρνω το list.get(i) που ειναι πχ list.get(i+1) που ειναι το 9 και list.get(i) που ειναι το 5 --> 9-5 = 4  --> list.get(i) =5 + d (=) 5+2 = 7
                break;
            }
        }
        System.out.println(miss);
    }
}
