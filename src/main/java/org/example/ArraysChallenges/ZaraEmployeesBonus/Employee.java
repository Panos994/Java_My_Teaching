package org.example.ArraysChallenges.ZaraEmployeesBonus;

public class Employee {

    private int salary;
    private int yearsOfService;
    private int bonus;

    public Employee(int salary, int yearsOfService, int bonus) {
        this.salary = salary;
        this.yearsOfService = yearsOfService;
        this.bonus = bonus;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
