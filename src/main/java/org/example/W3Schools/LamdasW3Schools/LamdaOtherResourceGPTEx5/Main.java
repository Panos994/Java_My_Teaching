package org.example.W3Schools.LamdasW3Schools.LamdaOtherResourceGPTEx5;

import org.openqa.selenium.devtools.v85.profiler.model.FunctionCoverage;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Maria", 19, 900),
                new Person("Nikos", 22, 1200),
                new Person("Eleni", 30, 2000),
                new Person("Giorgos", 22, 1100),
                new Person("Anna", 40, 2500)
        );

        Predicate<Person> isAdult = person -> {
            if(person.age >= 21){
                System.out.println(person.name + " is an adult.");
                return true;
            }
            return false;
        };
        Predicate<Person> isAdultGentle = p -> p.getAge() >= 21;


        Function<Person, String> nameAndSal = p -> {
            return p.name + " earns " + p.salary + " euros.";
        };
        Function<Person, String> nameAndSalGentle =
                p -> p.getName() + " earns " + p.getSalary() + " euros.";

        List<Person> sorted = new ArrayList<>(people);
        sorted.sort(Comparator.comparing(Person::getAge).thenComparing(Comparator.comparing(Person::getSalary)).reversed());

        System.out.println("Sorted:");
        sorted.forEach(System.out::println);

        System.out.println("\nAdults only:");
        filterPeople(sorted, isAdult).forEach(System.out::println);

        System.out.println("\nName and salary strings:");
        sorted.forEach(p -> System.out.println(nameAndSal.apply(p)));
    }


    public static List<Person> filterPeople(List<Person> list, Predicate<Person> rule){
        List<Person> out = new ArrayList<>();
        for (Person p : list) {
            if (rule.test(p)) out.add(p);
        }
        return out;
    }
}
