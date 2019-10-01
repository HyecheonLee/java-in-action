package ch03;

import model.Apple;
import model.Color;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        //1
        final List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );

        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        inventory.set(1, new Apple(30, Color.GREEN));

        //2
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        System.out.println(inventory);

        inventory.set(1, new Apple(20, Color.RED));

        //3
        inventory.sort((o1, o2) -> o1.getWeight() - o2.getWeight());
        System.out.println(inventory);

        inventory.set(1, new Apple(10, Color.RED));

        //4
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);

    }

    static class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight() - o2.getWeight();
        }
    }
}
