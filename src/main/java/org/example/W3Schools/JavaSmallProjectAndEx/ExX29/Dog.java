package org.example.W3Schools.JavaSmallProjectAndEx.ExX29;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Dog extends Pet{
    private String toy;

    public Dog(String name, int age, String toy) {
        super(name, age);
        this.toy = toy;
    }

    @Override
    public void displayPetDetails() {
        super.displayPetDetails();
        System.out.println("Favorite toy is: " + toy);
    }
}
