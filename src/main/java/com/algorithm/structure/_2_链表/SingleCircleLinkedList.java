package com.algorithm.structure._2_链表;

import com.algorithm.structure.inter.AbstractList;
import com.algorithm.structure.inter.List;

import java.util.StringJoiner;

public class SingleCircleLinkedList<E> extends AbstractList<E> implements List<E> {

    private Node first;

    private static class Node<E>{
        E element;
        Node<E> next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E element) {
        add(size,element);
    }

    @Override
    public void add(int index, E element) {
        rangeCheck(index);
        if (index == 0) {
            Node<E> newFirst = new Node<>(element, first);
            Node<E> last = size == 0 ? newFirst : node(size - 1);
            first = newFirst;
            last.next = first;
        }else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element,prev.next);
        }
        size++;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node(index).element;
        node.element = element;
        return old;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        if (index == 0) {
            Node<E> last = node(size - 1);
            first = size == 1 ? null : first.next;
            last.next = first;
        }else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",","[","]");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            sj.add(node.element +"_" +node.next.element);
            node = node.next;
        }
        return sj.toString();
    }

    /**
     * 获取index位置对应的node
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);

        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
}
