package strategy;

/**
 * Reference:
 * https://www.geeksforgeeks.org/insertion-sort/
 */
public class InsertionSortStrategy implements SortStrategy {

    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    @Override
    public String name() {
        return "Insertion Sort";
    }
}
