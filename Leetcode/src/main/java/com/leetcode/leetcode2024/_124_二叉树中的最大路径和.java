package com.leetcode.leetcode2024;

import com.leetcode.common.TreeNode;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/
 *
 * @Author: xiehongyu
 * @Date: 2024/03/20 23:27
 */
public class _124_二叉树中的最大路径和 {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        process(root);
        return max;
    }

    private int process(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMax = Math.max(0, process(node.left));
        int rightMax = Math.max(0, process(node.right));
        max = Math.max(leftMax + rightMax + node.val, max);
        return Math.max(leftMax, rightMax) + node.val;
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(-10);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(-15);
        node.right.right = new TreeNode(7);
        System.out.println(maxPathSum(node));
    }
}
