package org.example.W3Schools.JavaSmallProjectAndEx.ExX14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class School {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<SchoolClass> classes;

    public School(){
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.classes = new ArrayList<>();
    }

    public void addStudent(Student st){
        students.add(st);
    }
    public void removeStudent(Student st){
        students.remove(st);
    }

    public void addTeacher(Teacher st){
        teachers.add(st);
    }

    public void removeTeacher(Teacher st){
        teachers.remove(st);
    }

    public void addClass(SchoolClass schoolClass){
        classes.add(schoolClass);
    }
    public void removeClass(SchoolClass schoolClass){
        classes.remove(schoolClass);
    }
    public void createClass(){
        System.out.println("Class "  + " created with " + students.size() + " students and " + teachers.size() + " teachers.");
    }

}
