package org.example.W3Schools.JavaSmallProjectAndEx.ExX29;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Pet {
    private String name;
    private List<Specie> species;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.species = new ArrayList<>();
        this.age = age;
    }

    public void displayPetDetails(){
        System.out.printf("%s - %s %n",name,age);
    }

    public double petsAge(LocalDateTime birthDate){
        int birthYear  = birthDate.getYear();
        int currentYear = LocalDateTime.now().getYear();
        int petAge = currentYear - birthYear;
        if(this instanceof Dog){
            return petAge * 7;
        } else if (this instanceof Bird){
            return petAge * 5;
        } else {
            return petAge;
        }
    }
    public void addSpecie(Specie specie){
        species.add(specie);
    }
}
