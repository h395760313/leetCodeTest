package com.structure.e_二叉搜索树;

import com.structure.printer.BinaryTreeInfo;
import com.sun.source.tree.LineMap;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: xiehongyu
 * @Date: 2021/8/17 18:37
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {

    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

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

    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }

    public void remove(E element) {

    }

    public boolean contains(E element) {
        return false;
    }

    public void Traversal(int orderType) {
        if (orderType == OrderTypeEnum.Preorder.index) {
            preorderTraversal(root);
        } else if (orderType == OrderTypeEnum.inorder.index) {
            inorderTraversal(root);
        } else if (orderType == OrderTypeEnum.postorder.index) {
            postorderTraversal(root);
        } else if (orderType == OrderTypeEnum.levelorder.index) {
            levelorderTraversal();
        }
    }

    public void visit(int orderType, Visitor<E> visitor) {
        if (orderType == OrderTypeEnum.Preorder.index) {
            preorderVisit(root, visitor);
        } else if (orderType == OrderTypeEnum.inorder.index) {
            inorderVisit(root,visitor);
        } else if (orderType == OrderTypeEnum.postorder.index) {
            postorderVisit(root, visitor);
        } else if (orderType == OrderTypeEnum.levelorder.index) {
            levelorderVisit( visitor);
        }
    }

    /**
     * 前序访问
     * @param node
     */
    private void preorderVisit(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor == null) return;
        visitor.visit(node.element);
        preorderVisit(node.left, visitor);
        preorderVisit(node.right, visitor);
    }

    /**
     * 中序访问
     * @param node
     */
    private void inorderVisit(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor == null) return;
        inorderVisit(node.left, visitor);
        visitor.visit(node.element);
        inorderVisit(node.right, visitor);
    }

    /**
     * 后序访问
     * @param node
     */
    private void postorderVisit(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor == null) return;
        postorderVisit(node.left, visitor);
        postorderVisit(node.right, visitor);
        visitor.visit(node.element);
    }

    public void levelorderVisit(Visitor<E> visitor){
        if (root == null || visitor == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            visitor.visit(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 前序遍历
     * @param node
     */
    private void preorderTraversal(Node<E> node) {
        if (node == null) return;
        System.out.println(node.element);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    /**
     * 中序遍历
     * @param node
     */
    private void inorderTraversal(Node<E> node) {
        if (node == null) return;
        inorderTraversal(node.left);
        System.out.println(node.element);
        inorderTraversal(node.right);
    }

    /**
     * 后序遍历
     * @param node
     */
    private void postorderTraversal(Node<E> node) {
        if (node == null) return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.println(node.element);
    }

    /**
     * 层序遍历
     */
    private void levelorderTraversal() {
        if (root == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            System.out.println(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 迭代方法获取树的高度
     * @return
     */
    public int height(){
        Queue<Node<E>> queue = new LinkedList<>();
        // 树的高度
        int height = 0;
        // 存储每一层元素数量
        int levelSize = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            levelSize --;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (levelSize == 0) {
                // 即将访问下一层
                height++;
                levelSize = queue.size();
            }
        }
        return height;
    }

    /**
     * 判断树是否是完全二叉树
     * 如果node.left != null && node.right != null， 将node.left、node.right按顺序入队
     * 如果node.left = null && node.right != null， 返回false
     * 如果node.left != null && node.right = null 或者 node.left == null && node.right == null  那么后面遍历的节点应该都为叶子节点，才是完全二叉树，否则返回false
     * @return
     */
    public boolean isComplete(){
        if (root == null) return false;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            if (leaf && !node.isLeaf()){
                return false;
            }

            if (node.hasTwoChildren()) {
                queue.offer(node.left);
                queue.offer(node.right);
            }else if (node.left == null && node.right != null){
                return false;
            } else {
                leaf = true;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return true;
    }

    /**
     * 通过递归获取树的高度
     * @param node
     * @return
     */
    private int height2(Node<E> node){
        if (node == null) return 0;
        return 1 + Math.max(height2(node.left), height2(node.right));
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        toString(root, sb, "");
        return sb.toString();
    }

    private void toString(Node<E> node, StringBuffer sb, String prefix) {
        if (node == null) return;
        sb.append(prefix).append(node.element).append("\n");
        toString(node.left, sb, prefix + "【L】");
        toString(node.right, sb, prefix + "【R】");
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new RuntimeException("element must not be null");
        }
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>) node;
        return "p(" + (myNode.parent == null ? "null" : myNode.parent.element) + ")_" + myNode.element;
    }

    public static interface Visitor<E>{
        void visit(E element);
    }
    private static class Node<E> {
        private E element;
        private Node<E> left;
        private Node<E> right;
        private Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf(){
            return left == null && right == null;
        }

        public boolean hasTwoChildren(){
            return left != null && right != null;
        }
    }
}
