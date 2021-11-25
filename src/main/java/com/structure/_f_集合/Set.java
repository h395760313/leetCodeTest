package com.structure._f_集合;

/**
 * @author xiehongyu
 * @date 2021年11月24日 14:19
 */
public interface Set<E> {

    int size();
    boolean isEmpty();
    void clear();
    boolean contains(E element);
    void add(E element);
    void remove(E element);
    void traversal(Visitor visitor);

    abstract class Visitor<E>{
        boolean stop;
        /**
         *  返回false则退出遍历
         */
        public abstract boolean visit(E element);
    }
}
