package com.structure.e_树.a_二叉树;

import java.util.Comparator;

/**
 * @author xiehongyu
 * @date 2021年11月23日 15:46
 */
public class RBTree<E> extends BBST<E>{
    private final static boolean RED = false;
    private final static boolean BLACK = true;

    public RBTree() {
        this(null);
    }

    public RBTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        Node<E> parent = node.parent;

        // 添加的是根节点
        if (null == parent) {
            black(node);
            return;
        }

        // 如果父节点是黑色，直接返回
        if (isBlack(parent)) return;

        // 叔父节点
        Node<E> uncle = parent.sibling();
        // 祖父节点
        Node<E> grand = parent.parent;

        // 叔父节点是红色
        if (isRed(uncle)) {
            black(uncle);
            black(parent);
            // 把祖父节点当作新添加的新节点
            red(grand);
            afterAdd(grand);
        }else {
            red(grand);
            if (parent.isLeftChild()) { // L
                if (node.isLeftChild()) {
                    // LL
                    // 染色：父节点染黑，祖父节点染红
                    // 旋转：祖父节点右旋转
                    black(parent);
                }else {
                    // LR
                    // 染色：新增节点染黑，祖父节点染红
                    // 旋转：父节点左旋转，祖父节点右旋转
                    black(node);
                    rotateLeft(parent);
                }
                rotateRight(grand);
            }else { // R
                if (node.isLeftChild()) {
                    // RL
                    // 染色：新增节点染黑，祖父节点染红；
                    // 旋转：父节点右旋转，祖父节点左旋转
                    black(node);
                    rotateRight(parent);
                }else {
                    // RR
                    // 染色：父节点染黑，祖父节点染红
                    // 旋转：祖父节点左旋转
                    black(parent);
                }
                rotateLeft(grand);
            }
        }
     }

    @Override
    protected void afterRemove(Node<E> node, Node<E> replacement) {
        // 如果删除的节点是红色
        if (isRed(node)) return;

        // 如果用以取代node的节点是红色
        if (isRed(replacement)) {
            black(replacement);
        }

        Node<E> parent = node.parent;
        // 如果删除的是根节点
        if (parent == null) return;

        // 如果被删除的节点是黑色叶子节点

    }

    private Node<E> color(Node<E> node, boolean color){
        if (node == null) return node;
        ((RBNode<E>)node).color = color;
        return node;
    }

    private Node<E> red(Node<E> node){
        return color(node,RED);
    }

    private Node<E> black(Node<E> node){
        return color(node,BLACK);
    }

    private boolean colorOf(Node<E> node){
        return node == null ? BLACK : ((RBNode<E>)node).color;
    }

    private boolean isRed(Node<E> node){
        return colorOf(node) == RED;
    }

    private boolean isBlack(Node<E> node){
        return colorOf(node) == BLACK;
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new RBNode<>(element, parent);
    }



    private static class RBNode<E> extends Node<E> {
        boolean color;

        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }

        @Override
        public String toString() {
            String str = "";
            if (color == RED) {
                str = "R_";
            }
            return str + element.toString();
        }
    }
}
