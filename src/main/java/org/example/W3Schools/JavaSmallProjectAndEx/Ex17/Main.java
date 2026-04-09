package org.example.W3Schools.JavaSmallProjectAndEx.Ex17;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please indicate year!");
        int y = sc.nextInt();
        System.out.println(isLeapYear(y));
        System.out.println();
        System.out.println(isLeapY(y));
    }
    private static boolean isLeapYear(int year){
        if(year%400==0) {
            return true;
        }
         if(year%100==0){
            return false;
        }
        else{
            return year%4 == 0;
         }
    }

    //With LinkedHashMap --> that maintains the insertion order (on contrary of HashMap that does fast lookups but unordered)
    private static boolean isLeapY(int year){
        LinkedHashMap<Integer, Boolean> map = new LinkedHashMap<>();
        map.put(400, true);
        map.put(100, false);
        map.put(4, true);
        for (Map.Entry<Integer, Boolean> rule : map.entrySet()) {
            if (year % rule.getKey() == 0) {
                return rule.getValue();
            }
        }
        return false;
    }
}
