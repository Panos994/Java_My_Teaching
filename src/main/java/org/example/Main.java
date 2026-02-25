package org.example;
public class Main extends ResistorCalculation{
    public static void main(String[] args) {
        System.out.println("Welcome to your personal resistor calculator of Ω");
        ResistorCalculation.displayValuesAcronyms();
        System.out.println("----------------" + "\n");
        ResistorCalculation.displayColourAcronyms();
        System.out.println("----------------" + "\n");
        System.out.println("Please give the number of colours (4 or 5 Acronyms) as you see above: ");
        ResistorCalculation.calculateResistor();
    }
}
