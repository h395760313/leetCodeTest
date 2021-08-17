package com.structure;

import org.junit.Test;

public class Test01 {

    @Test
    public void linkedListTest(){
        List<Integer> list = new SingleCircleLinkedList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(55);
        System.out.println(list);

        list.add(0,66);
        list.add(2,88);
        list.add(77);

        list.set(1,99);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.remove(2);
        // (99,88,33,44,55,77)
        System.out.println(list);
    }

    @Test
    public void stackTest(){
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        stack.push(55);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    @Test
    public void queueTest(){
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(11);
        queue.enQueue(22);
        queue.enQueue(33);
        queue.enQueue(44);

        while (!queue.isEmpty()){
            System.out.println(queue.deQueue());
        }
    }

    @Test
    public void dequeTest(){
        /* 头 44 33 11 22 尾 */
        Deque<Integer> deque = new Deque<>();
        deque.enQueueFront(11);
        deque.enQueueFront(22);
        deque.enQueueRear(33);
        deque.enQueueRear(44);

        while (!deque.isEmpty()){
            System.out.println(deque.deQueueRear());
        }
    }

    @Test
    public void circleQueueTest() {

        CircleQueue circleQueue = new CircleQueue();
        /*头 0 1 2 3 4 5 6 7 8 9 尾*/
        for (int i = 0; i < 10; i++) {
            circleQueue.enQueue(i);
        }
        /*头 null null null null null 5 6 7 8 9 尾*/
        for (int i = 0; i < 5; i++) {
            circleQueue.deQueue();
        }
        System.out.println(circleQueue);
        /*头 5 6 7 8 9 15 16 17 18 19 尾*/
        for (int i = 15; i < 25; i++) {
            circleQueue.enQueue(i);
        }
        System.out.println(circleQueue);
        while (!circleQueue.isEmpty()) {
            System.out.println(circleQueue.deQueue());
        }
    }

    @Test
    public void circleDequeTest(){
        CircleDeque circleDeque = new CircleDeque<>();
        /*头 4 3 2 1 0 100 101 102 103 104 尾*/
        /*头 4 3 2 1 0 100 101 102 103 104 105 106 7 6 5 尾*/
        /*头 7 6 5 4 3 2 1 0 100 101 102 103 104 105 106 107 108 109 null null 9 8 尾*/
        for (int i = 0; i < 10; i++) {
            circleDeque.enQueueFront(i);
            circleDeque.enQueueRear(i+100);
        }
//        System.out.println(circleDeque);
//        /*头 6 5 4 3 2 1 0 100 101 102 103 104 105 106 尾*/
        for (int i = 0; i < 3; i++) {
            circleDeque.deQueueFront();
            circleDeque.deQueueRear();
        }
//        System.out.println(circleDeque);
//        /*头 null 12 11 6 5 4 3 2 1 0 100 101 102 103 104 105 106 尾*/
        circleDeque.enQueueFront(11);
        circleDeque.enQueueFront(12);

        System.out.println(circleDeque);
        while (!circleDeque.isEmpty()){
            System.out.println(circleDeque.deQueueFront());
        }
    }



}
