package com.structure._9_堆;

import com.structure._5_树.printer.BinaryTrees;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xiehongyu
 * @date 2021/12/03 16:11
 */
public class HeapTest {

    @Test
    public void stackTest(){
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(46);
        heap.add(50);
        heap.add(38);
        heap.add(70);
        heap.add(22);

        BinaryTrees.println(heap);
    }

    @Test
    public void test01(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Integer[] arr = {88, 73, 4, 40, 41, 77, 7, 56, 76, 8, 15, 97, 93, 23, 63, 34, 5};

        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < 3) {
                queue.offer(arr[i]);
                System.out.println(queue.peek());
            }else if (arr[i] > queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
                System.out.println(queue.peek());
            }
        }
        while (!queue.isEmpty()) {
            System.out.println("------------");
            System.out.println(queue.poll());
        }
    }


}
