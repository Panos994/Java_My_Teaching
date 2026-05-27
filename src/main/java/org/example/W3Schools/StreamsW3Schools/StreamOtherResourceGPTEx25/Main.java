package org.example.W3Schools.StreamsW3Schools.StreamOtherResourceGPTEx25;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve");
        long count= names.stream().filter(s->s.length()> 4).count();
        System.out.println(count);
    }
}
