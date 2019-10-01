package util;

import model.ApplePredicate;
import model.Apple;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
