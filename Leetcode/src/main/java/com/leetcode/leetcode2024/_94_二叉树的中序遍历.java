package com.leetcode.leetcode2024;

import com.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * @Author: xiehongyu
 * @Date: 2024/03/22 0:05
 */
public class _94_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        return dp(root, res);
    }

    public List<Integer> dp(TreeNode root, List<Integer> res){
        if (root == null) {
            return null;
        }
        dp(root.left, res);
        res.add(root.val);
        dp(root.right, res);
        return res;
    }
    @Test
    public void test() {

    }
}
