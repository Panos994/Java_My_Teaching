package org.example.ArraysChallenges.StudentMarksExercise8;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Course physics = new Course("Physics");
        Course chemistry = new Course("Chemistry");
        Course maths = new Course("Maths");

        Student mohamed = new Student("Mohamed", 70,80,90);
        Student julia = new Student("Julia", 70,80,90);
        Student mono = new Student("Mono", 70,80,90);

        mohamed.addCourse(physics);
        mohamed.addCourse(chemistry);
        mohamed.addCourse(maths);
        mohamed.display();

    }
}
