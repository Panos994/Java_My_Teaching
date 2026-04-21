package org.example.W3Schools.JavaSmallProjectAndEx.Ex22;

import java.util.Scanner;

public class StopWatch {
    //stopwatch
    private long startTime;
    private long endTime;

    public void start(){
        startTime = System.currentTimeMillis();
        System.out.println("Stopwatch started...");
    }

    public void stop(){
        endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Stopwatch stopped.");
        System.out.println("Elapsed time: " + (elapsedTime/1000.0) + " milliseconds.");
    }
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        if(inp.equals("start")){
             stopWatch.start();
        }
        System.out.println("Enter 'stop' to stop the stopwatch.");
        inp = sc.nextLine();
        if(inp.equals("stop")){
            stopWatch.stop();
        } else {
            System.out.println("Invalid input. Please enter 'start' or 'stop'.");
        }

    }
}
