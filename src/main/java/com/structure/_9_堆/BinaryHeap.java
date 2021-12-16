package com.structure._9_堆;

import com.structure._5_树.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * @author xiehongyu
 * @date 2021/12/03 15:25
 */
public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {

    private E[] elements;
    private Comparator comparator;

    public BinaryHeap(Comparator<E> comparator) {
        this.comparator = comparator;
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public BinaryHeap() {
        new BinaryHeap(null);
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size ++] = element;
        siftUp(size - 1);
    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E replace(E element) {
        return null;
    }

    /**
     * 上滤
     * @param index
     */
    private void siftUp(int index){
        E e = elements[index];
        while (index > 0) {
            int pindex = (index - 1) / 2;
            E p = elements[pindex];
            if (compare(e, p) <= 0) break;
            // node不为根节点且大于父节点
            elements[index] = p;
            index = pindex;
        }
        elements[index] = e;
    }

    private int compare(E e1, E e2){
        return comparator != null ? comparator.compare(e1, e2) : ((Comparable<E>)e1).compareTo(e2);
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;

        if (oldCapacity > capacity) return;

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < oldCapacity; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }

    private void emptyCheck(){
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("Heap is empty");
        }
    }

    private void elementNotNullCheck(E element){
        if (element == null) {
            throw new IllegalArgumentException("element must not null");
        }
    }

    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
        int index = ((int) node << 1) + 1;
        return elements[index] == null ? null : index;
    }

    @Override
    public Object right(Object node) {
        int index = ((int) node << 1) + 1;
        return elements[index] == null ? null : index;
    }

    @Override
    public Object string(Object node) {
        return elements[(int) node];
    }
}
