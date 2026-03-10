package strategy;

/**
 * Reference:
 * https://www.geeksforgeeks.org/selection-sort/
 */
public class SelectionSortStrategy implements SortStrategy {

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int t = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = t;
            }
        }
    }

    @Override
    public String name() {
        return "Selection Sort";
    }
}
