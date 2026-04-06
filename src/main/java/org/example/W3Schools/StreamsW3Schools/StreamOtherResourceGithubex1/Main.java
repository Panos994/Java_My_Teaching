package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGithubex1;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> streamList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        double avg = streamList.stream().mapToDouble(n -> n).average().orElse(0);

        System.out.println(avg);
    }


}
