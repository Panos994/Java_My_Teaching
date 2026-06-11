package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx35;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> fdf = new ArrayList<>(List.of(34,5,433,1,2));

        List<Integer> filt = fdf.stream().filter(n->n%2==0).mapToInt(n->n*3).boxed().toList();
        System.out.println(filt);
    }
}
