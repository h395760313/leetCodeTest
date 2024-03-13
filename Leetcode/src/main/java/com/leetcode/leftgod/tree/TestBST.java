package com.leetcode.leftgod.tree;

import com.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * Binary Search Tree —— 二叉搜索树
 * @Author: xiehongyu
 * @Date: 2024/03/13 18:47
 */
public class TestBST {

    private static int preValue = Integer.MIN_VALUE;

    /**
     * 判断一棵二叉树是否搜索二叉树
     * 搜索二叉树：每棵子树的左树上的所有节点的数都小于头节点
     * @Author: xiehongyu
     * @Date: 2024/3/13 18:52
     */
    public boolean isBST(TreeNode head){
        if (head == null) {
            return true;
        }
        boolean isLeftBST = isBST(head.left);
        if (!isLeftBST) {
            return false;
        }
        if (head.val <= preValue) {
            return false;
        }else {
            preValue = head.val;
        }
        return isBST(head.right);
    }

    public boolean isBST2(TreeNode head){
        if (head == null) {
            return true;
        }
        int preValue = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            }else {
                TreeNode node = stack.pop();
                if (node.val <= preValue) {
                    return false;
                }else {
                    preValue = node.val;
                }
                head = node.right;
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


        System.out.println(isBST(node)); // 5
    }
}
