package ch13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Intro {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 6);

        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
    }
}
