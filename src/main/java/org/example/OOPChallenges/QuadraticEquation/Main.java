package org.example.OOPChallenges.QuadraticEquation;

public class Main {
    public static void main(String[] args) {
        int a = 2;
        int b = 10;
        int c = 3;

        if(a==0){
            System.out.println("To α δεν μπορει να ειναι 0 σε δευτεροβαθμια");
            return;
        }
        double d = Math.pow(b,2) - (4*a*c);
        System.out.println("Διακρίνουσα " + d);
        if(d > 0){
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("Nature of roots: Two real and distinct roots.");
            System.out.println("Root 1 (x1) = " + x1);
            System.out.println("Root 2 (x2) = " + x2);
        }
        else if (d == 0) {
            // Μία διπλή πραγματική ρίζα
            double x = -b / (2 * a);
            System.out.println("Nature of roots: One real double root.");
            System.out.println("Root (x) = " + x);
        }
        else {
            // Μιγαδικές (φανταστικές) ρίζες
            System.out.println("Nature of roots: Roots are complex and imaginary.");
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-d) / (2 * a);
            System.out.println("Root 1 = " + realPart + " + " + imaginaryPart + "i");
            System.out.println("Root 2 = " + realPart + " - " + imaginaryPart + "i");
        }
    }

}
