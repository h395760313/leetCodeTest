package com.structure.f_集合;

import com.structure.e_树.a_二叉树.BinaryTree;

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
