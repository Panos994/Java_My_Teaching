package BuilderPattern;

public class ProductTest {
    public static void main(String[] args){

        //uc1: only mandatory fields:
        Product product1 = new Product.ProductBuilder("Laptop Apple MacBook", 1600).build();
        System.out.println(product1);
        System.out.println(product1.getCategory());

        //use case2: mandatory + optional fields:
        Product product2 = new Product.ProductBuilder("Samsung Ultra S25+", 950)
                .setCategory("Mobiles").setDescription("New Samsung Model 9'' screen")
                .setDiscount(10)
                .setFreeShipping(false)
                .setStock(100)
                .build();
        System.out.println(product2);

        product2.setDiscount(5);
        System.out.println(product2);

        //uc2:
        Product product3 = new Product.ProductBuilder("Tshirt Nike", 95).setCategory("Clothing").setFreeShipping(true).setStock(300).build();
        System.out.println(product3);
        product3.setDescription("XL size - black color - sports t-shirt");
        System.out.println(product3);

    }
}
