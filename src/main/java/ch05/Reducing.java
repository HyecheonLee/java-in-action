package ch05;

import model.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        final Integer sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        final Integer sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        final Integer max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println(max);

        final Optional<Integer> min = numbers.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);

        final int calories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .reduce(0, Integer::sum);

        System.out.println("Numb er of calories: " + calories);
    }
}
