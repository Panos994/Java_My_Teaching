package org.example.W3Schools.JavaSmallProjectAndEx.Ex16;

import java.util.Scanner;

public class Main {
    private static int[] votes = new int[3];  // Assuming 3 candidates
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Welcome you your voting system! Press 1 for Kiriakos Mitsotakis, 2 for Zoi Konstantopoulou, 3 for Alexis Tsipras and X for exit: ");
//        String option = "";
//        option = sc.nextLine();
//
//        while(option.equals("1") || option.equals("2") || option.equals("3")){
//            switch (option){
//                case "1" -> System.out.println("You voted for Kiriakos Mitsotakis!");
//                case "2" -> System.out.println("You voted for Zoi Konstantopoulou!");
//                case "3" -> System.out.println("You voted for Alexis Tsipras!");
//            }
//            System.out.println("Press 1 for Kiriakos Mitsotakis, 2 for Zoi Konstantopoulou, 3 for Alexis Tsipras and X for exit: ");
//            option = sc.nextLine();
//        }
        //or
        Scanner scanner = new Scanner(System.in);
        boolean voting = true;

        while (voting) {
            System.out.println("Enter the candidate number to vote for (1-3), or 0 to end voting:");
            int input = scanner.nextInt();

            if (input == 0) {
                voting = false;  // End voting if input is 0
            } else {
                castVote(input);  // Cast a vote
            }
        }

        System.out.println("Voting has ended. Final results:");
        displayResults();  // Display final results
        scanner.close();

    }


    // Method to cast a vote
    public static void castVote(int candidate) {
        if (candidate >= 1 && candidate <= votes.length) {
            votes[candidate - 1]++;  // Increment vote count for the chosen candidate
            System.out.println("Vote cast for Candidate " + candidate);
        } else {
            System.out.println("Invalid candidate number. Try again.");
        }
    }

    // Method to display the vote count
    public static void displayResults() {
        for (int i = 0; i < votes.length; i++) {
            System.out.println("Candidate " + (i + 1) + ": " + votes[i] + " votes");
        }
    }
}
