package com.algorithm.structure._1_动态数组;


import com.algorithm.structure.inter.AbstractList;
import com.algorithm.structure.inter.List;

import java.util.StringJoiner;

public class ArrayList<E> extends AbstractList<E> implements List<E> {

    // 所有的元素
    private E[] elements;
    protected static final int DEFAULT_CAPACITY = 10;

    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capaticy){
        capaticy = capaticy < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capaticy;
        elements = (E[]) new Object[capaticy];
    }

    /**
     * 添加元素到最后面
     * @param element
     */
    @Override
    public void add(E element){
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    /**
     * 往index位置添加元素
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element){
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size ; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        size++;
        elements[index] = element;
    }



    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;

        if (oldCapacity >= capacity) return;

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        System.arraycopy(elements,0,newElements,0,size);
        elements = newElements;
        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }

    /**
     * 返回index位置对应的元素
     * @param index
     * @return index位置对应的元素
     */
    @Override
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
    @Override
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
    @Override
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index :"+ index + ", Size: "+ size);
        }
        E old = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[index] = elements[index + 1];
        }
        elements[--size] = null;
        return old;
    }

    /**
     * 查看元素的位置
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element){
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 清除所有元素
     */
    @Override
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