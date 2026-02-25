package org.example.ArraysChallenges.ZaraEmployeesBonus;

import java.util.*;

public class Exercice1 {
    public static void main(String[] args) {
        HashMap<String, Employee> employeeBonusMap = new HashMap<>();
        Exercice1.initEmployeesAndBonus(employeeBonusMap);
    }
    public static void initEmployeesAndBonus(HashMap<String, Employee> employeeBonusMap) {
        ArrayList<String> names = new ArrayList<>(List.of("Jade Jones", "Vasilis Gakoumakis", "Zachos Zazopoulos", "Sisi Chatzi", "Giorgos Pappas", "Vasilis Epenos", "Dimitis Kreourgis", "John Dones",
                "Kiriakos Vasil", "Leuteris Zatsas"));
        Random rand = new Random();
        Collections.shuffle(names);
        int yearsOfService = 0;
        int bonusRand = 0;
        for (int i = 0; i < 10; i++) {
            yearsOfService = rand.nextInt(45);
            //int tempName = rand.nextInt(0, names.size()); αντι για αυτο καλυτερα να κανω shuffle την List για ανακατεμα επειδη το HashMap οταν κανω rand.nextInt μεσα σε loop επιλεγει το ιδιο ονομα και κανει απλα overwrite
            int tempSalary = rand.nextInt(0, 2000);

            bonusRand = 0;
            if(yearsOfService > 5){
                bonusRand = rand.nextInt(0, 1000);
            }
            employeeBonusMap.put(names.get(i), new Employee(tempSalary, yearsOfService,bonusRand));
        }

        System.out.printf("%-20s | %-15s | %-15s | %-15s%n","Employees","Base Salary","Salary With Bonus","Years of Service");
        System.out.println("-".repeat(80));
        int salaryWithBonus = 0;
        int totalZaraPayment = 0;

        for (Map.Entry<String, Employee> entry : employeeBonusMap.entrySet()) {
            Employee emp = entry.getValue();

             salaryWithBonus = emp.getSalary() + emp.getBonus();
            System.out.printf("%-20s | %-15d | %-15d | %-15d%n",
                    entry.getKey(),
                    emp.getSalary(),
                    salaryWithBonus,
                    emp.getYearsOfService());
            totalZaraPayment += salaryWithBonus;
        }
        System.out.println("\nZara should pay total of salary with bonus: " + totalZaraPayment);
    }
}
