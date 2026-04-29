package org.example.W3Schools.StreamsW3Schools.StreamOtherResouceGPTExX2;



import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Maria", 19, 900),
                new Person("Nikos", 22, 1200),
                new Person("Eleni", 30, 2000),
                new Person("Giorgos", 22, 1100),
                new Person("Anna", 40, 2500)
        );

        List<String> filter = people.stream().filter(p -> p.getSalary() >= 1200).map(Person::getName).sorted().toList();

        double avgSal = people.stream().mapToDouble(Person::getSalary).average().orElse(0);

        Map<Integer, Double> avgSalByAge = people.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.averagingDouble(Person::getSalary)));

        String bestPaidName =
                people.stream()
                        .max(Comparator.comparingDouble(Person::getSalary))
                        .map(Person::getName)
                        .orElse("N/A");

        DoubleSummaryStatistics stats =
                people.stream()
                        .collect(Collectors.summarizingDouble(Person::getSalary));

        System.out.println("Names with salary >= 1200: " + filter);
        System.out.println("Average salary: " + avgSal);

        System.out.println("Avg salary by age: " + avgSalByAge);
        System.out.println("Best paid: " + bestPaidName);
        System.out.println("Stats: " + stats);
    }

}
