package com.leetcode.leftgod.tree;

import com.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Complete Binary Tree —— 完全二叉树
 *
 * @Author: xiehongyu
 * @Date: 2024/3/13 19:19
 */
public class TestCBT {

    /**
     * 判断一棵二叉树是否搜索二叉树
     * 搜索二叉树：每棵子树的左树上的所有节点的数都小于头节点
     *
     * @Author: xiehongyu
     * @Date: 2024/3/13 18:52
     */
    public boolean isCBT(TreeNode head) {
        if (head == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leaf = false;
        queue.add(head);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode l = node.left;
            TreeNode r = node.right;

            if ((l == null && r != null)
                    || (leaf && (l != null || r != null))) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(7);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(8);
        node.left.left.left = new TreeNode(1);


        System.out.println(isCBT(node));
    }
}
