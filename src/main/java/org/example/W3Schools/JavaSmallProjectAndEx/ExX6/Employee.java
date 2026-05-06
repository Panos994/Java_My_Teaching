package org.example.W3Schools.JavaSmallProjectAndEx.ExX6;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class Employee {
    private String name;
    private String jobTitle;
    private BigDecimal salary;
    private final static double governmentCommisions = 0.2;

    public Employee(String name, BigDecimal salary, String jobTitle) {
        this.name = name;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    public double calcSalary(String name){
        if(name.equals(this.name)){
            return salary.doubleValue() - (salary.doubleValue() * governmentCommisions);
        }
        return -1;
    }

    public double updateSal(double salInc){
        if (salInc < 0) return -1;
        this.salary = this.salary.add(BigDecimal.valueOf(salInc));
        return this.salary.doubleValue();
    }


}
