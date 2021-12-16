package com.structure._6_集合;

import com.structure._5_树.a_二叉树.BinaryTree;
import com.structure._5_树.a_二叉树.RBTree;

/**
 * @author xiehongyu
 * @date 2021年11月24日 14:59
 */
public class TreeSet<E> implements Set<E>{

    private RBTree<E> tree = new RBTree<>();

    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public void clear() {
        tree.clear();
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public void add(E element) {
        tree.add(element);
    }

    @Override
    public void remove(E element) {
        tree.remove(element);
    }

    @Override
    public void traversal(Visitor visitor) {
        tree.visit(2, new BinaryTree.Visitor<E>() {
            @Override
            public boolean visit(E element) {
                return visitor.visit(element);
            }
        });
    }
}
