package org.example.W3Schools.JavaSmallProjectAndEx.ExX9;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.A;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String name;
    private double salary;
    private LocalDateTime hireDate;

    public int getYearsOfService(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your starting year: ");
        int startYear = hireDate.getYear();
        int currentYear = LocalDateTime.now().getYear();

        return currentYear - startYear;
    }
}
