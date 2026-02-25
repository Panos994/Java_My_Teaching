package org.example.ArraysChallenges.StudentMarksExercice9;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private double gradePhysics;
    private double gradeChem;
    private double gradeMaths;
    private List<Course> courseList;

    public Student(String name, double gradePhysics, double gradeChem, double gradeMaths) {
        this.name = name;
        this.gradePhysics = gradePhysics;
        this.gradeChem = gradeChem;
        this.gradeMaths = gradeMaths;
        this.courseList = new ArrayList<>();
    }

    public void addCourse(Course course){
        courseList.add(course);
    }
    public double calcPe(){
        return (gradePhysics + gradeChem + gradeMaths) / 3.0;

    }

    public String convertToGrade(double score){
        if(score >= 90) return "A+";
        if(score >= 80) return "B+";
        if(score >= 70) return "C+";
        return "Failed";

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void display() {
        System.out.println("Grades for student: " + name);
        System.out.println("Percentage : " + String.format("%.2f",calcPe()) + " %");
        for(Course course : courseList){
            double currentGrade = 0;
            if(course.getCourseName().equals("Physics")){
                currentGrade = gradePhysics;
            } else if(course.getCourseName().equals("Chemistry")){
                currentGrade = gradeChem;
            } else if(course.getCourseName().equals("Maths")){
                currentGrade = gradeMaths;
            }
            System.out.println("Course " + course.getCourseName() + " | Grade " + convertToGrade(currentGrade));
        }
    }
}
