package com.structure._5_树.a_二叉树;

import java.util.Comparator;

/**
 * 二叉平衡树
 * @author xiehongyu
 * @date 2021年11月24日 11:25
 */
public class BBST<E> extends BST<E>{

    public BBST() {
    }

    public BBST(Comparator<E> comparator) {
        super(comparator);
    }

    /**
     * 将节点左旋转
     *
     * @param grand
     */
    protected void rotateLeft(Node<E> grand) {
        Node<E> parent = grand.right;
        Node<E> child = parent.left;
        grand.right = child;
        parent.left = grand;
        // 维护parent
        afterRotate(grand, parent, child);
    }

    /**
     * 将节点右旋转
     *
     * @param grand
     */
    protected void rotateRight(Node<E> grand) {
        Node<E> parent = grand.left;
        Node<E> child = parent.right;
        grand.left = parent.right;
        parent.right = grand;
        // 维护parent
        afterRotate(grand, parent, child);
    }

    protected void rotate(Node<E> r,
                        Node<E> b, Node<E> c,
                        Node<E> d,
                        Node<E> e, Node<E> f) {
        // 让d成为这棵子树的根节点
        d.parent = r.parent;
        if (r.isLeftChild()) {
            r.parent.left = d;
        } else if (r.isRightChild()) {
            r.parent.right = d;
        } else {
            root = d;
        }

        // b-c
        b.right = c;
        if (c != null) {
            c.parent = b;
        }

        // e-f
        f.left = e;
        if (e != null) {
            e.parent = f;
        }
        // b-d-f
        d.left = b;
        d.right = f;
        b.parent = d;
        f.parent = d;
    }

    protected void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
        // 将parent成为子树的根节点
        parent.parent = grand.parent;
        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        } else if (grand.isRightChild()) {
            grand.parent.right = parent;
        } else {
            root = parent;
        }

        // 更新child的parent
        if (child != null) {
            child.parent = grand;
        }

        // 更新grand的parent
        grand.parent = parent;
    }
}
