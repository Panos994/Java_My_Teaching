package org.example.W3Schools.JavaSmallProjectAndEx.ExX8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrafficLight {
    private static final String RED = "RED";
    private static final String YELLOW = "YELLOW";
    private static final String GREEN = "GREEN";

    private String color;
    private int duration;

    public boolean changeColor(String newColor) {
        String normalizedColor = normalizeColor(newColor);

        if (!isValidColor(normalizedColor)) {
            return false;
        }

        this.color = normalizedColor;
        return true;
    }

    public boolean isRed() {
        return RED.equals(normalizeColor(this.color));
    }

    public boolean isGreen() {
        return GREEN.equals(normalizeColor(this.color));
    }


    private boolean isValidColor(String color) {
        return RED.equals(color) || YELLOW.equals(color) || GREEN.equals(color);
    }

    private String normalizeColor(String color) {
        return color == null ? "" : color.trim().toUpperCase();
    }


}
