package com.leetcode.leftgod.tree;

import com.leetcode.common.TreeNode;
import org.junit.Test;

/**
 * full binary tree 满二叉树
 *
 * @Author: xiehongyu
 * @Date: 2024/03/13 22:11
 */
public class TestFBT {

    public boolean isF(TreeNode head) {
        Info info = process(head);
        return info.nodes == (1 << info.height) - 1;
    }

    public Info process(TreeNode head){
        if (head == null) {
            return new Info(0,0);
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info(height, nodes);
    }

    class Info {
        private int height;
        private int nodes;

        public Info(int h, int n) {
            this.height = h;
            this.nodes = n;
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


        System.out.println(isF(node));
    }
}
