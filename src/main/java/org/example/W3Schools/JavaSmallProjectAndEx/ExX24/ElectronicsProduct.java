package org.example.W3Schools.JavaSmallProjectAndEx.ExX24;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ElectronicsProduct {
    private static final double DISCOUNT = 0.3;
    private static int lastId = 1;
    private int productId;
    private String name;
    private double price;

    public ElectronicsProduct(String name, double price) {
        this.productId = lastId++;
        this.name = name;
        this.price = price;
    }

    public void applyDiscount(){
        price = price - (price * DISCOUNT);

    }
    public double getFinalPrice(){
       return price;
    }
}
