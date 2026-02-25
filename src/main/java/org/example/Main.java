package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //Lesson 15/9/2025
        Scanner sc = new Scanner(System.in);
        boolean A = true;
        boolean B = false;
        boolean C = true;
//
//        boolean g1 = (A&&B);
//        boolean g2 = (B||C);
//        boolean g3 = (B&&C);
//        boolean g4 = (g2 && C);
//        boolean res = (g1 || g4);

        boolean z1 = !(A && B && C); //TRUE
        boolean g1 = (A);  //FALSE
        boolean g2 = (B); //TRUE
        boolean g3 = (C); // FALSE

        boolean gz1 = !(g1 && g2 && g3); //TRUE
        boolean gz2 = !(g1 || g2 || g3); //FALSE
        boolean gz3 = !(g1 || g2 || g3); //FALSE

        boolean z2 = !(gz1 || gz2); //FALSE     (we need XNOR logic)
        boolean z3 = gz3; //FALSE

        System.out.println("z1 z2 z3 results: " + z1 + " " + z2 + " " + z3);
        //###################################################################
        // RECAP: static and non-static
        //static μεθοδος και την καλω απλα με το ονομα της κλασης και μεθοδο (class.Method()) ενω η non static πρεπει να φτιαξω αντικειμενο
        User user1 = new User("alice@example.com");
        System.out.println("Is valid email? " + user1.isEmailValid());
        System.out.println("Is valid email? " + User.isEmailAddress("test@ddf.com"));

        //#### RECAP RegEx:
        //e.g. 1
        System.out.println(Pattern.matches("geeks.*", "geeksforgeeks"));
        //e.g. 2
        Pattern p = Pattern.compile("geeks");
        Matcher m = p.matcher("geeksforgeeks.org");
        while (m.find()) {
            System.out.println("Pattern found from " + m.start() + " to " + (m.end() - 1));
        }

        //e.g. 3
        System.out.println(Pattern.matches("[a-z]",
                "g"));
        System.out.println(Pattern.matches("[a-zA-Z]",
                "Gfg"));
        //e.g. 4
        System.out.println(Pattern.matches("[b-z]?",
                "a"));
        System.out.println(Pattern.matches("[a-zA-Z]+",
                "GfgTestCase"));
        System.out.println(Pattern.matches("[^a-z]?",
                "g"));
        System.out.println(Pattern.matches("[geks]*",
                "geeksgeeks"));

        //e.g. 5
        System.out.println(Pattern.matches("\\d+", "1234"));

        // Check if all elements are non-numbers
        System.out.println(Pattern.matches("\\D+", "1234"));

        // Check if all the elements are non-numbers
        System.out.println(Pattern.matches("\\D+", "Gfg"));

        // Check if all the elements are non-spaces
        System.out.println(Pattern.matches("\\S+", "gfg"));

        //e.g. 6 split() method example (split a String in an array of substrings with the use of a delimiter.
        String data = "panos-3031_infot";

        String[] passArray = data.split("-_");
        for (String pass : passArray) {
            System.out.println(pass);
        }
        //###################################################################

        //Entry L. 3
        //Α1) παρόμοιο με το πάνω που κάναμε (παράδειγμα πιο πάνω που είχαμε κάνει στο μάθημα)
        boolean x = true; //αντι για Α
        boolean y = true; //αντι για Β
        boolean z = false; //αντι για C

        boolean andGate = x && y;
        boolean notZ = !z;
        boolean orGate = andGate || notZ;
        boolean Y = !orGate;
        System.out.println("Res of circuit: " + Y);

        //A2)
        boolean A2 = false;
        boolean B2 = false;
        boolean C2 = false;

        boolean y2 = (!(!(A2)) || (!(A2))) || ((B2 && ((!(B2 && C2)))) || (!(!(B2 && C2))));
        System.out.println("Res of circuit: " + y2);


//
        //First solution with 2d arrays
        boolean[][] values = {
                {false, false, false},
                {false, false, true},
                {false, true, false},
                {false, true, true},
                {true, false, false},
                {true, false, true},
                {true, true, false},
                {true, true, true}
        };

        //2nd solution with 1d array
        boolean[] values2 = {false, false, false, false, false, true, false, true, false, false, true, true, true, false, false, true, false, true, true, true, false, true, true, true};

        //2d array
        for (int i = 0; i < values.length; i++) {
            A2 = values[i][0];
            B2 = values[i][1];
            C2 = values[i][2];
            boolean res = (!(!(A2)) || (!(A2))) || ((B2 && ((!(B2 && C2)))) || (!(!(B2 && C2))));

            System.out.println(res);
        }
        //1d array
        for (int i = 0; i < values2.length - 3; i += 3) {
            A2 = values2[i];
            B2 = values2[i + 1];
            C2 = values2[i + 2];
            boolean res = (!(!(A2)) || (!(A2))) || ((B2 && ((!(B2 && C2)))) || (!(!(B2 && C2))));
            System.out.println(res);
        }


        //boolean y2 = (!(!(A2)) || (!(A2)))||((B2&&((!(B2&&C2))))||(!(!(B2&&C2))));
        //here I am just break it into pieces
//                boolean g11 = !(A2);
//
//                boolean g31 = !(B2&&C2);
//                boolean g41 = (B2&& (!(B2&&C2)));
//                boolean g51 = !(!(B2&&C2));
//
//                boolean g21 = (!(A2))&&(g41);
//                boolean g2z = !g21;
//                boolean g3z = g41^g51; //https://www.baeldung.com/java-xor-operator - XOR operator in Java
//                Boolean result = (g2z || g3z);
//                String result = (String) res.toString();
//                System.out.println(result);
//            }


        //B1)

        int a;
        System.out.println("Read a: ");
        a = sc.nextInt();

        if (a < 0) {
            a = a * (-1);
            System.out.println(" print a: " + a);
        } else {
            System.out.println(" print a: " + a);
        }
//
//        //B2)
        //Tip(1)
        System.out.println("Read x1: ");
        int x1 = sc.nextInt();
        ;
        int y1 = 0;
        int i = 1;
        do {
            if (i <= 8) {
                System.out.println("Print x1: " + x);
                x1++;
                y1 = y1 + x1;
            }
            i = i + 2; //αυξάνει σε κάθε επανάληψη κατα 2
        } while (i <= 8);
        System.out.println("Print y1: " + y1);


        //Τip(2)
        System.out.println("Read x2: ");
        int x2 = sc.nextInt();
        int y3;
        int z4;
        if (x2 < 50) {
            y3 = 10;

            if (x2 < 10) {
                z4 = y3 - x2;

            } else {
                z4 = y3 + x2;
            }
            System.out.println(" Print y3: " + y3 + " Print z4: " + z4);
        } else {
            y3 = 30;
            z4 = y3 - x2;
            System.out.println(" Print y3: " + y3 + " Print z4: " + z4);
        }
//
//            //TIP(3)
        System.out.println(" Read x3: ");
        double x3 = sc.nextDouble();  //εδω μήπως θέλει double λόγω διαίρεσης για την ακριβεία των δεκαδικών

        if (x3 < 50) {
            x3 = x3 - (x3 * 10 / 100);
        } else {
            if (x3 < 150) {
                x3 = x3 - (x3 * 20 / 100);
            } else {
                if (x3 < 250) {
                    x3 = x3 - (x3 * 30 / 100);
                } else {
                    x3 = x3 - (x3 * 40 / 100);
                }
            }
        }
        System.out.println("Print x3: " + x3);

        sc.close();

    }
}



