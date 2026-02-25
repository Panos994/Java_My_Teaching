package org.example;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Exercice5 {
    public static void main(String[] args) {
        //5)
        Scanner sc = new Scanner(System.in);
        int countx = 0;
        int counto = 0;
        boolean valid = false;
        //ηθελα να χρησιμοποιησω στο charAt() και μπήκα εδώ για τη συνταξη https://stackoverflow.com/questions/73606413/defining-charat-variable-to-use-in-a-loop-with-a-boolean-statement-for-letter-ma
        String input = sc.nextLine(); // xXThanasisOo
        for (int i = 0; i < input.length(); i++) {
            if (Character.toLowerCase(input.charAt(i)) == 'x') {
                countx++;
                //System.out.println("x are " + countx);
            } else if (Character.toLowerCase(input.charAt(i)) == 'o') {
                counto++;
                //System.out.println("o are " + counto);
            }
        }
        if (countx == counto) {
            valid = true;
        }
        System.out.println(valid);


        // call exercice 6 method
        timeAtMidnight();

    }

    //exercise 6
    public static void timeAtMidnight() {
        Scanner sc = new Scanner(System.in);
        //LocalDateTime time;   //1sec == 1000ms
        int time = 0; //αφου απο τα μεσανυχτα λογικα εννοειται 00.00.00
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        do {
            System.out.println("Give me hour (0 - 23): + \n");
            hours = sc.nextInt();
        } while (hours < 0 || hours > 23);

        do {
            System.out.println("Give me minutes (0 - 59): ");
            minutes = sc.nextInt();
        } while (minutes < 0 || minutes > 59);

        do{
            System.out.println("Give me seconds (0 - 59): ");
            seconds = sc.nextInt();
        } while(seconds < 0 || seconds >59);


        int secConvertMs = seconds * 1000;
        int minConvertMs = minutes * 60 * 1000;
        int hrConvertMs = hours * 60 * 60 * 1000;

        time = hrConvertMs + minConvertMs + secConvertMs;

        System.out.println("Time is in ms: " + time);
        sc.close();
    }


}
