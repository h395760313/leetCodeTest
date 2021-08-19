package com.structure.inter;


public interface List<E> {


    /**
     * 元素的数量
     * @return
     */
    int size();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * 添加元素到最后面
     * @param element
     */
    void add(E element);

    /**
     * 往index位置添加元素
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * 返回index位置对应的元素
     * @param index
     * @return index位置对应的元素
     */
    E get(int index);

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素
     */
    E set(int index, E element);

    /**
     * 删除index位置对应的元素
     * @return
     */
    E remove(int index);

    /**
     * 查看元素的位置
     * @param element
     * @return
     */
    int indexOf(E element);

    /**
     * 清除所有元素
     */
    void clear();

}
