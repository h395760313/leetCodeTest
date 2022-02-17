package com.algorithm.leetCode._110_平衡二叉树;

import com.algorithm.leetCode.common.TreeNode;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author xiehongyu
 * @date 2022/02/17 15:06
 */
public class _110_平衡二叉树 {


    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (left >= 0 && right >= 0 && Math.abs(left - right) <= 1) return Math.max(left, right) + 1;
        return -1;
    }


    @Test
    public void test() {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
//        root.right.right.right = new TreeNode(7);
//        root.right.right.right.right = new TreeNode(7);
//
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.left.left = new TreeNode(8);

        System.out.println(JSON.toJSONString(isBalanced(root)));
    }
}
