package ComparatorLearning;

import java.util.*;
import java.util.stream.Collectors;

public class ComparatorStreamsSorting {
    public static void main(String[] args){
        //  Άσκηση: Comparable (Φυσική Ταξινόμηση)
        Employee em1 = new Employee(130,"Τάκης");
        Employee em2 = new Employee(2, "Μαρία");
        Employee em3 = new Employee(3,"Κυριάκος");
        List<Employee> employees = new ArrayList<>();
        employees.add(em1);
        employees.add(em2);
        employees.add(em3);
        Collections.sort(employees);
        for(Employee em : employees){
            System.out.println(em.getId() + " is employee with name " + em.getName());
        }

        //  Άσκηση: Comparator (Πολλαπλά Κριτήρια)
        employees.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getId));
        System.out.println("------ SORTED BY NAME AND IF SAME NAME THEN SORTED WITH ID");
        for(Employee em : employees){
            System.out.println("id is: " + em.getId() + " amd Name " + em.getName());
        }



        // Άσκηση: Stream API & Sorting
        System.out.println("------ STREAM API -------");
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1200),
                new Product("Mouse", 25),
                new Product("Monitor", 200)
        );

        List<Product> result = products.stream()
                .filter(p -> p.getPrice() > 50)
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());

        result.forEach(p-> System.out.println(p.getName() + ": " + p.getPrice()));

    }



}
