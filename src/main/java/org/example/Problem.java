package org.example;

public class Problem {
    private int problemId;
    private String description;

    private int grade;

    public Problem() {
        grade = 0;
    }

    public Problem(String description) {
        this.description = description;
        grade = 0; //αρχικοποίηση ότι δεν έχουμε βαθμολογήσει ακόμη κάτι για την μέθοδο updateGrade
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void updateGrade(int grade){
        if(grade > this.grade){
            //System.out.println(description + ": updated (" + this.grade + " --> " + grade + ")");
            this.grade = grade;
        }
    }
}
