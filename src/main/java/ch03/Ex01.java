package ch03;

import model.Apple;

import java.util.Comparator;

public class Ex01 {
    public static void main(String[] args) {
        final Comparator<Apple> byWeight = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

    }
}

