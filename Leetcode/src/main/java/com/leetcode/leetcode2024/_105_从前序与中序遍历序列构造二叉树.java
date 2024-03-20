package com.leetcode.leetcode2024;

import com.leetcode.common.ListNode;
import com.leetcode.common.TreeNode;
import com.leetcode.leftgod.tree.PreInPosTraversal;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @Author: xiehongyu
 * @Date: 2024/03/21 0:39
 */
public class _105_从前序与中序遍历序列构造二叉树 {


    Map<Integer, Integer> map = new HashMap<>();
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.preorder = preorder;
        return process(0, 0, inorder.length - 1);
    }

    private TreeNode process(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);
        int i = map.get(preorder[root]); // root节点在中序遍历中的位置
        node.left = process(root + 1, left, i - 1);
        node.right = process(i - left + root + 1, i + 1, right);
        return node;
    }

    @Test
    public void test() {
        // 3,9,7,6,5,11,20,15,10,8,1,2
        // 7,9,5,6,11,3,15,10,20,1,8,2
        TreeNode node = buildTree(new int[]{3, 9, 7, 6, 5, 11, 20, 15, 10, 8, 1, 2}, new int[]{7, 9, 5, 6, 11, 3, 15, 10, 20, 1, 8, 2});
        PreInPosTraversal.preOrderRecur(node);
        System.out.println();
        PreInPosTraversal.inOrderRecur(node);
        System.out.println();
        PreInPosTraversal.sequenceTraversal(node);
    }
}
