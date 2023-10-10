package deque;

import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void iteratorTest() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            a.addFirst(i);
        }
        for (int item : a) {
            System.out.println(item);
        }
    }
}
