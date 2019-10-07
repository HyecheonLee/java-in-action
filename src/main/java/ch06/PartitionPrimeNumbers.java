package ch06;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

public class PartitionPrimeNumbers {
    public static void main(String[] args) {
        System.out.println("Numbers partitioned in prime and non-prime: " + partitionPrimes(100));
        System.out.println("Numbers partitioned in prime and non-prime: " + partitionPrimesWithCustomCollector(100));
    }


    private static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(Collectors.partitioningBy(PartitionPrimeNumbers::isPrime));
    }

    private static boolean isPrime(int candidate) {
        return IntStream.rangeClosed(2, candidate - 1)
                .limit((long) (Math.floor(Math.sqrt(candidate)) - 1))
                .noneMatch(i -> candidate % i == 0);
    }

    private static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumbersCollector());
    }

    public static boolean isPrime(List<Integer> primes, Integer candidate) {
        final double candidateRoot = Math.sqrt(candidate);
        return primes.stream().takeWhile(i -> i <= candidateRoot).noneMatch(i -> candidate % i == 0);
    }

    public static class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

        @Override
        public Supplier<Map<Boolean, List<Integer>>> supplier() {
            return () -> {
                final HashMap<Boolean, List<Integer>> newMap = new HashMap<>();
                newMap.put(true, new ArrayList<Integer>());
                newMap.put(false, new ArrayList<Integer>());
                return newMap;
            };
        }

        @Override
        public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
            return (acc, candidate) -> acc.get(isPrime(acc.get(true), candidate)).add(candidate);
        }

        @Override
        public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
            return (booleanListMap, booleanListMap2) -> {
                booleanListMap.get(true).addAll(booleanListMap2.get(true));
                booleanListMap.get(false).addAll(booleanListMap2.get(false));
                return booleanListMap;
            };
        }

        @Override
        public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
            return i -> i;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
        }
    }
}
