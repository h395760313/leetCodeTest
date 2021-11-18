package com.structure.e_树.a_二叉树;

import com.structure.e_树.BinarySearchTree;

import java.util.Comparator;

public class BST<E> extends BinaryTree<E> {
    private Comparator<E> comparator;

    public BST() {
        this(null);
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void add(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        //先找到父节点
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                node.element = element;
                return;
            }
        }

        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    public boolean contains(E element) {
        return node(element) != null;
    }

    /**
     * 删除节点
     * @param element
     */
    public void remove(E element) {
        Node<E> node = node(element);

        if (node.hasTwoChildren()) { // 度为2的节点
            // 找到前驱或者后继节点
            Node<E> predecessor = getPredecessor(node);
            node.element = predecessor.element; // 用前驱节点的值覆盖需要删除的节点的值
            node = predecessor; // 只需要删除前驱节点即可
        }

        // 删除度为1或者0的节点
        Node<E> replaceNode = node.right == null ? node.left : node.right;
        if (replaceNode != null) { // 表示被删除节点的度为1
            replaceNode.parent = node.parent; // 设置替换者的parent为被删除节点的parent
            if (node.parent == null) { // 表示被删除节点是度为1的根节点
                root = replaceNode;
            }else if (node == node.parent.left) { // 表示被删除节点是度为1的parent的左子节点
                node.parent.left = replaceNode;
            } else { // node == node.parent.right 表示被删除节点是度为1的parent的右子节点
                node.parent.right = replaceNode;
            }

        }else { // 表示被删除节点的度为0
            if (node.parent == null) { // 表示叶子节点并且是根节点
                root = null;
            } else if (node == node.parent.left) { // 表示叶子节点并且是左子节点
                node.parent.left = replaceNode;
            } else { // node == node.parent.right 表示叶子节点并且是右子节点
                node.parent.right = replaceNode;
            }
        }
    }

    private Node<E> node(E element){
        Node<E> node = root;
        while (node != null) {
            if (compare(element, node.element) == 0) {
                return node;
            }else if (compare(element, node.element) > 0){
                node = node.right;
            }else {
                node = node.left;
            }
        }
        return null;
    }

    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }


    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new RuntimeException("element must not be null");
        }
    }
}
