package com.algorithm.structure.inter;

public abstract class AbstractList<E> implements List<E> {


    // 元素的数量
    protected int size;

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
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    public void rangeCheck(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index :" + index + ", Size: " + size);
        }
    }

    public void rangeCheckForAdd(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index :" + index + ", Size: " + size);
        }
    }

}
