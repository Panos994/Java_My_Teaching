package org.example.W3Schools.JavaSmallProjectAndEx.ExX13;

public class Main {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addProduct(new Product("Tablet", 3));
        inv.addProduct(new Product("SmartPhone", 111));
        inv.addProduct(new Product("Tablet", 15));
        inv.addProduct(new Product("SmartPhone", 111));

        inv.removeProductByName("Mousepad");

        inv.printLowInventory(5);



    }
}
