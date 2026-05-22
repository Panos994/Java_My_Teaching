package org.example.W3Schools.JavaSmallProjectAndEx.ExX18;

public class Runner {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        restaurant.addItem(new MenuItem("Burger", 5.99));
        restaurant.addItem(new MenuItem("Pizza", 8.99));
        restaurant.addItem(new MenuItem("Salad", 4.99));
        restaurant.removeItem("Pizza");
        System.out.println(restaurant);
        System.out.println("Items: \n");
        System.out.println(restaurant.getItems());
        restaurant.addRating(new Rating(4));
        restaurant.addRating(new Rating(5));
        System.out.println(restaurant.getRatings());

        System.out.println(restaurant.avgRating());
    }
}
