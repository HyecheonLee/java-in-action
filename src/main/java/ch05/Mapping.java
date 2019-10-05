package ch05;

import model.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Mapping {
    public static void main(String[] args) {
        List<String> dishNames = Dish.menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);

        final List<String> words = Arrays.asList("Hello", "World");
        final List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);

        words.stream()
                .flatMap(s -> Arrays.stream(s.split("")))
                .distinct()
                .forEach(System.out::println);

        final List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        final List<Integer> numbers2 = Arrays.asList(6, 7, 8);

        final List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                .collect(toList());
        pairs.forEach(pair -> System.out.printf("(%d, %d)", pair[0], pair[1]));
    }
}
