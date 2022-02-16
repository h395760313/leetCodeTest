package com.algorithm.leetCode._226_翻转二叉树;

import com.algorithm.leetCode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: xiehongyu
 * @Date: 2021/8/19 14:45
 */
public class _226_翻转二叉树_template {
//    public TreeNode invertTree(TreeNode root) {
          // 前序
//        if (root == null) return root;
//        TreeNode temp = root.left;
//        root.left = root.right != null ? root.right : null;
//        root.right = temp != null ? temp : null;
//
//        if (root.left != null) invertTree(root.left);
//        if (root.right != null) invertTree(root.right);
//        return root;
//        // 执行耗时:0 ms,击败了100.00% 的Java用户
//        // 内存消耗:36 MB,击败了22.58% 的Java用户
//    }


//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return root;
//        invertTree(root.left);
//        invertTree(root.right);

//        if (root == null) return root;
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//        return root;
//        // 执行耗时:0 ms,击败了100.00% 的Java用户
//        // 内存消耗:35.9 MB,击败了37.64% 的Java用户
//    }


    public TreeNode invertTree(TreeNode root) {
        // 层序
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
        // 执行耗时:0 ms,击败了100.00% 的Java用户
        // 内存消耗:35.8 MB,击败了65.60% 的Java用户
    }


}
