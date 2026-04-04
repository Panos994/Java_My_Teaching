package org.example.W3Schools.JavaSmallProjectAndEx.Ex13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String myPassword = "aaabbbdf!33";
        passwordValidator(myPassword);
    }

    private static void passwordValidator(String myPassword){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter your password: ");
            myPassword = sc.nextLine();
        } while (myPassword.length() < 8
                || myPassword.contains(" ")
                || !(myPassword.matches(".*[A-Z].*")
                && myPassword.matches(".*[a-z].*")              && myPassword.matches(".*\\d.*")
                && myPassword.matches(".*[!@#$%^&*()].*")));;
    }
}
