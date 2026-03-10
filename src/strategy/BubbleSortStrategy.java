package strategy;

/**
 * Reference:
 * https://www.geeksforgeeks.org/bubble-sort/
 */
public class BubbleSortStrategy implements SortStrategy {

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    swapped = true;
                }
            }

            if (!swapped)
                break; // Optimization
        }
    }

    @Override
    public String name() {
        return "Bubble Sort (early exit)";
    }
}
