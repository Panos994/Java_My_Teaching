package org.example.W3Schools.JavaSmallProjectAndEx.ExX10;

import org.checkerframework.checker.units.qual.C;

public class Main {
    public static void main(String[] args) {
        Student myStudent = new Student();
        Course courseHistory = new Course("History");
        Course coursePhysics = new Course("Physics");
        myStudent.addCourse(courseHistory);
        myStudent.addCourse(coursePhysics);

        myStudent.removeCourse(coursePhysics);

        for(Course c : myStudent.getCourses()){
            System.out.println(c.getTitle());
        }
    }
}
