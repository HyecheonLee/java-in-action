package ch11;

import java.util.Optional;

public class OperationsWithOptional {
    public static void main(String[] args) {
        System.out.println(max(Optional.of(3), Optional.of(5)));
        System.out.println(max(Optional.empty(), Optional.of(5)));

        final Optional<Integer> opt1 = Optional.of(5);
        final Optional<Integer> opt2 = opt1.or(() -> Optional.of(4));
        System.out.println(Optional.of(5).or(() -> Optional.of(4)));
    }

    public static final Optional<Integer> max(Optional<Integer> i, Optional<Integer> j) {
        return i.flatMap(a -> j.map(b -> Math.max(a, b)));
    }
}
