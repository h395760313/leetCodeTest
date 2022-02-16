package com.algorithm.leetCode._106_从中序与后序遍历序列构造二叉树;

import com.algorithm.leetCode.common.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiehongyu
 * @Date: 2021/8/19 16:19
 */
public class _106_从中序与后序遍历序列构造二叉树_template {
    Map<Integer,Integer> map = new HashMap<>();
    int[] post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        post = postorder;
        return buildTreeHelper(0, postorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper( int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) return null;

        int rootVal = post[pe];
        TreeNode root = new TreeNode(rootVal);
        int ri = map.get(rootVal);
        root.left = buildTreeHelper(is, ri - 1, ps, ps + ri - is - 1);
        root.right = buildTreeHelper(ri + 1, ie, ps + ri - is, pe - 1);
        return root;
    }

    @Test
    public void test() {
//        buildTree(new int[]{4,2,1,3,6,5},new int[]{1,2,3,4,5,6});
        TreeNode treeNode = buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});

        print(treeNode, "");
    }

    private void print(TreeNode node, String pre) {
        if (node == null) return;
        System.out.println(pre + node.val);
        if (node.left != null) print(node.left, pre + "L");
        if (node.right != null) print(node.right, pre + "R");
    }
}
