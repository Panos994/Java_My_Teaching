package org.example;

import java.time.LocalDate;
import java.util.Scanner;

import static org.example.MaxNum.getMaxNumber;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello, World!");

        //8/9/25 Μάθημα
//        int[] myArr = new int[10];
//        int k = 3;
//
//        int myArray[] = {0,1,2,3,4,5,6,7,8,9};
//
//        myArr[0] = 2;
//        myArr[1] = 4;
//        myArr[2] = myArr[0] * myArr[1];
//        myArr[k] = myArr[0] + myArr[1] + myArr[2];
//        myArr[k + 1] = 0;
//
//
//        for (int i = 0; i < myArr.length; i++){
//            System.out.println(myArr[i]);
//        }


//        for (int i = 0; i < 10; i++){
//            for(int j = 1; j <= 1; j++){
//                for(int k = 1; k <= 10; k++){
//                    System.out.println(k);
//                }
//                break;
//            }
//            break;
//        }

//        int i = 1;
//        while (i<=10){
//            System.out.println(i);
//            i++;
//
//        }


//        int i = 1;
//        do{
//            System.out.println(i);
//            i++;
//        }while(i<=10);

        //-------------------------------------------------------------------

        //D.R.Y (Dont repeat your self)
        //TODO:
        //Entry Level 1 Exercises
        Scanner sc = new Scanner(System.in);
        //Καλωσόρισμα
        System.out.println("Welcome new user");
        int num1;
        int num2;
        int num3;
        do {

            //Εμφανίζει μήνυμα ζητώντας τον 1ο αριθμό.
            System.out.println("Please enter first number: ");
            //Διαβάζει τον αριθμό που εισήγαγε ο χρήστης.
            num1 = sc.nextInt();
            if (num1 == 0) {
                System.out.println("Please enter an integer not equal to 0");
            }
        } while (num1 == 0);


        //Ενημερώνει τον χρήστη ότι ο αριθμός που εισήγαγε είναι:π.χ. "Ο 1ος αριθμός που εισάγατε είναι ο: Χ".
        System.out.println("\nFirst number is: " + num1 + "\n");


        /// /
        do {
            System.out.println("Please enter second number: ");
            num2 = sc.nextInt();
            if (num2 == 0) {
                System.out.println("Please enter an integer not equal to 0");
            }
        } while (num2 == 0);


        System.out.println("\nSecond number is : " + num2 + "\n");

        /// /
        do {
            System.out.println("Please enter third number: ");
            num3 = sc.nextInt();
            if (num3 == 0) {
                System.out.println("Please enter an integer not equal to 0");
            }
        } while (num3 == 0);


        System.out.println("\nThird number is : " + num3 + "\n");


        /// /
        int prod = num1 * num2;
        double quotient = (double) prod / num3; // CASTING - ΕΚΜΑΓΕΙΟ
        System.out.println("The product number of num1 and num2 is: " + prod + " ,the quotient of prod and num3 is: " + quotient);

        /// /
        int mod = prod % num3; // MOD - Υπόλοιπο ΑΚΕΡΑΙΗΣ διαίρεσης
        System.out.println("The modulo of number prod and num3 is: " + mod);
        ///
        System.out.println("All results are the num1: " + num1 + "\n" + " num2 " + num2 + " num3 " + num3 + " prod " + prod + " quotient " + quotient + " modulo " + mod + "\n");

        //sc.close();

        //Entry L. II
        //A)
        System.out.println("Please enter first number: ");
        int x = sc.nextInt();

        System.out.println("Please enter second number: ");
        int y = sc.nextInt();

        System.out.println("Please enter third number: ");
        int z = sc.nextInt();

        if (x >= y && x >= z) {
            System.out.println("Bigger number is: " + x);
        } else if (y >= x && y >= z) {
            System.out.println("Bigger number is: " + y);
        } else {
            System.out.println("Bigger number is: " + z);
        }

        //sc.close();

        //B) https://www.bing.com/search?q=find%20today%20date%20in%20java&qs=n&form=QBRE&sp=-1&ghc=1&lq=0&pq=find%20today%20date%20in%20jav&sc=0-22&sk=&cvid=A3D14385D2504F758B4EE512E1740B42
        LocalDate today = LocalDate.now();

        System.out.println("Please enter your Year of birth: ");
        int year = sc.nextInt();

        System.out.println("Please enter your month of birth: ");
        int month = sc.nextInt();

        System.out.println("Please enter your day of birth: ");
        int day = sc.nextInt();

        int yearsLived = today.getYear() - year;
        int monthsLived = (yearsLived * 12);
        int weeksLived = yearsLived * 52;
        int daysLived = yearsLived * 365;

        String dayOfBirth = String.format(" %d/%d/" + year, day, month);
        System.out.println(" Date of birth: " + dayOfBirth);
        System.out.println("Years lived: (optional printing): " + yearsLived + " | Months lived:" + monthsLived + " | Weeks lived: " + weeksLived + " | Days lived: " + daysLived);

        String fullDaysMonthsWeeksLived = String.format("days: %d | months: %d | weeks: %d ", daysLived, monthsLived, weeksLived);
        System.out.println(" My life statistics: " + fullDaysMonthsWeeksLived);


        //Entry L. IV
        //A
        double money;
        //String type = null;
        double antitimo = 0.0;

        System.out.println(" Please tell me your vehicle type (dkl for dikikla, epiv for epivatika, fort for fortiga): ");
        //String type = sc.next();
        String type = null;
        do {

            type = sc.next();
            switch (type) {
                case "dkl":
                    antitimo = 1.20;
                    System.out.println(" Fees for dkl is: " + antitimo + " €");
                    break;
                case "epiv":
                    antitimo = 2.40;
                    System.out.println(" Fees for epiv is: " + antitimo + " €");
                    break;
                case "fort":
                    antitimo = 3.50;
                    System.out.println(" Fees for fort is: " + antitimo + " €");
                    break;
                default:
                    System.out.println("You told me a wrong type of vehicle. Try again...");
                    break;

            }

        } while (!(type.equals("dkl") || type.equals("epiv") || type.equals("fort")));
        //στην αρχη εβαζα type == "dkl" || type == "epiv" || type == "fort" και ετρεχε μονο 1 επαναληψη και σταματαγε το προγραμμα
        //https://www.bing.com/search?q=String+and+equals%28%29+in+java&form=ANNH01&refig=68c32eef13e341ca840bfde964a9c6f1&pc=DCTS

        //String s = "Thanasis";
        //String s2 = "Thanasis"; // s1 == s2      0xAAFFDA  ==  0x123AAFFA .equals()
        //['T', 'h', 'a', ...]


        System.out.println("Please enter your balance: ");
        money = sc.nextDouble();

        if (money > antitimo) {
            money = money - antitimo;
            System.out.println(" Success. Your remaining balance is: " + money + " \n");
        } else if (money == 0.0) {
            System.out.println(" Your balance is not adequate. You need to be paid:  " + antitimo + " \n");
        } else if (money < antitimo) {
            money = money - antitimo;
            double moneyToBePaid = Math.abs(money);

            // other solution instead of Math.abs: money = (money - antitimo)*(-1);
            System.out.println(" Remaining money need to be paid is: " + moneyToBePaid + " \n");
        }
        //Μath.abs : https://www.bing.com/search?q=how%20to%20make%20a%20negative%20number%20positive%20in%20java%20&qs=n&form=QBRE&sp=-1&ghc=1&lq=0&pq=how%20to%20make%20a%20negative%20number%20positive%20in%20java%20&sc=2-47&sk=&cvid=9E61827994F04120ADAF4CF0265E7A3F


        //TODO:
        //B)

        //int N = sc.nextInt();
        int N = 0;
        int sum = 0;
        int max = 0;
        System.out.println(" Please enter your positive integer: " + " \n");
        do {

            N = sc.nextInt();
            if (N <= 0) {
                System.out.println("Type again please. You need to type a positive number.");

            }
        }while(N<=0);
            if (N > 0 && sum >= 0) {
                while (sum < N) {

                    System.out.println("Please enter positive numbers: " + " \n");
                    int num = sc.nextInt();
                    sum = sum + num;

                    //εδω ειχα αρχικοποιησει το int max = 0 εδω μεσα αλλα λογικα το εβαλα εξω απο την while και δουλεψε
                    //https://stackoverflow.com/questions/19671453/how-do-i-get-the-max-and-min-values-from-a-set-of-numbers-entered
                    if (num > max) {
                        max = num;

                    }
                }
                System.out.println("The sum is: " + sum + " and bigger number typed is: " + max);

            }

        //} while (N <= 0);


        Thread thread1 = new Thread();
        try {
            thread1.sleep(1000);
        } catch (
                Exception ex) {
            System.out.println("Exception thrown:" + ex);

        }
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("\nThank you friend  ^ . ^");
        System.out.println("Bye Bye!");

//



        int result = MaxNum.getMaxNumber();
        System.out.println(result);
        sc.close();




    }



}

