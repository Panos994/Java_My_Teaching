package org.example.ArraysChallenges.YoungestAndTallestFriends;

public class Friend implements Comparable<Friend> {
    private String name;
    private int age;
    private double height;

    public Friend(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public int compareTo(Friend o) {
        return Integer.compare(this.age,o.age);
    }
}
