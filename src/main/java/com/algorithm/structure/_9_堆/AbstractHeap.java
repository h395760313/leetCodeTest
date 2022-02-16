package com.algorithm.structure._9_堆;

/**
 * @author xiehongyu
 * @date 2021/12/03 16:58
 */
public abstract class AbstractHeap<E> implements Heap<E> {
    protected int size;
    protected static final int DEFAULT_CAPACITY = 10;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


}
