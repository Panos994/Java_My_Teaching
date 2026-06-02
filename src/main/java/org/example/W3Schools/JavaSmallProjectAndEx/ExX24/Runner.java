package org.example.W3Schools.JavaSmallProjectAndEx.ExX24;

public class Runner {
    public static void main(String[] args) {
        ElectronicsProduct ep = new ElectronicsProduct("TV", 1000);
        ElectronicsProduct ep2 = new ElectronicsProduct("Tablet", 1500);

        ep.applyDiscount();
        System.out.println(ep.getPrice());
        ep2.applyDiscount();
        System.out.println(ep2.toString());
        System.out.println(ep2.getFinalPrice());

        WashingMachine wm = new WashingMachine("Apple",3000);

        wm.extendWarranty(3);
        System.out.println(wm.getWarrantyPeriod()); // Should print 3
    }

}
