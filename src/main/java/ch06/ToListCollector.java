package ch06;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return ((ts, t) -> ts.add(t));
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        return (ts, ts2) -> {
            ts.addAll(ts2);
            return ts;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        return i -> i;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, CONCURRENT));
    }
}
