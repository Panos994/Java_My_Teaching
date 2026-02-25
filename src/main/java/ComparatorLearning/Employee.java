package ComparatorLearning;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Comparable<Employee>{

    private int id;
    private String name;

    //
    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.id,o.id);
    }





}
