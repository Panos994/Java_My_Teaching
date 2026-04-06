package org.example.W3Schools.JavaSmallProjectAndEx.Ex14;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Client> clientList = List.of(
                new Client("Alice", 3000), new Client("John",5000),new Client("Bill", 6000));

        for(var c : clientList){
            System.out.println(c.getName() + " deposits " + c.deposit(1000));
            System.out.println(c.getName() + " withdraws " + c.withdraw(500));
            System.out.println(c.getName() + " balance is " + c.getBalance());
        }

        //
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while(!exit){
            System.out.println("Enter command (1:deposit, 2: withdraw, 3: check balance, 4:exit)");

            int command = sc.nextInt();
            switch (command){
                case 1:
                    System.out.println("Enter deposit amount: ");
                    double deposit = sc.nextDouble();
                    clientList.get(0).deposit(deposit);
                    break;
                case 2:
                    System.out.println("Enter withdraw amount: ");
                    double withdraw = sc.nextDouble();
                    clientList.get(0).withdraw(withdraw);
                    break;
                case 3:
                    System.out.println("Balance: " + clientList.get(0).getBalance());
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
      sc.close();
    }


}
