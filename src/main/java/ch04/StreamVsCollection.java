package ch04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamVsCollection {
    public static void main(String[] args) {
        final List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        final Stream<String> s = names.stream();
        s.forEach(System.out::println);
//        s.forEach(System.out::println);
    }
}
