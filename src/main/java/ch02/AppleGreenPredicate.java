package ch02;

import model.Apple;
import model.ApplePredicate;

import static model.Color.GREEN;

public class AppleGreenPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
