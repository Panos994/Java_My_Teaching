package org.example.W3Schools.JavaSmallProjectAndEx.Ex15;

public class CourseSubject {
    private String subject;
    private int grade;

    public CourseSubject(String subject, int grade){
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
