package org.example.OOPChallenges.BuildInExceptionsHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JavaBuildInExceptions {
    public static void main(String[] args) {

        try{
            int rs = 10 / 0;
        } catch(ArithmeticException e){
            System.out.println("Cannot divide by zero: " + e.getMessage());
        }


        try {
            File file = new File("nonexistentfile.txt");
            try (PrintWriter printWriter = new PrintWriter(file)) {
                printWriter.println("Writing to file...");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception caught: " + e.getMessage());
        }
    }

}
