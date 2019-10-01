package ch03;

import model.Apple;
import model.Color;
import util.Utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        final Runnable runnable = () -> System.out.println("Hello!");
        runnable.run();

        final List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );
        final List<Apple> greenApples = Utils.filter(inventory, a -> a.getColor() == Color.GREEN);
        System.out.println(greenApples);

        final Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight();
        inventory.sort(c);
        System.out.println(inventory);
    }
}
