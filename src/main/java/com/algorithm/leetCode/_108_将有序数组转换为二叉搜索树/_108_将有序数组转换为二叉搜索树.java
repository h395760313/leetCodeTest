package com.algorithm.leetCode._108_将有序数组转换为二叉搜索树;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @author xiehongyu
 * @date 2022/02/07 14:57
 */
public class _108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int begin, int end) {
        if (begin > end) return null;
        int mid = (begin + end) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, begin, mid - 1);
        root.right = dfs(nums, mid + 1, end);
        return root;
    }


    @Test
    public void test() {
        System.out.println(JSON.toJSONString(sortedArrayToBST(new int[]{-10,-3,0,5,9})));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}