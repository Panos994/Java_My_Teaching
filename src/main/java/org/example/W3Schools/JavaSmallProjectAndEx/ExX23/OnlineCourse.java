package org.example.W3Schools.JavaSmallProjectAndEx.ExX23;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OnlineCourse extends Course{
    private String platform;
    private int duration;

    public OnlineCourse(String courseName, String email, double credit, String platform, int duration) {
        super(courseName, email, credit);
        this.platform = platform;
        this.duration = duration;
    }

    public void displayCourseDetails(){
        System.out.printf("%s | %s | %.2f | %s | %d%n",getCourseName(), getEmail(), getCredit(), platform, duration);
    }

    public void checkEligibilityByDuration(){
        if(duration > 15) { // if is more than 15 hours eligible for certificate
            System.out.println("Eligible for certificate");
        } else {
            System.out.println("Not eligible for certificate");
         }
    }
}
