package com.structure.e_树.a_二叉树;

import java.util.Comparator;

public class AVLTree<E> extends BST<E>{
    private Comparator<E> comparator;

    public AVLTree() {
        this(null);
    }

    public AVLTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    protected void afterAdd(Node<E> node) {
        node = node.parent;
        while (node != null) {
            if (isBanlanced(node)){
                // 更新高度
                updateHeight(node);
            }else {
                // 恢复平衡
                rebalance(node);
            }
        }
    }

    /**
     * 节点是否平衡
     * @param node
     * @return
     */
    private boolean isBanlanced(Node<E> node){
        System.out.println(node.element);
        AVLNode<E> avlNode = (AVLNode<E>) node;
        int factor = avlNode.balanceFactor();
        return Math.abs(factor) <= 1;
    }

    private void updateHeight(Node<E> node) {
        AVLNode<E> avlNode = (AVLNode<E>) node;
        avlNode.updateHeight();
    }

    /**
     * LL:grand右旋
     * RR:grand左旋
     * LR:parent右旋，grand左旋
     * RL:parent左旋，grand右旋
     * @param grand
     */
    private void rebalance(Node<E> grand){
        Node<E> parent = ((AVLNode<E>)grand).tallerChild();
        Node<E> node = ((AVLNode<E>)parent).tallerChild();
        if (parent.isLeftChild()) { //L
            if (node.isLeftChild()) { // LL
                rotateRight(grand);
            } else { // LR
                rotateRight(parent);
                rotateLeft(grand);
            }
        } else { // R
            if (node.isLeftChild()) { // RL
                rotateLeft(parent);
                rotateRight(grand);
            } else { // RR
                rotateLeft(grand);
            }
        }
    }

    /**
     * 将节点左旋转
     * @param node
     */
    private void rotateLeft(Node<E> node){
        node.right.left = node;
        if (node.parent != null) {
            if (node.isLeftChild()) {
                node.parent.left = node.right;
            }else {
                node.parent.right = node.right;
            }
            node.right.parent = node.parent;
        }else {
            root = node.right;
        }
        node.parent = node.right;
        node.right = node.right.left;
    }

    /**
     * 将节点右旋转
     * @param node
     */
    private void rotateRight(Node<E> node){
        node.left.right = node;
        // 如果不是根节点
        if (node.parent != null) {
            if (node.isLeftChild()) {
                node.parent.left = node.left;
            }else {
                node.parent.right = node.left;
            }
            node.left.parent = node.parent;
        }else {
            root = node.left;
        }
        node.parent = node.left;
        node.left = node.left.right;
    }

    private static class AVLNode<E> extends Node<E> {
        int height = 1;

        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }

        public int balanceFactor(){
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            return leftHeight - rightHeight;
        }

        public void updateHeight(){
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            height = 1 + Math.max(leftHeight, rightHeight);
        }

        public Node<E> tallerChild(){
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            if (leftHeight > rightHeight) return left;
            if (leftHeight < rightHeight) return right;
            return this.isLeftChild() ? left : right;
        }
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode<>(element, parent);
    }
}
