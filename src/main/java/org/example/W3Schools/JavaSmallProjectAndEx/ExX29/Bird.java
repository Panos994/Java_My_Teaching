package org.example.W3Schools.JavaSmallProjectAndEx.ExX29;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Bird extends Pet{
    private String wingSpan;

    public Bird(String name, int age, String wingSpan) {
        super(name, age);
        this.wingSpan = wingSpan;
    }

    @Override
    public void displayPetDetails() {
        super.displayPetDetails();
        System.out.println("Bird also has wingSpan --> " + wingSpan);
    }
}
