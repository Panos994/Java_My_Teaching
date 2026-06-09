package org.example.W3Schools.JavaSmallProjectAndEx.ExX29;

import java.time.LocalDateTime;

public class RunnerC {
    public static void main(String[] args) {

        Dog d = new Dog("Judy",5,"Water Gun");

        Bird bi = new Bird("Knicki",2,"Big Wings");

        Specie sc1 = new Specie("mammal+1");
        Specie sc2 = new Specie("Birds+1");

        d.addSpecie(sc1);
        bi.addSpecie(sc2);
        Pet p = new Pet();
        System.out.println("We have these species at the moment: ");
        System.out.println(d.getSpecies());
        System.out.println(bi.getSpecies());

        d.displayPetDetails();
        bi.displayPetDetails();

        System.out.println(d.petsAge(LocalDateTime.of(2020, 5,1,2,3)));
        System.out.println(bi.petsAge(LocalDateTime.of(2020, 5,1,2,3)));
    }
}
