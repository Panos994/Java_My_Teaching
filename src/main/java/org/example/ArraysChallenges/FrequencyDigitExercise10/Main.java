package org.example.ArraysChallenges.FrequencyDigitExercise10;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,33};
        int n = 1;
        findDigitFrequency(arr, n);

        //
        long number = 22233311;
        displayDigitFreq(number);
    }
    public static void findDigitFrequency(int[] num, int n){
        int count = 0;
        for(int i = 0; i < num.length; i++){
            if(num[i] == n){
                count++;
            }
        }
        System.out.println("Frequency of this digit: " + n + " in the array is: " + count);
    }

    //or
    public static void displayDigitFreq(long num){
        int[] freq = new int[10]; //10 λογω των 0-9 πιθανων ψηφιων
        long temp = Math.abs(num); //για αποφυγη αρνητικων
        if(temp == 0){
            freq[0]++;
        }

        // Σπάμε τον αριθμό σε ψηφία
        while (temp > 0) {
            int digit = (int) (temp % 10); // Παίρνουμε το τελευταίο ψηφίο
            freq[digit]++;                // Αυξάνουμε το κοντέρ στη θέση του ψηφίου
            temp /= 10;                   // Αφαιρούμε το τελευταίο ψηφίο
        }
        for(int i = 0; i < freq.length;i++){
            if(freq[i] > 0){
                System.out.println("Digit " + i + " occurs " + freq[i] + " times ");
            }
        }
    }
}
