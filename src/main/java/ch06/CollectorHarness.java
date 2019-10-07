package ch06;

import java.util.function.Consumer;

public class CollectorHarness {
    public static void main(String[] args) {
        //System.out.println("Partitioning done in: " + execute(PartitionPrimeNumbers::partitionPrimes) + " msecs");
//        System.out.println("Partitioning done in: " + execute(PartitionPrimeNumbers::partitionPrimesWithCustomCollector) + " msecs");
    }

    private static long execute(Consumer<Integer> primePartitioner) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            final long start = System.nanoTime();
            primePartitioner.accept(1_000_000);
            final long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) {
                fastest = duration;
            }
            System.out.println("done in " + duration);
        }
        return fastest;
    }
}
