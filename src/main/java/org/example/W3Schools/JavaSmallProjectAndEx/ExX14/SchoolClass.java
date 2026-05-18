package org.example.W3Schools.JavaSmallProjectAndEx.ExX14;

import com.beust.ah.A;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
@NoArgsConstructor
public class SchoolClass {
    private String className;
    private Teacher teacher;
    private ArrayList<Student> students;

    public SchoolClass(String className, Teacher teacher) {
        this.className = className;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }


    public void addStud(Student st){
        students.add(st);
    }
    public void removeStud(Student st){
        students.remove(st);
    }

    @Override
    public String toString() {
        return "SchoolClass{name='" + className + "', teacher=" + teacher.getName()
                + ", students=" + students.size() + "}";
    }
}
