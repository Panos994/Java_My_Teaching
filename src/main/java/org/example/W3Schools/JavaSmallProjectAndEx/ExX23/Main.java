package org.example.W3Schools.JavaSmallProjectAndEx.ExX23;

public class Main {
    public static void main(String[] args) {
        OnlineCourse oncJava = new OnlineCourse("Java Programming", "jdoe@gmail.com", 3.5, "https://example.com/java-course",5);

        OnlineCourse oncMachineLearning = new OnlineCourse("MachineLearning3", "jdoe@gmail.com", 5, "https://example.com/java-course",16);

        OnlineCourse oncJava2 = new OnlineCourse("Java Programming 2", "jdoe@gmail.com", 3.5, "https://example.com/java-course",5);

        OnlineCourse oncJava3 = new OnlineCourse("Java Programming 3", "jdoe@gmail.com", 3.5, "https://example.com/java-course",5);


        oncMachineLearning.displayCourseDetails();
        oncMachineLearning.checkEligibilityByDuration();

    }
}
