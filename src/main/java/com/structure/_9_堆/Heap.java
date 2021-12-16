package com.structure._9_堆;

/*
 * 堆接口
 * @author xiehongyu
 * @date 2021/12/3 15:23
 */
public interface Heap<E> {
    int size();
    boolean isEmpty();
    void clear();
    void add(E element);
    E get();
    E remove();
    E replace(E element);
}
