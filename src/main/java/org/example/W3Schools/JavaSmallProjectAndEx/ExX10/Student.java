package org.example.W3Schools.JavaSmallProjectAndEx.ExX10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@NoArgsConstructor
public class Student {
    private String name;
    private int grade;
    private List<Course> courses = new ArrayList<>();

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;

    }

    public void addCourse(Course course){
        if(course.getTitle() == null || course.getTitle().isEmpty()){
            System.out.println("Course title cannot be empty.");
            return;
        }
        this.courses.add(course);
    }

    public void removeCourse(Course course){
        if(course.getTitle() == null || course.getTitle().isEmpty()){
            System.out.println("Course title cannot be empty.");
            return;
        }
        this.courses.remove(course);
    }
}
