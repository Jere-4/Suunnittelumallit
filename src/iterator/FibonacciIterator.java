package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FibonacciIterator implements Iterator<Integer> {

    private int previous = 1;
    private int current = 1;
    private boolean firstReturned = false;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        if (!firstReturned) {
            firstReturned = true;
            return 1;
        }

        int nextValue = previous + current;
        previous = current;
        current = nextValue;

        return previous;
    }
}
