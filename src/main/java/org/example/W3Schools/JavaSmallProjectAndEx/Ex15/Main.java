package org.example.W3Schools.JavaSmallProjectAndEx.Ex15;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<CourseSubject> ramsheeCourseSubject = List.of(new CourseSubject("English", 90), new CourseSubject("Science", 80));
        Student ramshee = new Student("Ramshee");
        ramshee.setSubjectList(ramsheeCourseSubject);

        System.out.println(ramshee.getName() + " has an average score of " + ramshee.calcAverageGrade());

        ramshee.validateResults();

    }

}
