package org.example.W3Schools.JavaSmallProjectAndEx.Ex15;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<CourseSubject> subjectList;


    public Student(String name) {
        this.name = name;
        subjectList = new ArrayList<>();
    }

    public  double calcAverageGrade(){
        if(subjectList.isEmpty()) return 0.0;
        int sum = 0;
        for(CourseSubject sub : subjectList){
            sum += sub.getGrade();
        }
        return (double) sum / subjectList.size();
    }

    public void validateResults(){
        for(CourseSubject sub : subjectList){
            if(sub.getGrade() < 60){
                System.out.println(this.name + "Failed in " + sub.getSubject());
            } else {
                System.out.println(this.name + "Passed in " + sub.getSubject());
            }

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseSubject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<CourseSubject> subjectList) {
        this.subjectList = subjectList;
    }
}
