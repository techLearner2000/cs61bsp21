package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 8;
    private T[] items;
    private int size;
    private int front;

    public ArrayDeque() {
        items = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        front = 0;
    }

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[2 * items.length];
        for (int i = 0; i < size; i++) {
            newArray[i] = items[(front + i) % items.length];
        }
        items = newArray;
        front = 0;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(2 * items.length);
        }

        front = (front - 1 + items.length) % items.length;
        items[front] = item;
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(2 * items.length);
        }

        int back = (front + size) % items.length;
        items[back] = item;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[(front + i) % items.length] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        T removedFirst = items[front];
        items[front] = null;
        front = (front + 1) % items.length;
        size -= 1;
        return removedFirst;
    }

    public T removeLast() {
        T removedLast = items[(front + size - 1) % items.length];
        items[(front + size - 1) % items.length] = null;
        size -= 1;
        return removedLast;
    }

    public T get(int index) {
        return items[(front + index) % items.length];
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int count;

        public ArrayDequeIterator() {
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public T next() {
            T item = get(count);
            count += 1;
            return item;
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ArrayDeque)) {
            return false;
        }

        ArrayDeque<?> other = (ArrayDeque<?>) o;

        if (size != other.size()) {
            return false;
        }

        Iterator<T> it1 = this.iterator();
        Iterator<?> it2 = other.iterator();

        while (it1.hasNext() && it2.hasNext()) {
            if (it1.next() != it2.next()) {
                return false;
            }
        }

        return true;    
    }
}
