package org.example.W3Schools.JavaSmallProjectAndEx.ExX14;

import org.apache.commons.compress.utils.OsgiUtils;

public class SchoolRunner {
    public static void main(String[] args) {
        School sc = new School();
        Student st1 = new Student("Giorgos Papamelos", 21);
        Student st2 = new Student("Giorgos Stanley", 21);
        Student st3 = new Student("Giorger Byron", 21);
        Student st4 = new Student("Zaxarias Papamelos", 21);
        Student st5 = new Student("Vil Val Holdem", 22);
        Student st6 = new Student("Kirs Papakiouris", 26);

        Teacher tc1 = new Teacher("Maria Papamelou", "Applied Calculus");
        Teacher tc2 = new Teacher("Sergio Caht", "Java Programming 1");
        Teacher tc3 = new Teacher("Sullivan Caht", "Python Programming 1");

        SchoolClass sc1 = new SchoolClass("Applied Calculus", tc1);
        SchoolClass sc2 = new SchoolClass("Java Programming 1", tc2);
        SchoolClass sc3 = new SchoolClass("Python Programming 1", tc3);

        sc1.addStud((st1));
        sc1.addStud(st2);
        sc1.addStud(st3);
        sc1.addStud(st4);
        sc1.removeStud(st5);

        sc2.addStud(st4);

        sc.addStudent(st1);
        sc.addStudent(st2);
        sc.addStudent(st3);
        sc.addStudent(st4);

        System.out.println(sc1);
        System.out.println("Number of students " + sc.getStudents().size());
        System.out.println("Number of teachers " + sc.getTeachers().size());
        System.out.println("Number of classes " + sc.getClasses().size());

        System.out.println("Class name " + sc1.getClassName());
        System.out.println("Teacher: " + sc1.getTeacher().getName());
        System.out.println("Number of studetns " + sc1.getStudents().size());

        System.out.println("Number of students " + sc.getStudents().size());
    }
}
