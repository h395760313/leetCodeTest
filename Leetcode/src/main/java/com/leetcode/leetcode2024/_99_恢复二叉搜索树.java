package com.leetcode.leetcode2024;

import com.leetcode.common.Node;
import com.leetcode.common.TreeNode;
import com.leetcode.leftgod.tree.PreInPosTraversal;
import org.junit.Test;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/recover-binary-search-tree/description/
 * @Author: xiehongyu
 * @Date: 2024/03/21 3:43
 */
public class _99_恢复二叉搜索树 {

    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode errNode = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if (pre != null && node.val < pre.val) {
                if (errNode == null) {
                    errNode = pre;
                }
                int temp = node.val;
                node.val = errNode.val;
                errNode.val = temp;
                break;
            }
            pre = node;
            cur = node.right;
        }
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(6);
        node.left = new TreeNode(3);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(9);
        node.left.right.left = new TreeNode(2);
        recoverTree(node);
        PreInPosTraversal.inOrderRecur(node);
    }
}
