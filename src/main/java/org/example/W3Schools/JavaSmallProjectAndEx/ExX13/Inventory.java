package org.example.W3Schools.JavaSmallProjectAndEx.ExX13;

import org.example.W3Schools.JavaSmallProjectAndEx.ExX13.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Inventory {
    private List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        if(product == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        if(product.getName() == null || product.getName().trim().isEmpty()){
            throw new IllegalArgumentException("product nam emust be not be blank");
        }
        if(product.getQuantity() < 0){
            throw new IllegalArgumentException("Product quantity cannot be negative");
        }
         products.add(product);
    }

    public boolean removeProductByName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("name must not be blank");

        return products.removeIf(p -> name.equalsIgnoreCase(p.getName()));
    }

    public List<Product> lowInventoryProducts(int threshold) {
        if (threshold < 0) throw new IllegalArgumentException("threshold must be >= 0");

        return products.stream()
                .filter(p -> p.getQuantity() <= threshold)
                .collect(Collectors.toList());
    }

    public void printLowInventory(int threshold){
        for(Product p : lowInventoryProducts(threshold)){
            System.out.println("Low inventory for product: " + p.getName() + " (qty=" +p.getQuantity() + ")");
        }
    }
}
