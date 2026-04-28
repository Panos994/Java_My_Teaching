package org.example.W3Schools.JavaSmallProjectAndEx.EXx1;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Tim",29);
        Person p2 = new Person("Simon", 20);

        p1.setName("Timothy");
        p1.setAge(30);
        p2.setName("Simone");
        p2.setAge(22);

        System.out.println(p1.getName() + " is " + p1.getAge() + " years old.");
        System.out.println(p2.getName() + " is " + p2.getAge() + " years old.");
    }
}
