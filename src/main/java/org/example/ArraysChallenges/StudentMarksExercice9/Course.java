package org.example.ArraysChallenges.StudentMarksExercice9;

public class Course {

    private String courseName;
    private double grade;

    public Course(String courseName) {
        this.courseName = courseName;
       // this.grade = grade;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
