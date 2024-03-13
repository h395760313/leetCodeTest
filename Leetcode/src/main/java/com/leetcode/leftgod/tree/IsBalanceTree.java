package com.leetcode.leftgod.tree;

import com.leetcode.common.TreeNode;
import org.junit.Test;

/**
 * @Author: xiehongyu
 * @Date: 2024/03/13 21:25
 */
public class IsBalanceTree {

    public boolean isBalanceTree(TreeNode head){
        return process(head).isBalance;
    }

    public Info process(TreeNode head){
        if (head == null) {
            return new Info(0, true);
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalance = leftInfo.isBalance && rightInfo.isBalance && Math.abs(leftInfo.height - rightInfo.height) < 2;
        return new Info(height, isBalance);
    }

    class Info {
        private int height;
        private boolean isBalance;

        public Info(int height, boolean isBalance){
            this.height = height;
            this.isBalance = isBalance;
        }
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


        System.out.println(isBalanceTree(node));
    }
}
