package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx5;

import java.util.Random;
import java.util.UUID;

public class Person {
    Random rand = new Random();
    private int id;
    private int age;
    private String name;
    private String id2Generated;

    public Person(int age, String name) {
        id = rand.nextInt() + 1;
        this.id2Generated = UUID.randomUUID().toString();
        this.age = age;
        this.name = name;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId2Generated() {
        return id2Generated;
    }

    public void setId2Generated(String id2Generated) {
        this.id2Generated = id2Generated;
    }
}
