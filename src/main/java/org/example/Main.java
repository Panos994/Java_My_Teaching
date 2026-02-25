package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int getUserInputArray() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void fillRandom(char[][] arr2D) { //HELP
        Random rand = new Random();
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) { //--> το arr2D[i].length λογικα ειναι το μηκος της γραμμης δηλαδη αν η γραμμη εχει 3 στοιχεια μετα εχει 2 αλλαζει το μηκος

                char randomChar = (char) ('1' + rand.nextInt(arr2D.length / 2)); //https://www.bing.com/search?q=Which+libraries+in+java+make+random+characters+&form=ANNH01&refig=69046f8d7b2e4b40ac04574c62c63c98&pc=DCTS
                if (randomChar != '1') {
                    arr2D[i][j] = ' ';
                } else if (randomChar == '1') {
                    arr2D[i][j] = '1';
                }
            }
        }
    }

    public static void fillRandom2(char[][] arr2D){
        Random rand = new Random();
        int rows = arr2D.length;
        int cols = arr2D[0].length;
        int half = (int) (rows * cols)/2;
        int k = 0;
        int r = 0;
        int c = 0;
        for(int i = 0; i < rows;i++){
            for(int j = 0; j < cols;j++){
                arr2D[i][j] = ' ';
            }
        }
        do{
            do{
                r = rand.nextInt(0, rows);
                c = rand.nextInt(0,cols);
            } while(arr2D[r][c] == '1');
            arr2D[r][c] = '1';
            k++;
        } while(k < half);
    }

    public static void print2Darr2(char[][] arr2D){
        for(int i = 0; i < arr2D.length;i++){
            System.out.print("[");
            for(int j = 0; j < arr2D[i].length;j++){
                System.out.print((arr2D[i][j]));
                if(j < arr2D[i].length -1)
                System.out.print(",");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void print2Darr(char[][] arr2D) {  //HELP
        for (char[] i : arr2D) {
            System.out.println(Arrays.toString(i));  // https://www.geeksforgeeks.org/java/print-2-d-array-matrix-java/
        }
    }

    public static int discover4(char[][] arr2D) { //HELP   -- να το δούμε μαζί  ---> https://stackoverflow.com/questions/32770321/connect-4-check-for-a-win-algorithm
        int horizontalOnes = 0; //ΑΕΠΠ βιντεο //https://www.youtube.com/watch?time_continue=235&v=HZQJGEpjxjY&embeds_referring_euri=https%3A%2F%2Fwww.bing.com%2F&embeds_referring_origin=https%3A%2F%2Fwww.bing.com&source_ve_path=Mjg2NjY
        int verticalOnes = 0;
        int rightDiagonalOnes = 0;
        int leftDiagonalOnes = 0;
        int result = 0;
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length - 3; j++) { //αφού ψάχνω για τετράδες και μετατοπίζω τα στοιχεια στην επομενη ή προηγουμενη θέση --> σε αυτη την περίπτωση μετατοπίζω στηλη σε j+1, j+2, j+3 αρα αν δεν κανω arr2D[i].length-3 θα βγει IndexArrayOutOfBounds Exc. πχ: εχω 4 και 5 (πρεπει να ειναι 5 - 3 = 2 γιατί θα κάνω 2, 2+1 = 3, 2+2 = 4, 2+3 = 5 και αν το συνεχίσω θα εχω exception
                if (arr2D[i][j] == '1' && arr2D[i][j + 1] == '1' && arr2D[i][j + 2] == '1' && arr2D[i][j + 3] == '1') {
                    horizontalOnes++;
                }
            }
        }
        for (int i = 0; i < arr2D.length - 3; i++) { // το ίδιο
            for (int j = 0; j < arr2D[i].length; j++) {
                if (arr2D[i][j] == '1' && arr2D[i + 1][j] == '1' && arr2D[i + 2][j] == '1' && arr2D[i + 3][j] == '1') {
                    verticalOnes++;
                }
            }
        }
        for (int i = 0; i < arr2D.length - 3; i++) {  //εδω κινουμε και προς τα κάτω και δεξια
            for (int j = 0; j < arr2D[i].length - 3; j++) { //εδω κινουμε και προς τα κάτω και δεξια
                if (arr2D[i][j] == '1' && arr2D[i + 1][j + 1] == '1' && arr2D[i + 2][j + 2] == '1' && arr2D[i + 3][j + 3] == '1') { //AEΠΠ βιντεο κυρ. διαγ i==j
                    rightDiagonalOnes++;
                }
            }
        }
        for (int i = 0; i < arr2D.length - 3; i++) { //εδω κινουμε και προς τα κάτω και δεξια
            for (int j = 3; j < arr2D[i].length; j++) { //εδω κοιταζω προς τα πισω αριστερα για αυτό το ξεκινάω απο j = 3 αφου μετα κάνω j-1, j-2, j-3
                if (arr2D[i][j] == '1' && arr2D[i + 1][j - 1] == '1' && arr2D[i + 2][j - 2] == '1' && arr2D[i + 3][j - 3] == '1') { //i+j == N-1
                    leftDiagonalOnes++;
                }
            }
        }
        result = horizontalOnes + verticalOnes + rightDiagonalOnes + leftDiagonalOnes;
        return result;
    }
    public static void discover4For100Arrays(int firstDimension, int secondDimension){
        System.out.println("Result of 100 arrays below: ");
        int numberOfArrays = 100;
        int totalResult = 0;
        double avg = 0.0;
        for(int i = 0; i < numberOfArrays;i++){
            char[][] arrays = new char[firstDimension][secondDimension];
            fillRandom2(arrays);
            print2Darr2(arrays);
            int result = discover4(arrays);
            System.out.println("Total group with four ones: " + result);
            System.out.println("\n");
            if(result==0){
                continue;
            }
            totalResult+=result;
        }
        avg = (double) totalResult/100;
        System.out.println("Τotal group of quadruplets with ones: " + totalResult);
        System.out.println("Average of all the arrays is: " + avg);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstDimension = 0;
        int secondDimension = 0;
        do {
            if (firstDimension < 4 || firstDimension > 12 || secondDimension < 4 || secondDimension > 12) {
                System.out.println("Please type again your input for the 2D arrays. You should choose lengths between length>=4 and length<=12");
            }
            firstDimension = getUserInputArray();
            secondDimension = getUserInputArray();
        } while (firstDimension < 4 || firstDimension > 12 || secondDimension < 4 || secondDimension > 12);
        char[][] arrayOfCharacters = new char[firstDimension][secondDimension];
        fillRandom2(arrayOfCharacters);
        print2Darr2(arrayOfCharacters);
        System.out.println("Total group with four ones: " + discover4(arrayOfCharacters));

        System.out.println("\n\n");
        discover4For100Arrays(firstDimension,secondDimension);
    }
}