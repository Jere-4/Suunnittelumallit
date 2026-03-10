package strategy;

import java.util.Random;

public class ArrayUtils {

    public static int[] randomArray(int size, Random rnd, int bound) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = rnd.nextInt(bound);
        return arr;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1] > arr[i]) return false;
        return true;
    }

    public static long timeMillis(Runnable r) {
        long start = System.nanoTime();
        r.run();
        return (System.nanoTime() - start) / 1_000_000;
    }
}
