package ch02;

import model.Apple;
import model.ApplePredicate;
import model.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

import static model.Color.GREEN;
import static model.Color.RED;

public class FilteringApples {

    public static void main(String[] args) {
        final List<Apple> inventory = Arrays.asList(new Apple(80, GREEN),
                new Apple(155, GREEN),
                new Apple(120, RED));

        final List<Apple> redApples = filterApple(inventory, apple -> apple.getColor().equals(RED));

        final String sum = reduce(
                map(inventory,
                        Apple::getColor),
                "",
                (acc, value) -> acc + " " + value.name());
        System.out.println(sum);
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterAppleByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterAppleByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApple(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterApple(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    private static <T> List<T> filter(List<T> inventory, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : inventory) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    private static <T, R> List<R> map(List<T> inventory, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : inventory) {
            result.add(f.apply(t));
        }
        return result;
    }

    private static <T, R> R reduce(List<T> inventory, R init, BiFunction<R, T, R> f) {
        List<R> result = new ArrayList<>();
        R acc = init;
        for (T t : inventory) {
            acc = f.apply(acc, t);
        }
        return acc;
    }
}
