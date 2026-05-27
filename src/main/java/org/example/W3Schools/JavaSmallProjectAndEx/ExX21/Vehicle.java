package org.example.W3Schools.JavaSmallProjectAndEx.ExX21;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Vehicle {
    private String make;
    private String model;
    private int year;
}
