package org.example.W3Schools.LamdasW3Schools.Lamda20;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> sortPersonAttr = new java.util.ArrayList<>(List.of(new Person("John Michelas", 21), new Person("Alex Sindalis", 20), new Person("Jason Vigon", 26)));
        sortPersonAttr.sort((p1,p2) ->p1.getAge() - p2.getAge());
        System.out.println(sortPersonAttr);
        for(Person per : sortPersonAttr){
            System.out.println(per.getName() + " is " + per.getAge() + " years old");
        }

        sortPersonAttr.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getName));
        for(Person per : sortPersonAttr){
            System.out.println(per.getName() + " is " + per.getAge() + " years old");
        }
    }
}
