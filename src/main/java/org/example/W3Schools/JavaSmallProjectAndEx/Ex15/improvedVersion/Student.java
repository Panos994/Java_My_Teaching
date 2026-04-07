package org.example.W3Schools.JavaSmallProjectAndEx.Ex15.improvedVersion;

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
        return subjectList.stream().mapToInt(CourseSubject::getGrade).average().orElse(0.0);
    }

    public void validateResults(){
        subjectList.forEach(sub -> {
            String res = sub.getGrade() < 60 ? "FAILED" : "PASSED";
            System.out.println(name + " " + res +" in "+ sub.getSubject() );
        });
    }

    public void addSubject(CourseSubject subject){
        subjectList.add(subject);
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
