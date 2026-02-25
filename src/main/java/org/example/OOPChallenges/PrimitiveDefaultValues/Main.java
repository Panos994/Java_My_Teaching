package org.example.OOPChallenges.PrimitiveDefaultValues;

public class Main {

    /* Μια static μέθοδος μπορεί να δει μόνο static μεταβλητές.

Αν έβγαζες το static από τις μεταβλητές σου, η main θα σου πέταγε σφάλμα: "Non-static field cannot be referenced from a static context".

Χρησιμοποιώντας το static, οι μεταβλητές ανήκουν στην ίδια την κλάση Main και όχι σε κάποιο συγκεκριμένο αντικείμενο, οπότε η main μπορεί να τις "δει" και να τις εκτυπώσει αμέσως.*/
    static byte byteValue;
    static short shortValue;
    static int intValue;
    static long longValue;
    static float floatValue;
    static double doubleValue;
    static char charValue;
    static boolean booleanValue;
    static String stringValue;
    public static void main(String[] args) {
        System.out.println("Default values of primitive data types in Java:");
        System.out.println("byte: " + byteValue);
        System.out.println("short: " + shortValue);
        System.out.println("int: " + intValue);
        System.out.println("long: " + longValue);
        System.out.println("float: " + floatValue);
        System.out.println("double: " + doubleValue);
        System.out.println("char: '" + charValue + "'"); // Displays as a blank space
        System.out.println("boolean: " + booleanValue);
        System.out.println("String: " + stringValue);
    }
}
