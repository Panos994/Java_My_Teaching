package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void printArray(int[] arr) {
        for (int i = 0; i < 100; i++) {

            if (i % 25 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print("\t" + arr[i]);
        }
    }

    public static void printArrayZero(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i % 25 == 0 && i != 0) {
                System.out.println();
            }
            if (arr[i] % 9 == 0) {
                System.out.print("\t ZERO");
            } else {
                System.out.print("\t" + arr[i]);
            }
        }
    }


    public static void main(String[] args) {
        //A)
//        int[] arrayA = new int[100];
//        int[] arrayB = new int[100];
//        int[] arrayC = new int[100];
//
//        int i;
//        int j;
//
//        for (i = 2; i < arrayA.length; i++) {
//            if (i % 2 == 0) {
//                System.out.println();
//                arrayA[i] = i;
//
//                if(i <= 50){
//                    arrayC[i] = i;
//
//                }
//                System.out.println("Even numbers of arrayA: " + arrayA[i]);
//                //System.out.println("arrayC: " + arrayC[i]);
//            }
//            System.out.println("arrayC: " + arrayC[i]);
//
//        }
//
//        for (j = 13; j < arrayB.length; j++) {
//            if (j % 2 != 0) {
//                arrayB[j] = j;
//                System.out.println();
//                //System.out.println("Result of arrayB is: " +  arrayB[j]);
//                if(j > 50){
//                    arrayC[j] = j;
//
//                }
//                System.out.println("Odd nums of arrayB: " + arrayB[j]);
//                System.out.println("arrayC: " + arrayC[j]);
//
//
//
//            }
//
//        }


//        }

//            StringBuilder sb = new StringBuilder("p");
//            sb.append("fot");
//            System.out.println(sb);


        int[] a = new int[100];
        int[] b = new int[100];
        int[] c = new int[100];

        System.out.println("Array A: ");
        for (int i = 0, k = 2; i < 100; i++, k += 2) {
            // if (i % 2 == 0) {
            a[i] = k;
            System.out.println(a[i]);
            ///  }
        }
//        for (i = 0; i < 100; i++) {
//            if (a[i] == 0) {
//                continue;
//            }
//            System.out.println(a[i]);
//
//        }

        System.out.println("Array B: ");

        for (int i = 0, k = 13; i < 100; i++, k += 2) {
            // if (i%2!=0) {
            b[i] = k;
            //  }
            System.out.println(b[i]);
        }

//        for (i = 0; i < 100; i++) {
//            if (b[i] == 0) {
//                continue;
//            }
//            System.out.println(b[i]);
//
//        }

        System.out.println("Array C:");

        for (int i = 0; i < 100; i++) {
            if (i < 50) {
                c[i] = a[i + 50];
            } else {
                c[i] = b[i - 50];
            }

            System.out.println(c[i]);
            //c[i] = a[i + 50];  // 0 + 50 = 50, 2 + 50 = 52 (αφου θα πάρει ζυγα), 4 + 50 = 54, 6 + 50 = 56... θα φτάσει στην τελευταία επανάληψη και θα είναι 98
        }


//        for (int i = 0; i < 50; i++) {
//
//            c[i + 50] = b[i]; //παιρνω τα πρωτα 50 στοιχεια του c Και ουσιαστικα αντιγράφω τα στοιχεία του b[i] --> αρα c[0+50] που ειναι το c[50] βάζει το πρώτο στοιχείο του b δηλαδή 13..., μετά c[1 + 50] που ειναι το c[51] βάζω το δεύτερο στοιχείο του b που είναι το 15 άρα c[51] = 15 κοκ...
//
//        }

//        for (int i = 0; i < 100; i++) {
//            if (c[i] == 0) {
//                continue;
//            }
//            System.out.printf("%d ", c[i]);
//

        //                System.out.println();
//                System.out.println();
//            } else if (i > 5 && i < 10){
//                System.out.println("\t" + b[i]);
//                System.out.println();
//                System.out.println();
//            }


        printArray(a);
        System.out.println("\n\n");
        printArray(b);
        System.out.println("\n\n");
        printArray(c);
        System.out.println("\n\n");
        printArrayZero(c);
        //Β)
//        System.out.println();
//        System.out.println("reverse print of c Array:");
//        for (int i = c.length - 1; i >= 0; i--) {
//            if (c[i] == 0) {
//                continue;
//            }
//            if (c[i] % 9 == 0) {
//                System.out.println("ZERO");
//            }
//            System.out.printf("%d ", c[i]);
//        }
//    }

    }
}