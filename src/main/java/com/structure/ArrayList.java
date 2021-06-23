package com.structure;


import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;

public class ArrayList<E> {

    // 元素的数量
    private int size;
    // 所有的元素
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;


    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capaticy){
        capaticy = capaticy < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capaticy;
        elements = (E[]) new Object[capaticy];
    }

    /**
     * 元素的数量
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(E element){
        return indexOf(element) != -1;
    }

    /**
     * 添加元素到最后面
     * @param element
     */
    public void add(E element){
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    /**
     * 往index位置添加元素
     * @param index
     * @param element
     */
    public void add(int index, E element){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index :"+ index + ", Size: "+ size);
        }
        ensureCapacity(size + 1);
        for (int i = size ; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        size++;
        elements[index] = element;

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

    /**
     * 返回index位置对应的元素
     * @param index
     * @return index位置对应的元素
     */
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index :"+ index + ", Size: "+ size);
        }
        return elements[index];
    }

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素
     */
    public E set(int index, E element){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index :"+ index + ", Size: "+ size);
        }
        E old = elements[index];
        elements[index] = element;
        return old;
    }



    /**
     * 删除index位置对应的元素
     * @return
     */
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index :"+ index + ", Size: "+ size);
        }
        E old = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[index] = elements[index + 1];
        }
        size--;
        return old;
    }

    /**
     * 查看元素的位置
     * @param element
     * @return
     */
    public int indexOf(E element){
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) return i;
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 清除所有元素
     */
    public void clear(){
        size = 0;
    }

    /**
     * 打印所有元素
     */
    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",","[","]");
        for (int i = 0; i < size; i++) {
            sj.add(String.valueOf(elements[i]));
        }
        return sj.toString();
    }
}