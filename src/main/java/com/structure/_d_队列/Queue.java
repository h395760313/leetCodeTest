package com.structure._d_队列;


import com.structure._b_链表.LinkedList;
import com.structure.inter.List;

/**
 * @Author: xiehongyu
 * @Date: 2021/8/5 14:32
 */
public class Queue<E> {

    private List<E> linkedList = new LinkedList<>();

    public int size() {
        return linkedList.size();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }

    public void enQueue(E element) {
        linkedList.add(element);
    }

    public E deQueue(){
        return linkedList.remove(0);
    }

    public E front() {
        return linkedList.get(0);
    }

    public void clear() {
        linkedList.clear();
    }
}
