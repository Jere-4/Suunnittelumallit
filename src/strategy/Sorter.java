package strategy;

public class Sorter {

    private SortStrategy strategy;

    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] arr) {
        if (strategy == null)
            throw new IllegalStateException("Sort strategy not set.");
        strategy.sort(arr);
    }

    public String getStrategyName() {
        return strategy.name();
    }
}
