package deque;

import org.junit.Test;

import java.util.Comparator;

public class MaxArrayDequeTest {
    @Test
    public void test() {
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else if (o1 == o2) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };
        MaxArrayDeque<Integer> a = new MaxArrayDeque<Integer>(c);
        for (int i = 0; i < 10; i++) {
            a.addLast(i);
        }
        a.addFirst(999);
        a.printDeque();
        int maxEle = a.max();
        System.out.println(maxEle);
    }
}
