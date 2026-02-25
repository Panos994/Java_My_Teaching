package org.example.ArraysChallenges.StudentMarksExercice9;

import org.checkerframework.checker.units.qual.C;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Εισάγετε πόσα άτομα θέλετε: ");
        int numPersons = sc.nextInt(); //θα βαλω 3
        double[][] data = new double[numPersons][3];

        String[] names = new String[numPersons];
        Student[] students = new Student[numPersons];
        for(int i = 0; i < numPersons;i++){
            System.out.println("\n Εισαγωγή στοιχείων για: " + (i + 1) + " : ");
            names[i] = sc.next();

            System.out.println("Please give Physics Grade: ");
            double gradePhysics = sc.nextDouble();
            System.out.println("Please give Chem101 Grade: ");
            double gradeChem = sc.nextDouble();
            System.out.println("Please give Maths Grade: ");
            double gradeMaths = sc.nextDouble();

            System.out.println("Marks of physics please enter: ");
            data[i][0] = gradePhysics;
            data[i][1] = gradeChem;
            data[i][2] = gradeMaths;

            students[i] = new Student(names[i], gradePhysics, gradeChem, gradeMaths);

            students[i].addCourse(new Course("Physics"));
            students[i].addCourse(new Course("Chem101"));
            students[i].addCourse(new Course("Maths101"));


        }
        for(int i = 0; i < numPersons; i++){
            students[i].display();
        }
    }

    public static String convertToGrade(double score) {
        if (score >= 90) return "A+";
        if (score >= 80) return "B+"; // Εδώ είχες παντού 90 πριν!
        if (score >= 70) return "C+";
        return "Failed";
    }
}
