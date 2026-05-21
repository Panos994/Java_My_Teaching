package org.example.W3Schools.LamdasW3Schools.LamdaGPTOtherResourceEx1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("John", "Jane", "Jack", "Jill", "James","123$%"));
        Predicate<String> filteredNames = s->s.length() >=5 && !s.isEmpty() && Character.isUpperCase(s.charAt(0));
        System.out.println("Filtered Names: ");
        names.stream().filter(filteredNames).forEach(System.out::println);

    }
}
