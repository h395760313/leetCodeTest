package com.structure.e_树.a_二叉树;

import com.structure.e_树.OrderTypeEnum;
import com.structure.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: xiehongyu
 * @Date: 2021/8/17 18:37
 */
public class BinaryTree<E> implements BinaryTreeInfo {

    protected int size;
    protected Node<E> root;

    public BinaryTree() {}

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * 遍历
     * @param orderType
     * @param visitor
     */
    public void visit(int orderType, Visitor<E> visitor) {
        if (orderType == OrderTypeEnum.Preorder.index) {
            preorderVisit(root, visitor);
        } else if (orderType == OrderTypeEnum.inorder.index) {
            inorderVisit(root,visitor);
        } else if (orderType == OrderTypeEnum.postorder.index) {
            postorderVisit(root, visitor);
        } else if (orderType == OrderTypeEnum.levelorder.index) {
            levelorderVisit(visitor);
        }
    }

    /**
     * 前序遍历
     * @param node
     */
    protected void preorderVisit(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;
        visitor.visit(node.element);
        preorderVisit(node.left, visitor);
        preorderVisit(node.right, visitor);
    }

    /**
     * 中序遍历
     * @param node
     */
    protected void inorderVisit(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;
        inorderVisit(node.left, visitor);
        visitor.visit(node.element);
        inorderVisit(node.right, visitor);
    }

    /**
     * 后序遍历
     * @param node
     */
    protected void postorderVisit(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;
        postorderVisit(node.left, visitor);
        postorderVisit(node.right, visitor);
        visitor.visit(node.element);
    }

    /**
     * 层序遍历
     * @param visitor
     */
    public void levelorderVisit(Visitor<E> visitor){
        if (root == null || visitor.stop) return;
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
    protected int height2(Node<E> node){
        if (node == null) return 0;
        return 1 + Math.max(height2(node.left), height2(node.right));
    }

    protected void toString(Node<E> node, StringBuffer sb, String prefix) {
        if (node == null) return;
        sb.append(prefix).append(node.element).append("\n");
        toString(node.left, sb, prefix + "【L】");
        toString(node.right, sb, prefix + "【R】");
    }

    /**
     * 前驱节点
     * @param node
     * @return
     */
    protected Node<E> getPredecessor(Node<E> node){
        // 左节点不为空 node = left.right.right.right.....
        Node<E> pre = node.left;
        if (pre != null) {
            while (pre.right != null){
                pre = pre.right;
            }
            return pre;
        }

        // 从祖父节点找前驱节点 node = parent.parent.parent... 直到节点为父节点的右节点停止
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }
    /**
     * 后驱节点
     * @param node
     * @return
     */
    protected Node<E> getPostdecessor(Node<E> node){
        // 左节点不为空 node = right.left.left.left.....
        Node<E> post = node.right;
        if (post != null) {
            while (post.left != null){
                post = post.left;
            }
            return post;
        }

        // 从祖父节点找前驱节点 node = parent.parent.parent... 直到节点为父节点的左节点停止
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
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

    public static abstract class Visitor<E>{
        boolean stop;
        /**
         *  返回false则退出遍历
         */
        abstract boolean visit(E element);
    }
    protected static class Node<E> {
        protected E element;
        protected Node<E> left;
        protected Node<E> right;
        protected Node<E> parent;

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

        @Override
        public String toString() {
            return element + "";
        }
    }
}
