package org.example.W3Schools.JavaSmallProjectAndEx.Ex15.improvedVersion;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student ramshee = new Student("Ramshee");
        ramshee.addSubject(new CourseSubject("Math", 85));
        ramshee.addSubject(new CourseSubject("Chemistry", 85));
        ramshee.addSubject(new CourseSubject("English", 88));
        System.out.println(ramshee.getName() + " has an average score of " + ramshee.calcAverageGrade());

        ramshee.validateResults();

    }

}
