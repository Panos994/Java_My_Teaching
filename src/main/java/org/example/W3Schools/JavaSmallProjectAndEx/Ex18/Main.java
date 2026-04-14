package org.example.W3Schools.JavaSmallProjectAndEx.Ex18;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Set an alarm time in format HH:mm (24-hour format): ");
        String alarmTime = sc.nextLine();
        System.out.println("enter alarm message: ");
        String alarmMsg = sc.nextLine();
        if(alarmMsg.isEmpty()){
            alarmMsg = "Wake up";
        }
        scheduleAlarm(alarmTime, alarmMsg);
        sc.close();
    }

    public static void scheduleAlarm(String alarmTime, String alarmMsg){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Alarm: " + alarmMsg);
                timer.cancel();
            }
        };
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
            Date alarmDate = dateFormat.parse(alarmTime);
            System.out.println("Alarm set for: " + alarmTime);
            timer.schedule(task, alarmDate);
        } catch(Exception e){
            System.out.println("Invalid time format. Please use HH:mm.");
        }
    }
}
