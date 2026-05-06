package org.example.W3Schools.JavaSmallProjectAndEx.ExX6;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("John Doe", new BigDecimal(50000), "Java Developer");

        emp.calcSalary(emp.getName());
        System.out.println("Salary for emp: " +  emp.calcSalary(emp.getName()));

        emp.updateSal(670.0);
        System.out.println("Updated Salary for emp: " + emp.calcSalary(emp.getName()));
    }
}
