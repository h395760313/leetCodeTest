package com.algorithm.leetCode._105_从前序与中序遍历序列构造二叉树;

import com.algorithm.leetCode.common.TreeNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @Author: xiehongyu
 * @Date: 2021/8/19 16:18
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 */
public class _105_从前序与中序遍历序列构造二叉树_template {


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTreeHelper(preorder, inorder, Integer.MAX_VALUE);
    }

    int pre = 0;
    int in = 0;

    private TreeNode buildTreeHelper( int[] preorder, int[] inorder, int stop) {

        if (pre == preorder.length) {
            return null;
        }
        if (inorder[in] == stop){
            in++;
            return null;
        }

        int rootVal = preorder[pre++];
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeHelper(preorder, inorder, rootVal);
        root.right = buildTreeHelper(preorder, inorder, stop);
        return root;
    }


    @Test
    public void test() {
//        buildTree(new int[]{4,2,1,3,6,5},new int[]{1,2,3,4,5,6});
        TreeNode treeNode = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

        print(treeNode, "");
    }

    private void print(TreeNode node, String pre) {
        if (node == null) return;
        System.out.println(pre + node.val);
        if (node.left != null) print(node.left, pre + "L");
        if (node.right != null) print(node.right, pre + "R");
    }
}
