package com.structure._10_优先级队列;


import com.structure._2_链表.LinkedList;
import com.structure.inter.List;

/*
 * 优先级队列是按照元素的优先级高低进行出队，比如将优先级最高的元素作为队头优先出队
 * @author xiehongyu
 * @date 2021/12/4 10:21
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
