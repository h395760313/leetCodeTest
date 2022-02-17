package com.algorithm.leetCode._101_对称二叉树;

import com.algorithm.leetCode.common.TreeNode;
import com.algorithm.structure._1_动态数组.ArrayList;
import com.algorithm.structure.inter.List;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author xiehongyu
 * @date 2022/02/17 15:49
 */
public class _101_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        left(root.left, left);
        right(root.right, right);

        if (left.size() != right.size()) return false;
        for (int i = 0; i < left.size(); i++) {
            if (left.get(i) != right.get(i)) return false;
        }
        return true;
    }

    private void left(TreeNode root, List<Integer> left) {
        if (root == null) {
            left.add(0);
            return;
        }
        left.add(root.val);
        left(root.left, left);
        left(root.right, left);
    }

    private void right(TreeNode root, List<Integer> right) {
        if (root == null) {
            right.add(0);
            return;
        }
        right.add(root.val);
        left(root.right, right);
        left(root.left, right);
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

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(JSON.toJSONString(isSymmetric(root)));
    }
}
