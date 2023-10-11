package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{
    private Comparator<T> comp;

    public MaxArrayDeque(Comparator<T> c) {
        items = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        front = 0;
        comp = c;
    }

    public T max() {
        if (this.isEmpty()) return null;
        T max = get(0);
        for (int curr = 0; curr < size; curr++) {
            T item = get(curr);
            if (comp.compare(item, max) > 0) {
                max = item;
            }
        }
        return max;
    }

    public T max(Comparator<T> c) {
        if (size == 0) return null;
        T max = items[0];
        for (int curr = 0; curr < size; curr++) {
            T item = get(curr);
            if (c.compare(item, max) > 0) {
                max = item;
            }
        }
        return max;
    }
}
