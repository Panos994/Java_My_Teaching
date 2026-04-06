package org.example.W3Schools.JavaSmallProjectAndEx.Ex14;

public class Client {
    private static int CLIENT_ID = 100;
    private String name;

    private double balance;

    public Client( String name, double balance) {
        this.CLIENT_ID = CLIENT_ID++;
        this.name = name;
        this.balance = Math.random() * 10000;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double deposit(double amount){
        if(amount < 0){
            throw new IllegalArgumentException("Amount must be positive");
        }
        return this.balance + amount;
    }

    public double withdraw(double amount){
        if (amount < 0 || amount > balance) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        return this.balance + amount;
    }

    public void checkBalance(){
        System.out.println("Your balance is: " + this.balance);
    }
}
