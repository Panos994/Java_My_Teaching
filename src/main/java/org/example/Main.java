package org.example;

import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void fillRandom(String chessM) {
        //String chessM = "CHESSMASTER";

        String alpBet = "ABCDEFGHIJK";
        int alpB = 0;

        Random rand = new Random();
        char[][] arr2D2 = new char[chessM.length()][chessM.length()];
        int rows = arr2D2.length;
        int cols = arr2D2[0].length;
        int j1 = rand.nextInt(1, cols);
        //
        int tempj2 = rand.nextInt(0, cols-1);
        int indexExclusion = 1;
        int j2;
        if(tempj2 < indexExclusion){
            j2 = tempj2;
        } else {
            j2 = tempj2 + 1;
        }
        //

        int j3 = rand.nextInt(0, cols);
        int j4 = rand.nextInt(0, cols);
        int j5 = rand.nextInt(0, cols);
        int j6 = rand.nextInt(0, cols);
        int j7 = rand.nextInt(0, cols);
        int j8 = rand.nextInt(0, cols);
        int j9 = rand.nextInt(0, cols);
        int j10 = rand.nextInt(0, cols);
        int j11 = rand.nextInt(0, cols);
        int i = 0;
        int j = 0;

        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        int t4 = 0;
        int t5 = 0;
        int t6 = 0;
        int t7 = 0;
        int t8 = 0;
        int t9 = 0;
        int t10 = 0;
        int t11 = 0;

        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                if (i == j) { //δηλαδή η κύρια διαγώνιος να μπει Χ
                    arr2D2[i][j] = 'X';
                }
            }
            if (i == j) {
                arr2D2[i][j] = 'X';
            } else if (i != j) {
                arr2D2[0][j1] = 'C';
                t1 = arr2D2[0][j1];
                arr2D2[1][j2] = 'H';
                t2 = arr2D2[1][j2];
                arr2D2[2][j3] = 'E';
                t3 = arr2D2[2][j3];
                arr2D2[3][j4] = 'S';
                t4 = arr2D2[3][j4];
                arr2D2[4][j5] = 'S';
                t5 = arr2D2[4][j5];
                arr2D2[5][j6] = 'M';
                t6 = arr2D2[5][j6];
                arr2D2[6][j7] = 'A';
                t7 = arr2D2[6][j7];
                arr2D2[7][j8] = 'S';
                t8 = arr2D2[7][j8];
                arr2D2[8][j9] = 'T';
                t9 = arr2D2[8][j9];
                arr2D2[9][j10] = 'E';
                t10 = arr2D2[9][j10];
                arr2D2[10][j11] = 'R';
                t11 = arr2D2[10][j11];
            }
        }
        //
        char[] alp = new char[11];
        alp[0] = 'A';
        alp[1] = 'B';
        alp[2] = 'C';
        alp[3] = 'D';
        alp[4] = 'E';
        alp[5] = 'F';
        alp[6] = 'G';
        alp[7] = 'H';
        alp[8] = 'I';
        alp[9] = 'J';
        alp[10] = 'K';
        //print2DarrFrom9(arr2D2);
        //
        //
        char[] storeVal = new char[11];
        System.out.println();
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                if (t1 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t2 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t3 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t4 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t5 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t6 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t7 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t8 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t9 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t10 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t11 == arr2D2[i][j]) {
                    storeVal[i] = alp[j];
                }
            }
        }
        //System.out.print(Arrays.toString(storeVal));
        //printing process and design
        for (i = 0; i < arr2D2.length; i++) {
            System.out.print((arr2D2.length - i) + "\t[");
            for (j = 0; j < arr2D2.length; j++) {
                System.out.print(arr2D2[i][j]);
                if (j < arr2D2[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]" + "\t" + chessM.charAt(i) + ":" + "(" + storeVal[i] + "," + (arr2D2.length - i) + ")");
            System.out.println();
        }
        for (i = 0; i < arr2D2.length; i++) {
            System.out.print(" " + alpBet.charAt(i));
        }
    }
    public static void fillRandomMind(String mindB) {
        //String chessM = "CHESSMASTER";

        String alpBet = "ABCDEFGHIJK";
        int alpB = 0;

        Random rand = new Random();
        char[][] arr2D2 = new char[mindB.length()][mindB.length()];
        int rows = arr2D2.length;
        int cols = arr2D2[0].length;
        int j1 = rand.nextInt(0, cols);
        int j2 = rand.nextInt(0, cols);
        int j3 = rand.nextInt(0, cols);
        int j4 = rand.nextInt(0, cols);
        int j5 = rand.nextInt(0, cols);
        int j6 = rand.nextInt(0, cols);
        int j7 = rand.nextInt(0, cols);
        int j8 = rand.nextInt(0, cols);
        int j9 = rand.nextInt(0, cols);
        int j10 = rand.nextInt(0, cols);
        int j11 = rand.nextInt(0, cols);
        int i = 0;
        int j = 0;

        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        int t4 = 0;
        int t5 = 0;
        int t6 = 0;
        int t7 = 0;
        int t8 = 0;
        int t9 = 0;
        int t10 = 0;
        int t11 = 0;

        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                if (i == j) { //δηλαδή η κύρια διαγώνιος να μπει Χ
                    arr2D2[i][j] = 'X';
                }
            }
            if (i == j) {
                arr2D2[i][j] = 'X';
            } else if (i != j) {
                arr2D2[0][j1] = 'M';
                t1 = arr2D2[0][j1];
                arr2D2[1][j2] = 'I';
                t2 = arr2D2[1][j2];
                arr2D2[2][j3] = 'N';
                t3 = arr2D2[2][j3];
                arr2D2[3][j4] = 'D';
                t4 = arr2D2[3][j4];
                arr2D2[4][j5] = 'B';
                t5 = arr2D2[4][j5];
                arr2D2[5][j6] = 'L';
                t6 = arr2D2[5][j6];
                arr2D2[6][j7] = 'O';
                t7 = arr2D2[6][j7];
                arr2D2[7][j8] = 'W';
                t8 = arr2D2[7][j8];
                arr2D2[8][j9] = 'I';
                t9 = arr2D2[8][j9];
                arr2D2[9][j10] = 'N';
                t10 = arr2D2[9][j10];
                arr2D2[10][j11] = 'G';
                t11 = arr2D2[10][j11];
            }
        }
        //
        char[] alp = new char[11];
        alp[0] = 'A';
        alp[1] = 'B';
        alp[2] = 'C';
        alp[3] = 'D';
        alp[4] = 'E';
        alp[5] = 'F';
        alp[6] = 'G';
        alp[7] = 'H';
        alp[8] = 'I';
        alp[9] = 'J';
        alp[10] = 'K';
        //print2DarrFrom9(arr2D2);
        //
        //
        char[] storeVal = new char[11];
        System.out.println();
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                if (t1 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t2 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t3 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t4 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t5 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t6 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t7 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t8 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t9 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t10 == arr2D2[i][j]) {

                    storeVal[i] = alp[j];
                }
                if (t11 == arr2D2[i][j]) {
                    storeVal[i] = alp[j];
                }
            }
        }
        //System.out.print(Arrays.toString(storeVal));
        //printing process and design
        for (i = 0; i < arr2D2.length; i++) {
            System.out.print((arr2D2.length - i) + "[");
            for (j = 0; j < arr2D2.length; j++) {
                System.out.print(arr2D2[i][j]);
                if (j < arr2D2[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]" + "\t" + mindB.charAt(i) + ":" + "(" + storeVal[i] + "," + (arr2D2.length - i) + ")");
            System.out.println();
        }
        for (i = 0; i < arr2D2.length; i++) {
            System.out.print(" " + alpBet.charAt(i));
        }
    }

    public static void fillRandomExtraV(){
        Random rand = new Random();
        int i = 0;
        int j = 0;
        String ex = "EXTRAVAGANT";
        char[][] arr2D2 = new char[ex.length()][ex.length()];
        int rows = arr2D2.length;
        int cols = arr2D2[0].length;
        boolean[] used = new boolean[ex.length()];
        for( i = 0; i <rows; i++){
            for(j = 0; j < cols;j++){
                if (i == j) { //δηλαδή η κύρια διαγώνιος να μπει Χ
                    arr2D2[i][j] = 'X';
                } else {
                    arr2D2[i][j] = ' ';
                }

            }
        }
        for (i = 0; i < rows; i++) {
                int randomVal;
                do{
                    randomVal = rand.nextInt(cols);
                } while(randomVal == i);
                int randomizer;
                do{
                    randomizer = rand.nextInt(ex.length());
                } while(used[randomizer]);
                used[randomizer] = true;
                arr2D2[i][randomVal] = ex.charAt(randomizer);


        }
        //printing process and design
        for (i = 0; i < arr2D2.length; i++) {
            System.out.print((arr2D2.length - i) + "\t[");
            for (j = 0; j < arr2D2.length; j++) {
                System.out.print(arr2D2[i][j]);
                if (j < arr2D2[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void print2DarrFrom9(char[][] arr2D) { //αντιγραφή από την άσκηση 9
        String chessM = "CHESSMASTER";
        String alpBet = "ABCDEFGHIJK";
        int alpB = 0;
        int j = 0;
        int i = 0;
        for (i = 0; i < arr2D.length; i++) {
            System.out.print((arr2D.length - i) + "[");
            for (j = 0; j < arr2D.length; j++) {
                System.out.print(arr2D[i][j]);
                if (j < arr2D[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]" + "\t" + chessM.charAt(i) + ":" + "(" + alpBet.charAt(i) + "," + (arr2D.length - i) + ")");
            System.out.println();
        }

        for (i = 0; i < arr2D.length; i++) {
            System.out.print(" " + alpBet.charAt(i));
        }
    }

    public static void printChess(String[][] arr2D) { //αντιγραφή από την άσκηση 9
        String alpBet = "abcdefgh";
        int j = 0;
        int i = 0;
        for (i = 0; i < arr2D.length; i++) {
            System.out.print("      " + alpBet.charAt(i));
        }
        System.out.println();
        for (i = 0; i < arr2D.length; i++) {
            System.out.print((arr2D.length - i) + "[");
            System.out.println("-------------------------------------------------------------");
            int rightNumbers = arr2D.length-i;
            for (j = 0; j < arr2D.length; j++) {
                System.out.print(arr2D[i][j]);
                if (j < arr2D[i].length - 1) {
                    System.out.print(" |");
                }
            }
            System.out.print("]" + "\t" + rightNumbers);
            System.out.println();
        }

        for (i = 0; i < arr2D.length; i++) {
            System.out.print("      " + alpBet.charAt(i));
        }
    }
    public static void setChessPieces(String[][] chessArray){
        int rows = chessArray.length;
        int cols = chessArray[0].length;
        int i,j = 0;
        System.out.println("\n" + "Let's begin the chess game ♟\uFE0F");
        for(i = 0 ; i < rows;i++){
            for(j = 0; j < cols-1; j+=2){
                chessArray[0][0] = " [ ♜ ]";    //https://emojipedia.org/black-large-square, https://www.namecheap.com/visual/font-generator/chess-symbols/
                chessArray[0][1] = " [|♞|]";
                chessArray[0][2] = "[ ♝ ]";
                chessArray[0][3] = "[|♛|]";
                chessArray[0][4] = "[ ♚ ]";
                chessArray[0][5] = " [|♝|]";
                chessArray[0][6] = " [ ♞ ]";
                chessArray[0][7] = "[|♜]";
                chessArray[1][0] = " [|♟ ]";
                chessArray[1][1] = " [♟ ]";
                chessArray[1][2] = " [|♟ ]";
                chessArray[1][3] = "[♟ ]";
                chessArray[1][4] = " [| ♟ ]";
                chessArray[1][5] = "[♟ ]";
                chessArray[1][6] = "  [| ♟ ]";
                chessArray[1][7] = "[♟]";
                chessArray[2][j+1] = " [|||]";
                chessArray[2][j] = " [   ]";
                chessArray[3][j] = " [|||]";
                chessArray[3][j+1] = " [   ]";
                chessArray[4][j+1] = " [|||]";
                chessArray[4][j] = " [   ]";
                chessArray[5][j] = " [|||]";
                chessArray[5][j+1] = " [   ]";
                chessArray[6][0] = " [♙ ]";
                chessArray[6][1] = " [|♙]";
                chessArray[6][2] = " [♙ ]";
                chessArray[6][3] = " [|♙]";
                chessArray[6][4] = " [♙ ]";
                chessArray[6][5] = "  [|♙]";
                chessArray[6][6] = "   [♙ ]";
                chessArray[6][7] = " [|♙]";
                chessArray[7][0] = "[|♖|]";
                chessArray[7][1] = "[ ♘ ]";
                chessArray[7][2] = "[|♗|]";
                chessArray[7][3] = " [ ♕ ]";
                chessArray[7][4] = "[|♔|]";
                chessArray[7][5] = " [ ♗ ]";
                chessArray[7][6] = " [|♘|]";
                chessArray[7][7] = "[ ♖]";

            }
        }
        printChess(chessArray);
    }

    public static void ruyLopez(){
        String[][] chessArray = new String[8][8];
        int rows = chessArray.length;
        int cols = chessArray[0].length;
        int i,j = 0;
        System.out.println("\n" + "Let's begin the chess game ♟\uFE0F");
        for(i = 0 ; i < rows;i++){
            for(j = 0; j < cols-1; j+=2){
                chessArray[0][0] = " [ ♜ ]";    //https://emojipedia.org/black-large-square, https://www.namecheap.com/visual/font-generator/chess-symbols/
                chessArray[0][1] = " [|||]";
                chessArray[0][2] = "[ ♝ ]";
                chessArray[0][3] = "[|♛|]";
                chessArray[0][4] = "[ ♚ ]";
                chessArray[0][5] = " [|♝|]";
                chessArray[0][6] = " [ ♞ ]";
                chessArray[0][7] = "[|♜]";
                chessArray[1][0] = " [|♟ ]";
                chessArray[1][1] = " [♟ ]";
                chessArray[1][2] = " [|♟ ]";
                chessArray[1][3] = "[♟ ]";
                chessArray[1][4] = " [|||]";
                chessArray[1][5] = "[♟ ]";
                chessArray[1][6] = "  [| ♟ ]";
                chessArray[1][7] = "[♟]";
                chessArray[2][0] = " [   ]";
                chessArray[2][1] = " [|||]";
                chessArray[2][2] = " [ ♞ ]";
                chessArray[2][3] = " [|||]";
                chessArray[2][4] = " [   ]";
                chessArray[2][5] = " [|||]";
                chessArray[2][6] = " [   ]";
                chessArray[2][7] = " [|||]";
                chessArray[3][0] = " [|||]";
                chessArray[3][1] = " [ ♗]";
                chessArray[3][2] = " [|||]";
                chessArray[3][3] =" [   ]";
                chessArray[3][4] = " [|♟ ] ";
                chessArray[3][5] =" [   ]";
                chessArray[3][6] = " [|||]";
                chessArray[3][7] = " [   ]";
                chessArray[4][0] = " [   ]";
                chessArray[4][1] = " [|||]";
                chessArray[4][2] = " [   ]";
                chessArray[4][3] = " [|||]";
                chessArray[4][4] = " [ ♙ ]";
                chessArray[4][5] = " [|||]";
                chessArray[4][6] = " [   ]";
                chessArray[4][7] = " [|||]";
                chessArray[5][0] = " [|||]";
                chessArray[5][1] = " [   ]";
                chessArray[5][2] = " [|||]";
                chessArray[5][3] = " [   ]";
                chessArray[5][4] = " [|||]";
                chessArray[5][5] = " [ ♘ ]";
                chessArray[5][6] = " [|||]";
                chessArray[5][7] = " [   ]";
                chessArray[6][0] = " [♙ ]";
                chessArray[6][1] = " [|♙]";
                chessArray[6][2] = " [♙ ]";
                chessArray[6][3] = " [|♙]";
                chessArray[6][4] = " [   ]";
                chessArray[6][5] = "  [|♙]";
                chessArray[6][6] = "   [♙ ]";
                chessArray[6][7] = " [|♙]";
                chessArray[7][0] = "[|♖|]";
                chessArray[7][1] = "[ ♘ ]";
                chessArray[7][2] = "[|♗|]";
                chessArray[7][3] = " [ ♕ ]";
                chessArray[7][4] = "[|♔|]";
                chessArray[7][5] = " [   ]";
                chessArray[7][6] = " [|||]";
                chessArray[7][7] = "[ ♖]";
            }
        }
        printChess(chessArray);
    }

    public static void italianGame(){
        String[][] chessArray = new String[8][8];
        int rows = chessArray.length;
        int cols = chessArray[0].length;
        int i,j = 0;
        System.out.println("\n" + "Let's begin the chess game ♟\uFE0F");
        for(i = 0 ; i < rows;i++){
            for(j = 0; j < cols-1; j+=2){
                chessArray[0][0] = " [ ♜ ]";    //https://emojipedia.org/black-large-square, https://www.namecheap.com/visual/font-generator/chess-symbols/
                chessArray[0][1] = " [|||]";
                chessArray[0][2] = "[ ♝ ]";
                chessArray[0][3] = "[|♛|]";
                chessArray[0][4] = "[ ♚ ]";
                chessArray[0][5] = " [|♝|]";
                chessArray[0][6] = " [ ♞ ]";
                chessArray[0][7] = "[|♜]";
                chessArray[1][0] = " [|♟ ]";
                chessArray[1][1] = " [♟ ]";
                chessArray[1][2] = " [|♟ ]";
                chessArray[1][3] = "[♟ ]";
                chessArray[1][4] = " [|||]";
                chessArray[1][5] = "[♟ ]";
                chessArray[1][6] = "  [| ♟ ]";
                chessArray[1][7] = "[♟]";
                chessArray[2][0] = " [   ]";
                chessArray[2][1] = " [|||]";
                chessArray[2][2] = " [ ♞ ]";
                chessArray[2][3] = " [|||]";
                chessArray[2][4] = " [   ]";
                chessArray[2][5] = " [|||]";
                chessArray[2][6] = " [   ]";
                chessArray[2][7] = " [|||]";
                chessArray[3][0] = " [|||]";
                chessArray[3][1] = " [  ]";
                chessArray[3][2] = " [|||]";
                chessArray[3][3] =" [   ]";
                chessArray[3][4] = " [|♟ ] ";
                chessArray[3][5] =" [   ]";
                chessArray[3][6] = " [|||]";
                chessArray[3][7] = " [   ]";
                chessArray[4][0] = " [   ]";
                chessArray[4][1] = " [|||]";
                chessArray[4][2] = " [ ♟]";
                chessArray[4][3] = " [|||]";
                chessArray[4][4] = " [ ♙ ]";
                chessArray[4][5] = " [|||]";
                chessArray[4][6] = " [   ]";
                chessArray[4][7] = " [|||]";
                chessArray[5][0] = " [|||]";
                chessArray[5][1] = " [   ]";
                chessArray[5][2] = " [|||]";
                chessArray[5][3] = " [   ]";
                chessArray[5][4] = " [|||]";
                chessArray[5][5] = " [ ♘ ]";
                chessArray[5][6] = " [|||]";
                chessArray[5][7] = " [   ]";
                chessArray[6][0] = " [♙ ]";
                chessArray[6][1] = " [|♙]";
                chessArray[6][2] = " [♙ ]";
                chessArray[6][3] = " [|♙]";
                chessArray[6][4] = " [   ]";
                chessArray[6][5] = "  [|♙]";
                chessArray[6][6] = "   [♙ ]";
                chessArray[6][7] = " [|♙]";
                chessArray[7][0] = "[|♖|]";
                chessArray[7][1] = "[ ♘ ]";
                chessArray[7][2] = "[|♗|]";
                chessArray[7][3] = " [ ♕ ]";
                chessArray[7][4] = "[|♔|]";
                chessArray[7][5] = " [   ]";
                chessArray[7][6] = " [|||]";
                chessArray[7][7] = "[ ♖]";
            }
        }
        printChess(chessArray);
    }
    public static void sicilianDefense(){
        String[][] chessArray = new String[8][8];
        int rows = chessArray.length;
        int cols = chessArray[0].length;
        int i,j = 0;
        System.out.println("\n" + "Let's begin the chess game ♟\uFE0F");
        for(i = 0 ; i < rows;i++){
            for(j = 0; j < cols-1; j+=2){
                chessArray[0][0] = " [ ♜ ]";    //https://emojipedia.org/black-large-square, https://www.namecheap.com/visual/font-generator/chess-symbols/
                chessArray[0][1] = " [|♞|]";
                chessArray[0][2] = "[ ♝ ]";
                chessArray[0][3] = "[|♛|]";
                chessArray[0][4] = "[ ♚ ]";
                chessArray[0][5] = " [|♝|]";
                chessArray[0][6] = " [ ♞ ]";
                chessArray[0][7] = "[|♜]";
                chessArray[1][0] = " [|♟ ]";
                chessArray[1][1] = " [♟ ]";
                chessArray[1][2] = " [|||]";
                chessArray[1][3] = "[♟ ]";
                chessArray[1][4] = " [| ♟ ]";
                chessArray[1][5] = "[♟ ]";
                chessArray[1][6] = "  [| ♟ ]";
                chessArray[1][7] = "[♟]";
                chessArray[2][j+1] = " [|||]";
                chessArray[2][j] = " [   ]";
                chessArray[3][j] = " [|||]";
                chessArray[3][j+1] = " [   ]";
                chessArray[3][2] = " [|♟]";
                chessArray[4][j+1] = " [|||]";
                chessArray[4][j] = " [   ]";
                chessArray[4][4] = " [ ♙ ]";
                chessArray[5][j] = " [|||]";
                chessArray[5][j+1] = " [   ]";
                chessArray[6][0] = " [♙ ]";
                chessArray[6][1] = " [|♙]";
                chessArray[6][2] = " [♙ ]";
                chessArray[6][3] = " [|♙]";
                chessArray[6][4] = " [  ]";
                chessArray[6][5] = "  [|♙]";
                chessArray[6][6] = "   [♙ ]";
                chessArray[6][7] = " [|♙]";
                chessArray[7][0] = "[|♖|]";
                chessArray[7][1] = "[ ♘ ]";
                chessArray[7][2] = "[|♗|]";
                chessArray[7][3] = " [ ♕ ]";
                chessArray[7][4] = "[|♔|]";
                chessArray[7][5] = " [ ♗ ]";
                chessArray[7][6] = " [|♘|]";
                chessArray[7][7] = "[ ♖]";
            }
        }
        printChess(chessArray);
    }
    public static void frenchDefense(){
        String[][] chessArray = new String[8][8];
        int rows = chessArray.length;
        int cols = chessArray[0].length;
        int i,j = 0;
        System.out.println("\n" + "Let's begin the chess game ♟\uFE0F");
        for(i = 0 ; i < rows;i++){
            for(j = 0; j < cols-1; j+=2){
                chessArray[0][0] = " [ ♜ ]";    //https://emojipedia.org/black-large-square, https://www.namecheap.com/visual/font-generator/chess-symbols/
                chessArray[0][1] = " [|♞|]";
                chessArray[0][2] = "[ ♝ ]";
                chessArray[0][3] = "[|♛|]";
                chessArray[0][4] = "[ ♚ ]";
                chessArray[0][5] = " [|♝|]";
                chessArray[0][6] = " [ ♞ ]";
                chessArray[0][7] = "[|♜]";
                chessArray[1][0] = " [|♟ ]";
                chessArray[1][1] = " [♟ ]";
                chessArray[1][2] = " [|♟]";
                chessArray[1][3] = "[♟ ]";
                chessArray[1][4] = " [|||]";
                chessArray[1][5] = "[♟ ]";
                chessArray[1][6] = "  [| ♟ ]";
                chessArray[1][7] = "[♟]";
                chessArray[2][j+1] = " [|||]";
                chessArray[2][j] = " [   ]";
                chessArray[2][4] = " [ ♟]";
                chessArray[3][j] = " [|||]";
                chessArray[3][j+1] = " [   ]";
                chessArray[3][2] = " [|||]";
                chessArray[4][j+1] = " [|||]";
                chessArray[4][j] = " [   ]";
                chessArray[4][4] = " [ ♙ ]";
                chessArray[5][j] = " [|||]";
                chessArray[5][j+1] = " [   ]";
                chessArray[6][0] = " [♙ ]";
                chessArray[6][1] = " [|♙]";
                chessArray[6][2] = " [♙ ]";
                chessArray[6][3] = " [|♙]";
                chessArray[6][4] = " [  ]";
                chessArray[6][5] = "  [|♙]";
                chessArray[6][6] = "   [♙ ]";
                chessArray[6][7] = " [|♙]";
                chessArray[7][0] = "[|♖|]";
                chessArray[7][1] = "[ ♘ ]";
                chessArray[7][2] = "[|♗|]";
                chessArray[7][3] = " [ ♕ ]";
                chessArray[7][4] = "[|♔|]";
                chessArray[7][5] = " [ ♗ ]";
                chessArray[7][6] = " [|♘|]";
                chessArray[7][7] = "[ ♖]";
            }
        }
        printChess(chessArray);
    }
    public static void caroKannDefense(){
        String[][] chessArray = new String[8][8];
        int rows = chessArray.length;
        int cols = chessArray[0].length;
        int i,j = 0;
        System.out.println("\n" + "Let's begin the chess game ♟\uFE0F");
        for(i = 0 ; i < rows;i++){
            for(j = 0; j < cols-1; j+=2){
                chessArray[0][0] = " [ ♜ ]";    //https://emojipedia.org/black-large-square, https://www.namecheap.com/visual/font-generator/chess-symbols/
                chessArray[0][1] = " [|♞|]";
                chessArray[0][2] = "[ ♝ ]";
                chessArray[0][3] = "[|♛|]";
                chessArray[0][4] = "[ ♚ ]";
                chessArray[0][5] = " [|♝|]";
                chessArray[0][6] = " [ ♞ ]";
                chessArray[0][7] = "[|♜]";
                chessArray[1][0] = " [|♟ ]";
                chessArray[1][1] = " [♟ ]";
                chessArray[1][2] = " [|||]";
                chessArray[1][3] = "[♟ ]";
                chessArray[1][4] = " [|||]";
                chessArray[1][5] = "[♟ ]";
                chessArray[1][6] = "  [| ♟ ]";
                chessArray[1][7] = "[♟]";
                chessArray[2][j+1] = " [|||]";
                chessArray[2][j] = " [   ]";
                chessArray[2][2] = " [ ♟]";
                chessArray[2][4] = " [  ]";
                chessArray[3][j] = " [|||]";
                chessArray[3][j+1] = " [   ]";
                chessArray[3][2] = " [|||]";
                chessArray[4][j+1] = " [|||]";
                chessArray[4][j] = " [   ]";
                chessArray[4][4] = " [ ♙ ]";
                chessArray[5][j] = " [|||]";
                chessArray[5][j+1] = " [   ]";
                chessArray[6][0] = " [♙ ]";
                chessArray[6][1] = " [|♙]";
                chessArray[6][2] = " [♙ ]";
                chessArray[6][3] = " [|♙]";
                chessArray[6][4] = " [  ]";
                chessArray[6][5] = "  [|♙]";
                chessArray[6][6] = "   [♙ ]";
                chessArray[6][7] = " [|♙]";
                chessArray[7][0] = "[|♖|]";
                chessArray[7][1] = "[ ♘ ]";
                chessArray[7][2] = "[|♗|]";
                chessArray[7][3] = " [ ♕ ]";
                chessArray[7][4] = "[|♔|]";
                chessArray[7][5] = " [ ♗ ]";
                chessArray[7][6] = " [|♘|]";
                chessArray[7][7] = "[ ♖]";
            }
        }
        printChess(chessArray);
    }
    public static void pircDefense(){
        String[][] chessArray = new String[8][8];
        int rows = chessArray.length;
        int cols = chessArray[0].length;
        int i,j = 0;
        System.out.println("\n" + "Let's begin the chess game ♟\uFE0F");
        for(i = 0 ; i < rows;i++){
            for(j = 0; j < cols-1; j+=2){
                chessArray[0][0] = " [ ♜ ]";    //https://emojipedia.org/black-large-square, https://www.namecheap.com/visual/font-generator/chess-symbols/
                chessArray[0][1] = " [|♞|]";
                chessArray[0][2] = "[ ♝ ]";
                chessArray[0][3] = "[|♛|]";
                chessArray[0][4] = "[ ♚ ]";
                chessArray[0][5] = " [|♝|]";
                chessArray[0][6] = " [ ♞ ]";
                chessArray[0][7] = "[|♜]";
                chessArray[1][0] = " [|♟ ]";
                chessArray[1][1] = " [♟ ]";
                chessArray[1][2] = " [|♟]";
                chessArray[1][3] = "[  ]";
                chessArray[1][4] = " [|||]";
                chessArray[1][5] = "[♟ ]";
                chessArray[1][6] = "  [| ♟ ]";
                chessArray[1][7] = "[♟]";
                chessArray[2][j+1] = " [|||]";
                chessArray[2][j] = " [   ]";
                chessArray[2][3] = " [|♟]";
                chessArray[2][4] = " [  ]";
                chessArray[3][j] = " [|||]";
                chessArray[3][j+1] = " [   ]";
                chessArray[3][2] = " [|||]";
                chessArray[4][j+1] = " [|||]";
                chessArray[4][j] = " [   ]";
                chessArray[4][4] = " [ ♙ ]";
                chessArray[5][j] = " [|||]";
                chessArray[5][j+1] = " [   ]";
                chessArray[6][0] = " [♙ ]";
                chessArray[6][1] = " [|♙]";
                chessArray[6][2] = " [♙ ]";
                chessArray[6][3] = " [|♙]";
                chessArray[6][4] = " [  ]";
                chessArray[6][5] = "  [|♙]";
                chessArray[6][6] = "   [♙ ]";
                chessArray[6][7] = " [|♙]";
                chessArray[7][0] = "[|♖|]";
                chessArray[7][1] = "[ ♘ ]";
                chessArray[7][2] = "[|♗|]";
                chessArray[7][3] = " [ ♕ ]";
                chessArray[7][4] = "[|♔|]";
                chessArray[7][5] = " [ ♗ ]";
                chessArray[7][6] = " [|♘|]";
                chessArray[7][7] = "[ ♖]";
            }
        }
        printChess(chessArray);
    }
    public static void queensGambit(){
        String[][] chessArray = new String[8][8];
        int rows = chessArray.length;
        int cols = chessArray[0].length;
        int i,j = 0;
        System.out.println("\n" + "Let's begin the chess game ♟\uFE0F");
        for(i = 0 ; i < rows;i++){
            for(j = 0; j < cols-1; j+=2){
                chessArray[0][0] = " [ ♜ ]";    //https://emojipedia.org/black-large-square, https://www.namecheap.com/visual/font-generator/chess-symbols/
                chessArray[0][1] = " [|♞|]";
                chessArray[0][2] = "[ ♝ ]";
                chessArray[0][3] = "[|♛|]";
                chessArray[0][4] = "[ ♚ ]";
                chessArray[0][5] = " [|♝|]";
                chessArray[0][6] = " [ ♞ ]";
                chessArray[0][7] = "[|♜]";
                chessArray[1][0] = " [|♟ ]";
                chessArray[1][1] = " [♟ ]";
                chessArray[1][2] = " [|♟]";
                chessArray[1][3] = "[  ]";
                chessArray[1][4] = " [|||]";
                chessArray[1][5] = "[♟ ]";
                chessArray[1][6] = "  [| ♟ ]";
                chessArray[1][7] = "[♟]";
                chessArray[2][j+1] = " [|||]";
                chessArray[2][j] = " [   ]";
                chessArray[2][3] = " [|||]";
                chessArray[2][4] = " [  ]";
                chessArray[3][j] = " [|||]";
                chessArray[3][j+1] = " [   ]";
                chessArray[3][2] = " [|||]";
                chessArray[3][3] = " [ ♟ ]";
                chessArray[4][j+1] = " [|||]";
                chessArray[4][j] = " [   ]";
                chessArray[4][2] = " [ ♙ ]";
                chessArray[4][3] = " [|♙]";
                chessArray[5][j] = " [|||]";
                chessArray[5][j+1] = " [   ]";
                chessArray[6][0] = " [♙ ]";
                chessArray[6][1] = " [|♙]";
                chessArray[6][2] = " [  ]";
                chessArray[6][3] = " [|||]";
                chessArray[6][4] = " [ ♙]";
                chessArray[6][5] = "  [|♙]";
                chessArray[6][6] = "   [♙ ]";
                chessArray[6][7] = " [|♙]";
                chessArray[7][0] = "[|♖|]";
                chessArray[7][1] = "[ ♘ ]";
                chessArray[7][2] = "[|♗|]";
                chessArray[7][3] = " [ ♕ ]";
                chessArray[7][4] = "[|♔|]";
                chessArray[7][5] = " [ ♗ ]";
                chessArray[7][6] = " [|♘|]";
                chessArray[7][7] = "[ ♖]";
            }
        }
        printChess(chessArray);
    }
    public static void indianDefenses(){
        String[][] chessArray = new String[8][8];
        int rows = chessArray.length;
        int cols = chessArray[0].length;
        int i,j = 0;
        System.out.println("\n" + "Let's begin the chess game ♟\uFE0F");
        for(i = 0 ; i < rows;i++){
            for(j = 0; j < cols-1; j+=2){
                chessArray[0][0] = " [ ♜ ]";    //https://emojipedia.org/black-large-square, https://www.namecheap.com/visual/font-generator/chess-symbols/
                chessArray[0][1] = " [|♞|]";
                chessArray[0][2] = "[ ♝ ]";
                chessArray[0][3] = "[|♛|]";
                chessArray[0][4] = "[ ♚ ]";
                chessArray[0][5] = " [|♝|]";
                chessArray[0][6] = " [   ]";
                chessArray[0][7] = "[|♜]";
                chessArray[1][0] = " [|♟ ]";
                chessArray[1][1] = " [♟ ]";
                chessArray[1][2] = " [|♟]";
                chessArray[1][3] = "[ ♟]";
                chessArray[1][4] = " [|♟|]";
                chessArray[1][5] = "[♟ ]";
                chessArray[1][6] = "  [| ♟ ]";
                chessArray[1][7] = "[♟]";
                chessArray[2][j+1] = " [|||]";
                chessArray[2][j] = " [   ]";
                chessArray[2][3] = " [|||]";
                chessArray[2][4] = " [  ]";
                chessArray[2][5] = " [|♞|]";
                chessArray[3][j] = " [|||]";
                chessArray[3][j+1] = " [   ]";
                chessArray[3][2] = " [|||]";
                chessArray[3][3] = " [  ]";
                chessArray[4][j+1] = " [|||]";
                chessArray[4][j] = " [   ]";
                chessArray[4][2] = " [   ]";
                chessArray[4][3] = " [|♙]";
                chessArray[5][j] = " [|||]";
                chessArray[5][j+1] = " [   ]";
                chessArray[6][0] = " [♙ ]";
                chessArray[6][1] = " [|♙]";
                chessArray[6][2] = " [ ♙ ]";
                chessArray[6][3] = " [|||]";
                chessArray[6][4] = " [ ♙]";
                chessArray[6][5] = "  [|♙]";
                chessArray[6][6] = "   [♙ ]";
                chessArray[6][7] = " [|♙]";
                chessArray[7][0] = "[|♖|]";
                chessArray[7][1] = "[ ♘ ]";
                chessArray[7][2] = "[|♗|]";
                chessArray[7][3] = " [ ♕ ]";
                chessArray[7][4] = "[|♔|]";
                chessArray[7][5] = " [ ♗ ]";
                chessArray[7][6] = " [|♘|]";
                chessArray[7][7] = "[ ♖]";
            }
        }
        printChess(chessArray);
    }
    public static void englishOpening(){
        String[][] chessArray = new String[8][8];
        int rows = chessArray.length;
        int cols = chessArray[0].length;
        int i,j = 0;
        System.out.println("\n" + "Let's begin the chess game ♟\uFE0F");
        for(i = 0 ; i < rows;i++){
            for(j = 0; j < cols-1; j+=2){
                chessArray[0][0] = " [ ♜ ]";    //https://emojipedia.org/black-large-square, https://www.namecheap.com/visual/font-generator/chess-symbols/
                chessArray[0][1] = " [|♞|]";
                chessArray[0][2] = "[ ♝ ]";
                chessArray[0][3] = "[|♛|]";
                chessArray[0][4] = "[ ♚ ]";
                chessArray[0][5] = " [|♝|]";
                chessArray[0][6] = " [ ♞ ]";
                chessArray[0][7] = "[|♜]";
                chessArray[1][0] = " [|♟ ]";
                chessArray[1][1] = " [♟ ]";
                chessArray[1][2] = " [|♟]";
                chessArray[1][3] = "[ ♟]";
                chessArray[1][4] = " [|♟|]";
                chessArray[1][5] = "[♟ ]";
                chessArray[1][6] = "  [| ♟ ]";
                chessArray[1][7] = "[♟]";
                chessArray[2][j+1] = " [|||]";
                chessArray[2][j] = " [   ]";
                chessArray[2][3] = " [|||]";
                chessArray[2][4] = " [  ]";
                chessArray[2][5] = " [|||]";
                chessArray[3][j] = " [|||]";
                chessArray[3][j+1] = " [   ]";
                chessArray[3][2] = " [|||]";
                chessArray[3][3] = " [  ]";
                chessArray[4][j+1] = " [|||]";
                chessArray[4][j] = " [   ]";
                chessArray[4][2] = " [ ♙ ]";
                chessArray[4][3] = " [|||]";
                chessArray[5][j] = " [|||]";
                chessArray[5][j+1] = " [   ]";
                chessArray[6][0] = " [♙ ]";
                chessArray[6][1] = " [|♙]";
                chessArray[6][2] = " [   ]";
                chessArray[6][3] = " [|♙|]";
                chessArray[6][4] = " [ ♙]";
                chessArray[6][5] = "  [|♙]";
                chessArray[6][6] = "   [♙ ]";
                chessArray[6][7] = " [|♙]";
                chessArray[7][0] = "[|♖|]";
                chessArray[7][1] = "[ ♘ ]";
                chessArray[7][2] = "[|♗|]";
                chessArray[7][3] = " [ ♕ ]";
                chessArray[7][4] = "[|♔|]";
                chessArray[7][5] = " [ ♗ ]";
                chessArray[7][6] = " [|♘|]";
                chessArray[7][7] = "[ ♖]";
            }
        }
        printChess(chessArray);
    }
    public static void retiOpening(){
        String[][] chessArray = new String[8][8];
        int rows = chessArray.length;
        int cols = chessArray[0].length;
        int i,j = 0;
        System.out.println("\n" + "Let's begin the chess game ♟\uFE0F");
        for(i = 0 ; i < rows;i++){
            for(j = 0; j < cols-1; j+=2){
                chessArray[0][0] = " [ ♜ ]";    //https://emojipedia.org/black-large-square, https://www.namecheap.com/visual/font-generator/chess-symbols/
                chessArray[0][1] = " [|♞|]";
                chessArray[0][2] = "[ ♝ ]";
                chessArray[0][3] = "[|♛|]";
                chessArray[0][4] = "[ ♚ ]";
                chessArray[0][5] = " [|♝|]";
                chessArray[0][6] = " [ ♞ ]";
                chessArray[0][7] = "[|♜]";
                chessArray[1][0] = " [|♟ ]";
                chessArray[1][1] = " [♟ ]";
                chessArray[1][2] = " [|♟]";
                chessArray[1][3] = "[ ♟]";
                chessArray[1][4] = " [|♟|]";
                chessArray[1][5] = "[♟ ]";
                chessArray[1][6] = "  [| ♟ ]";
                chessArray[1][7] = "[♟]";
                chessArray[2][j+1] = " [|||]";
                chessArray[2][j] = " [   ]";
                chessArray[2][3] = " [|||]";
                chessArray[2][4] = " [  ]";
                chessArray[2][5] = " [|||]";
                chessArray[3][j] = " [|||]";
                chessArray[3][j+1] = " [   ]";
                chessArray[3][2] = " [|||]";
                chessArray[3][3] = " [  ]";
                chessArray[4][j+1] = " [|||]";
                chessArray[4][j] = " [   ]";
                chessArray[4][2] = " [  ]";
                chessArray[4][3] = " [|||]";
                chessArray[5][j] = " [|||]";
                chessArray[5][j+1] = " [   ]";
                chessArray[5][5] = " [ ♘]";
                chessArray[6][0] = " [♙ ]";
                chessArray[6][1] = " [|♙]";
                chessArray[6][2] = " [ ♙ ]";
                chessArray[6][3] = " [|♙|]";
                chessArray[6][4] = " [ ♙]";
                chessArray[6][5] = "  [|♙]";
                chessArray[6][6] = "   [♙ ]";
                chessArray[6][7] = " [|♙]";
                chessArray[7][0] = "[|♖|]";
                chessArray[7][1] = "[ ♘ ]";
                chessArray[7][2] = "[|♗|]";
                chessArray[7][3] = " [ ♕ ]";
                chessArray[7][4] = "[|♔|]";
                chessArray[7][5] = " [ ♗ ]";
                chessArray[7][6] = " [|||]";
                chessArray[7][7] = "[ ♖]";
            }
        }
        printChess(chessArray);
    }
    public static void chessGame(){
        String[][] chessArray = new String[8][8];
        int rows = chessArray.length;
        int cols = chessArray[0].length;
        int i,j = 0;
        System.out.println();
        System.out.println("Welcome to your chess Game! " + "\n");
        for(i = 0 ; i < rows;i++){
            for(j = 0; j < cols-1; j+=2){
                chessArray[0][j+1] = " [|||]";    //https://emojipedia.org/black-large-square
                chessArray[0][j] = " [   ]";
                chessArray[1][j] = " [|||]";
                chessArray[1][j+1] = " [   ]";
                chessArray[2][j+1] = " [|||]";
                chessArray[2][j] = " [   ]";
                chessArray[3][j] = " [|||]";
                chessArray[3][j+1] = " [   ]";
                chessArray[4][j+1] = " [|||]";
                chessArray[4][j] = " [   ]";
                chessArray[5][j] = " [|||]";
                chessArray[5][j+1] = " [   ]";
                chessArray[6][j+1] = " [|||]";
                chessArray[6][j] = " [   ]";
                chessArray[7][j] = " [|||]";
                chessArray[7][j+1] = " [   ]";
            }
        }
        printChess(chessArray);
        System.out.println();
        setChessPieces(chessArray);
    }

    public static void main(String[] args) {
        String chess = "CHESSMASTER";
        String mindB = "MINDBLOWING";
        Scanner sc = new Scanner(System.in);
        char userInput = ' ';
        fillRandom(chess);
        System.out.println();
        fillRandomMind(mindB);
        System.out.println();
        System.out.println();
        fillRandomExtraV();
        System.out.println();
        chessGame();
        System.out.println();



        do{
            System.out.println();
            System.out.println("Please type backspace (or first Letter of famous strategies...r(RuyLopez), i (Italian Game), s (Sicilian Defense), f (French Defense), c (Caro Kann Def.), p (Pirc-Def.), q (Queen's Gmabit), I (Indian Def.), e (English Opening), R (Reti Opening) to proceed with all chess strategies! Press escape (or x) for leaving the program");
            System.out.println();
            userInput = sc.nextLine().charAt(0);
            if(userInput == 'r'){
                System.out.println("Ruy Lopez");
                ruyLopez();
            } else if (userInput == 'i'){
                System.out.println("Italian Game");
                italianGame();
            } else if(userInput == 's'){
                System.out.println("Sicilian Defense");
                sicilianDefense();
            } else if(userInput == 'f'){
                System.out.println("French Defense");
                frenchDefense();
            } else if(userInput == 'c'){
                System.out.println("Caro-Kann Defense");
                caroKannDefense();
            } else if(userInput == 'p'){
                System.out.println("Pirc Defense");
                pircDefense();
            } else if (userInput == 'q'){
                System.out.println("Queen's Gambit");
                queensGambit();
            } else if(userInput == 'I'){
                System.out.println("Indian Defenses");
                indianDefenses();
            } else if(userInput == 'e'){
                System.out.println("English Opening");
                englishOpening();
            } else if(userInput == 'R'){
                System.out.println("Reti Opening");
                retiOpening();
            }
        } while (userInput != 'x');

        //TODO: rest of strategies with the same way as ruyLopez() but finding SPACE, ESC (maybe with Keylistener);
    }
}