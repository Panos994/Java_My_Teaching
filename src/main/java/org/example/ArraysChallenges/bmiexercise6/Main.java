package org.example.ArraysChallenges.bmiexercise6;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> team = List.of(new Person("Takis",1.90, 86.5), new Person("Georgia",1.70, 60.5), new Person("Vasilis",1.89,90.1));

        for(Person person : team){
            System.out.println(person.toString());
        }
    }



}
