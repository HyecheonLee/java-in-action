package ch04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamVsCollection {
    public static void main(String[] args) {
        final List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        final Stream<String> s = names.stream();
        s.forEach(System.out::println);
        //스트림은 한번만 소비할 수 있으므로 아래 주석을 제거하면 IllegalStateException 이 발생한다.
//        s.forEach(System.out::println);
    }
}
