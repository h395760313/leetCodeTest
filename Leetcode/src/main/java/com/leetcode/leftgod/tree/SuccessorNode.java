package com.leetcode.leftgod.tree;

import com.leetcode.common.TreeNode;
import org.junit.Test;

/**
 * 后继节点
 *
 * @author xiehongyu
 * @date 2024/3/14 09:09
 */
public class SuccessorNode {

    /**
     * 自写版本
     *
     * @param node
     * @return
     */
    public TreeNode getSuccessorNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        }
        TreeNode cur = node;
        while (cur != null && cur.parent != null && cur != cur.parent.left) {
            cur = cur.parent;
        }
        if (cur == null || cur.parent == null) {
            return null;
        }
        return cur.parent;
    }

    private TreeNode getLeftMost(TreeNode node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * 优化版本
     *
     * @param node
     * @return
     */
    public TreeNode getSuccessorNode2(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        }
        TreeNode parent = node.parent;
        while (parent != null && parent != parent.left) {
            node = parent;
            parent = node.parent;
        }
        return parent;
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.parent = node;
        node.right = new TreeNode(3);
        node.right.parent = node;
        node.left.left = new TreeNode(4);
        node.left.left.parent = node.left;
        node.left.right = new TreeNode(5);
        node.left.right.parent = node.left;
        node.right.left = new TreeNode(6);
        node.right.left.parent = node.right;
        node.right.right = new TreeNode(7);
        node.right.right.parent = node.right;


        System.out.println(getSuccessorNode(node.right));
    }
}
