package DecoratorPattern;

public class Main {
    public static void main(String[] args){

        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " and cost " + coffee.getCost());

        //add extra Milk
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " and cost " + coffee.getCost());

        //add extra sugar
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " and cost " + coffee.getCost());

        //add extra cream
        coffee = new CreamDecorator(coffee);
        System.out.println(coffee.getDescription() + " and total cost " + coffee.getCost());

    }
}
