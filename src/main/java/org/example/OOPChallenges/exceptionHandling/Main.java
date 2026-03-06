package org.example.OOPChallenges.exceptionHandling;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie"};
        File file = new File("output.txt");
        try(FileWriter fileWriter = new FileWriter(file);){
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(String name : names){
                printWriter.println(name);
            }
            System.out.println("Names written to file successfully.");
        } catch(IOException e){
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
