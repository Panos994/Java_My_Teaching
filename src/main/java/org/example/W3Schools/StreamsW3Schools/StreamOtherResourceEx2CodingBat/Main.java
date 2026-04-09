package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceEx2CodingBat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        Άσκηση: Φιλτράρισμα και Μετατροπή Λίστας
//        Δίνεται μια λίστα από ονόματα (Strings). Να γράψετε μια μέθοδο που:
//
//        Φιλτράρει και κρατά μόνο τα ονόματα που έχουν μήκος μεγαλύτερο από 4 χαρακτήρες.
//                Μετατρέπει όλα τα ονόματα σε κεφαλαία γράμματα.
//        Επιστρέφει τη νέα λίστα με τα φιλτραρισμένα και μετατρεμένα ονόματα.

        List<String> names = Arrays.asList("John", "Alice", "Bob", "Catherine", "David");
        List<String> filteredNames = names.stream().filter(s -> s.length() > 4).collect(Collectors.toList());
        System.out.println(filteredNames);

//        Άσκηση: Υπολογισμός Τετραγώνων και Φιλτράρισμα
//        Δίνεται μια λίστα από ακέραιους αριθμούς. Να γράψετε μια μέθοδο που:
//
//        Υπολογίζει το τετράγωνο (square) κάθε αριθμού.
//        Φιλτράρει και κρατά μόνο τα τετράγωνα που είναι μεγαλύτερα από 50.
//        Επιστρέφει τη νέα λίστα με τα φιλτραρισμένα τετράγωνα.

        List<Integer> myNums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> squared = myNums.stream().map(n -> n * n).filter(n -> n > 50).collect(Collectors.toList());
        System.out.println(squared);



    }
}
