package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Ball b1 = new Ball("Blue", 1.5, MaterialBall.ELASTIC);
        b1.changeColorByMoreThanWeight("Yellow", 1.2);
        b1.printAll();
        System.out.println("\n");

        Box box1  = new Box(1.2, 1.3, 1.8, MaterialBox.PAPER, 0.3);
        Box box2  = new Box(2.2, 2.3, 2.5, MaterialBox.WOOD, 2.2);

        Ball red1 = new Ball("Red", 2.5, MaterialBall.METAL);
        Ball red2 = new Ball("Red", 2.5, MaterialBall.METAL);
        Ball red3 = new Ball("Red", 2.5, MaterialBall.METAL);

        Ball red4 = new Ball("Red", 1.5, MaterialBall.METAL);
        Ball red5 = new Ball("Red", 1.5, MaterialBall.METAL);

        Ball black6 = new Ball("Black", 0.5, MaterialBall.PLASTIC);
        Ball black7 = new Ball("Black", 0.5, MaterialBall.PLASTIC);
        Ball black8 = new Ball("Black", 0.5, MaterialBall.PLASTIC);
        Ball black9 = new Ball("Black", 0.5, MaterialBall.PLASTIC);
        Ball black10 = new Ball("Black", 0.5, MaterialBall.PLASTIC);

        Ball white11 = new Ball("White", 1.1, MaterialBall.ELASTIC);
        Ball white12 = new Ball("White", 1.1, MaterialBall.ELASTIC);
        Ball white13 = new Ball("White", 1.1, MaterialBall.ELASTIC);
        Ball white14 = new Ball("White", 1.1, MaterialBall.ELASTIC);
        Ball white15 = new Ball("White", 1.1, MaterialBall.ELASTIC);

        List<Ball> myBalls = new ArrayList<>(List.of(red1,red2,red3,red4,red5,black6, black7,black8,black9,black10, white11, white12,white13,white14,white15));
        for(Ball ball : myBalls){
            if(ball.getColor().equals("Red")){
                box2.addBall(ball);
            } else if (ball.getMaterial().equals(MaterialBall.PLASTIC) || ball.getMaterial().equals(MaterialBall.ELASTIC)){
                box1.addBall(ball);
            }
        }
        System.out.println("Paper's box weight is: " + box1.getWeight());
        System.out.println("Wooden's box weight is: " + box2.getWeight());


        box2.removeFirst3();
        System.out.println("After removing first 3 balls, Wooden's box weight is: " + box2.getWeight());
        System.out.println("\n");


        for(Ball ball : myBalls){
            if(ball.getColor().equals("White")){
                System.out.println(box1.changeColorbyColor("White", "Yellow"));
            }
        }
        System.out.println("\n");
        if(box1.getWeight() > 1.0){
            box1.removeAll();
        }
        System.out.println("Total balls in paper box after removing all balls more that 1.0 kg weight: " + box1.getContentSize());
        System.out.println("\n");
//        for(Ball ball : myBalls){
//            if(ball.getMaterial().equals(MaterialBall.METAL)){
//                box2.printAll();   //  ? ? ? ?
//                break;
//            }
//        }
        int length = box2.getContentSize();
        System.out.println("Box's height is " + box2.getHeight() + " , width " + box2.getWidth() + " ,length " + box2.getLength() + " ,material is " + box2.getMaterial());
        for(int i = 0; i < length;i++){
            Ball temp = box2.getBallFromContent(i);
            if(temp.getMaterial().equals(MaterialBall.METAL)){
                temp.printAll();
            }
        }


        System.out.println("\n");
        box2.changeColorByPosition(0, "Blue");
        box2.printAll();

//        for(Ball b : myBalls){
//            if(b.getMaterial().equals(MaterialBall.METAL) && b.getColor().equals("Red")){
//                box2.removeAll();
//            }
//        }
        for(int i = 0; i < length;i++){
            Ball temp = box2.getBallFromContent(i);
            if(temp.getMaterial().equals(MaterialBall.METAL) && temp.getColor().equals("Red")){
                box2.removeByIndex(i);
            }
        }
        System.out.println("Total balls in wood box after removing red - metal balls are : " + box2.getContentSize());
        System.out.println("\n");

//        Box lightest = new Box();
//        double light = lightest.getTotalWeight();
//        if(box1.getTotalWeight() < box2.getTotalWeight()){
//            box1.printAll();
//        } else {
//            box2.printAll();
//        }
        //TODO: 1 εκτύπωση ταξινομήμενα ανά χρώμα ξεκινώντας από το ελαφρύτερο κουτί.
        List<Box> myBoxes = new ArrayList<>();
        myBoxes.add(box1);
        myBoxes.add(box2);
        Collections.sort(myBoxes);
        for(Box boxes : myBoxes){
            boxes.printAll();
        }


        //αδειαζω την myBalls
//        myBalls.clear();
//        for(Box boxes : myBoxes){
//            for(int i = 0; i < myBalls.size();i++){
//                myBalls.add(box2.getBallFromContent(i));
//            }
//            //myBalls.get(i).sortByColor();
//            for(Ball b : myBalls){
//                b.printAll();
//            }
//        }




        System.out.println("\n");
        //TODO: 2 εκτύπωση  ταξινομήμενα ανά υλικό ξεκινώντας από το βαρύτερο κουτί.
        for(int i = myBoxes.size()-1; i >= 0;i--) {
            myBoxes.get(i).printAllByMaterial();
        }

    }
}