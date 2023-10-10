package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{
    private Comparator<T> comp;
    private static final int DEFAULT_CAPACITY = 8;
    private T[] items;
    private int size;
    private int front;

    public MaxArrayDeque(Comparator<T> c) {
        items = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        front = 0;
        comp = c;
    }

    public T max() {
        if (size == 0) return null;
        T max = items[front];
        for (T i : items) {
            if (comp.compare(i, max) > 0) {
                max = i;
            }
        }
        return max;
    }

    public T max(Comparator<T> c) {
        if (size == 0) return null;
        T max = items[front];
        for (T i : items) {
            if (c.compare(i, max) > 0) {
                max = i;
            }
        }
        return max;
    }
}
