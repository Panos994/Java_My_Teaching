package org.example;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Box implements Comparable<Box> {
    private double height;
    private double width;
    private double length;
    private MaterialBox material;
    private List<Ball> content; //= new ArrayList<>();   //*
    private Double weight;

    public Box() {
        content = new ArrayList<>(); // ενδυκνειται καλύτερα να αρχικοποιείται στους constructors
                                    // και γενικά αρχικοποιήσεις στους constructors

    }

    public Box(double height, double width, double length, MaterialBox material, Double weight) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.material = material;
        content = new ArrayList<>(); //* έτσι εννοούμε
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public MaterialBox getMaterial() {
        return material;
    }

    public void setMaterial(MaterialBox material) {
        this.material = material;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void addBall(Ball ball) {
        if (ball != null) {
            content.add(ball);
            weight += ball.getWeight();
        }
    }

    public void removeFirst3() {
//        Ball removeBall1 = content.get(0);
//        Ball removeBall2 = content.get(1);
//        Ball removeBal3 = content.get(2);
//        weight -= removeBall1.getWeight();
//        weight -= removeBall2.getWeight();
//        weight -= removeBal3.getWeight();
        if (content.size() >= 3) {
            Iterator<Ball> iter = content.iterator();
            int counter = 0;
            while (iter.hasNext()) {
                counter++;
                Ball b = iter.next();
                weight-= b.getWeight();
                if (counter <= 3) {
                    iter.remove();
                }
            }
        }
    }

    public void removeAllByColor(String color1) {
        for (int i = 0; i < content.size(); i++) {
            Ball removed = content.get(i);
            if (removed.getColor().equals(color1)) {
                content.remove(removed);
            }
        }
    }

    public boolean removeAllMoreThanByWeight(Double weight3) {
        for (int i = 0; i < content.size(); i++) {
            Ball removed = content.get(i);
            if (removed.getWeight() >= weight3) {
                content.remove(removed);
            }
            return true;
        }
        return false;
    }

    public boolean removeAllLessThanByWeight(Double weight2) {
        for (int i = 0; i < content.size(); i++) {
            Ball removed = content.get(i);
            if (removed.getWeight() <= weight2) {
                content.remove(removed);
            }
            return true;
        }
        return false;
    }

    public void removeByIndex(int index){
        if(content.get(index) != null){
            weight -= content.get(index).getWeight();
            content.remove(index);
        }
    }
    public boolean removeAllByMaterial(String material1) {
        for (int i = 0; i < content.size(); i++) {
            Ball removed = content.get(i);
            if (removed.getMaterial().equals(material1)) {
                content.remove(removed);
            }
            return true;
        }
        return false;
    }

    public void removeAll() {
        for (int i = 0; i < content.size(); i++) {
            Ball removedBalls = content.get(i);
            content.remove(removedBalls);
            weight -= removedBalls.getWeight();
        }
    }

    public int getNumberByColor(String color2) {
        int count = 0;
        for (Ball elem : content) {
            if (elem.getColor().equals(color2)) {
                count++;
            }
        }
        return count;
    }

    public void changeColorByPosition(int index, String color) {
        for (int i = 0; i < content.size(); i++) {
            content.get(index).setColor(color);
        }
    }

    public boolean changeColorbyColor(String colorOld, String colorNew) {
        for (Ball elements : content) {
            colorOld = elements.getColor();
            colorOld = colorNew;
            System.out.println("Color for white balls updated to: " + colorNew);
            return true;
        }
        return false;
    }

    public Ball getBallFromContent(int index) {
        if(content.get(index) != null){
            return content.get(index);
        }
        return null;
    }

    public int getContentSize() {
        return content.size();
    }

    public Double getTotalWeight() {
        Double totalWeight = 0.0;
        for (Ball elements : content) {
            totalWeight += elements.getWeight();
        }
        return totalWeight;
    }

    public void printAll() {
        System.out.println("Box's height is " + height + " , width " + width + " ,length " + length + " ,material is " + material);
        System.out.println("And total weight of the box is: " + getTotalWeight());
        Collections.sort(content);
        for (int i = 0; i < content.size(); i++) {
            content.get(i).printAll();
        }
    }

    @Override
    public int compareTo(Box o) {
        return this.weight.compareTo(o.weight);
    }

    public void printAllByMaterial(){
        System.out.println("Box's height is " + height + " , width " + width + " ,length " + length + " ,material is " + material);
        System.out.println("And total weight of the box is: " + getTotalWeight());

        Collections.sort(content, (b1,b2) -> {return b1.getMaterial().toString().compareTo(b2.getMaterial().toString());
        });
        for(Ball b : content){
            b.printAll();
        }
    }
}
