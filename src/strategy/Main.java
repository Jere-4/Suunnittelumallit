package strategy;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int smallSize = 30;
        int largeSize = 100000;
        long seed = System.currentTimeMillis();
        Random rnd = new Random(seed);

        SortStrategy[] strategies = {
                new SelectionSortStrategy(),
                new BubbleSortStrategy(),
                new InsertionSortStrategy()
        };

        Sorter sorter = new Sorter(null);

        System.out.println("=== Benchmark Start ===");
        System.out.println("Seed: " + seed);
        System.out.println();

        benchmarkSet("Small dataset", smallSize, strategies, sorter, rnd);
        System.out.println();
        benchmarkSet("Large dataset", largeSize, strategies, sorter, rnd);

        System.out.println("\nCompleted.");
    }

    private static void benchmarkSet(
            String name,
            int size,
            SortStrategy[] strategies,
            Sorter sorter,
            Random rnd
    ) {
        System.out.println("--- " + name + " (" + size + " elements) ---");

        int[] baseData = ArrayUtils.randomArray(size, rnd, Math.max(1000, size));

        for (SortStrategy strategy : strategies) {
            int[] copy = Arrays.copyOf(baseData, baseData.length);
            sorter.setStrategy(strategy);

            long ms = ArrayUtils.timeMillis(() -> sorter.sort(copy));
            boolean ok = ArrayUtils.isSorted(copy);

            System.out.printf("%-22s : %8d ms   %s%n",
                    strategy.name(), ms, ok ? "OK" : "FAILED");
        }
    }
}
