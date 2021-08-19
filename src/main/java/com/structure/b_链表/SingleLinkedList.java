package com.structure.b_链表;

import com.structure.inter.AbstractList;
import com.structure.inter.List;

import java.util.StringJoiner;

public class SingleLinkedList<E> extends AbstractList<E> implements List<E> {

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
        rangeCheckForAdd(index);
        if (index == 0) {
            first = new Node<>(element,first);
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
            first = first.next;
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
            sj.add(String.valueOf(node.element));
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
