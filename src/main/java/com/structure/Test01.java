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
}
