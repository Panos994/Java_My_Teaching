package org.example.W3Schools.JavaSmallProjectAndEx.ExX9;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("Valisits",25000, LocalDateTime.of(2022, 3, 15, 9, 30));
        System.out.println("Years of service are: " + emp.getYearsOfService());
    }
}
