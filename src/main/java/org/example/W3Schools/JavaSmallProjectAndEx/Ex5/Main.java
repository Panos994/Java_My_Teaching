package org.example.W3Schools.JavaSmallProjectAndEx.Ex5;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {// again
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[3][3];
        int row = arr.length;
        int cols = arr[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < cols; j++){
                arr[i][j] = '-';
            }
        }
        printDashTicTacToeDashboard(arr);

        System.out.println("Let's start the game!");
        System.out.println("Please choose where do you want to place your character (X or O)");

        char player1Option; //sc.next().charAt(0);
        char player2Option; //(player1Option == 'X') ? 'O' : 'X';

        do{
            player1Option = sc.next().toUpperCase().charAt(0);
            player2Option = (player1Option == 'X') ? 'O' : 'X';
            if(player1Option != 'X' && player1Option != '0'){
                System.out.println("Please choose either X or O");
            }
        } while(player1Option != 'X' && player2Option != 'O');

        boolean player1Turn = true;
        int moves = 0;
        while(moves < 9){
            printDashTicTacToeDashboard(arr);
            if(player1Turn){
                System.out.println("Player 1 please etner row and column: ");
            } else {
                System.out.println("Player 2 please etner row and column: ");
            }

            int r = sc.nextInt();
            int c = sc.nextInt();

            if(r < 0 || c >= 3 || c < 0 || c>=3){
                System.out.println("invalid position. try again!!!");
                continue;
            }

            if(arr[r][c] != '-'){
                System.out.println("position already taken. try again!!");
                continue;
            }

            arr[r][c] = player1Turn ? player1Option : player2Option;
            moves++;
            if(checkWin(arr,player1Turn ? player1Option : player2Option)){
                printDashTicTacToeDashboard(arr);
                System.out.println("Player " + (player1Turn ? "1" : "2") + " won!");
                return;
            }

            player1Turn = !player1Turn;
        }
        printDashTicTacToeDashboard(arr);
        System.out.println("It's a draw");
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < cols; j++) {
//                System.out.println("Player 1, please enter the row and column number to place your " + player1Option);
//                int player1Row = sc.nextInt();
//                int player1Col = sc.nextInt();
//                arr[player1Row][player1Col] = player1Option;
//                printDashTicTacToeDashboard(arr);
//
//                System.out.println("Player 2, please enter the row and column number to place your " + player2Option);
//                int player2Row = sc.nextInt();
//                int player2Col = sc.nextInt();
//                arr[player2Row][player2Col] = player2Option;
//                printDashTicTacToeDashboard(arr);
//
//                if ((arr[i][0] == 'X' && arr[i][1] == 'X' && arr[i][2] == 'X') ||
//                        (arr[0][j] == 'X' && arr[1][j] == 'X' && arr[2][j] == 'X') ||
//                        (arr[0][0] == 'X' && arr[1][1] == 'X' && arr[2][2] == 'X') ||
//                        (arr[0][2] == 'X' && arr[1][1] == 'X' && arr[2][0] == 'X')) {
//                    System.out.println("Player 1 wins!");
//                    return;
//                } else if (
//                        (arr[0][j] == 'O' && arr[1][j] == 'O' && arr[2][j] == 'O') ||
//                                (arr[i][0] == 'O' && arr[i][1] == 'O' && arr[i][2] == 'O') ||
//                                (arr[0][0] == 'O' && arr[1][1] == 'O' && arr[2][2] == 'O') ||
//                                (arr[0][2] == 'O' && arr[1][1] == 'O' && arr[2][0] == 'O')) {
//                    System.out.println("Player 2 wins!");
//                    return;
//                }
//            }
//        }


    }

    public static boolean checkWin(char[][] arr, char player){
        for(int i = 0; i < 3; i++){
            // Έλεγχος γραμμών
            if(arr[i][0]==player && arr[i][1] == player && arr[i][2] == player){
                return true;
            }
            if(arr[0][i]==player && arr[1][i] == player && arr[2][i] == player){
                return true;
            }
        }
        if(arr[0][0] == player && arr[1][1] == player && arr[2][2] == player) return true;
        if(arr[2][0] == player && arr[1][1] == player && arr[0][2] == player) return true;

        return false;

    }

    public static void printDashTicTacToeDashboard(char[][] arr) {
        int row = arr.length;
        int cols = arr[0].length;
        System.out.println("\nTic Tac Toe Dashboard: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
//                System.out.print(arr[i][j] + " ");
//                if (arr[i][j] == 0) {
//                    arr[i][j] = '-';
//                } else if (arr[i][j] == 1) {
//                    arr[i][j] = 'X';
//                } else if (arr[i][j] == 2) {
//                    arr[i][j] = 'O';
//                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
