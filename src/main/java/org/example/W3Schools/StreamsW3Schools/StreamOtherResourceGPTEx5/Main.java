package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person(15,"John"), new Person(30,"Aane"), new Person(20,"Jack"), new Person(35,"Bill"));
        List<Person> persons18andAbove = persons.stream().filter(p -> p.getAge() >= 18).collect(Collectors.toList());
        persons18andAbove.stream().sorted(Comparator.comparing(Person::getName)).forEach(p -> System.out.println(p.getName()));

        //more gentle
        persons.stream()
                .filter(p -> p.getAge() >= 18)
                .sorted(Comparator.comparing(Person::getName))
                .map(Person::getName)
                .forEach(System.out::println);
    }
}
