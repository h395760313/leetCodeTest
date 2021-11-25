package com.structure._d_队列;

import com.structure._b_链表.LinkedList;
import com.structure.inter.List;

/**
 * @Author: xiehongyu
 * @Date: 2021/8/5 16:26
 */
public class Deque<E> {

    List<E> list = new LinkedList<>();
    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enQueueRear(E element) {
        list.add(element);
    }

    public E deQueueRear() {
        return list.remove(list.size() - 1);
    }

    public void enQueueFront(E element) {
        list.add(0,element);
    }

    public E deQueueFront() {
        return list.remove(0);
    }

    public E front(){
        return list.get(0);
    }

    public E rear(){
        return list.get(list.size() - 1);
    }


    public void clear() {
        list.clear();
    }
}
