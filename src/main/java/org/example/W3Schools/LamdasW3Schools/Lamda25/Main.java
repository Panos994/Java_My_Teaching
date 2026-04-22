package org.example.W3Schools.LamdasW3Schools.Lamda25;

import org.apache.commons.io.filefilter.SymbolicLinkFileFilter;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        //convert integer to binary with lamda
        Function<Integer, String> convertIntToBinary = (n) -> {
            return Integer.toBinaryString(n);
        };
        String binRepresentation = convertIntToBinary.apply(10);
        System.out.println("Binary representation of 10 is: " + binRepresentation);
    }
}
