package com.structure.d_队列;

import java.util.StringJoiner;

/**
 * @Author: xiehongyu
 * @Date: 2021/8/5 16:42
 */
public class CircleDeque<E> {
    protected static final int DEFAULT_CAPACITY = 10;
    // 元素的数量
    private int front;
    private int size;
    private E[] elements;

    public CircleDeque() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size ++;
    }

    public E deQueueRear() {
        E rearElement = elements[index(size - 1)];
        elements[index(size - 1)] = null;
        size--;
        return rearElement;
    }

    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        elements[index(-1)] = element;
        front = index(-1);
        size++;
    }

    public E deQueueFront() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    public E front(){
        return elements[front];
    }

    public E rear(){
        return elements[index(size - 1)];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        front = 0;
        size = 0;
    }

    private int index(int index){
        index += front;
        if (index < 0) index += elements.length;
        return index - (index >= elements.length ? elements.length : 0);
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;

        if (oldCapacity >= capacity) return;

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        front = 0;
        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",","[","]");
        for (int i = 0; i < elements.length; i++) {
            sj.add(String.valueOf(elements[i]));
        }
        StringBuffer sb = new StringBuffer();
        sb.append("front=");
        sb.append(front);
        sb.append(",capacity=");
        sb.append(elements.length);
        sb.append(",size=");
        sb.append(size);
        sb.append(",");
        sb.append(sj.toString());
        return sb.toString();
    }
}
