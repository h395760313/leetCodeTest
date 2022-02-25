package com.algorithm.leetCode._124_二叉树中的最大路径和;

import com.algorithm.leetCode.common.TreeNode;
import org.junit.Test;

/**
 * @author xiehongyu
 * @date 2022/02/23 11:12
 */
public class _124_二叉树中的最大路径和 {

    public int maxPathSum(TreeNode root) {
        return getTreeInfo(root).distance;
    }

    private Info getTreeInfo(TreeNode root){
        if (root == null) return new Info(0,0);
        Info leftInfo = getTreeInfo(root.left);
        Info rightInfo = getTreeInfo(root.right);
        // info
        int p1 = leftInfo.distance;
        int p2 = rightInfo.distance;
        int p3 = leftInfo.height + rightInfo.height + 1;
        int maxDistance = Math.max(Math.max(p1, p2), p3);
        int maxHeight = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(maxDistance, maxHeight);
    }

    public static class Info{
        int distance;
        int height;
        public Info() {
        }
        public Info(int distance, int height) {
            this.distance = distance;
            this.height = height;
        }
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(maxPathSum(root));
    }

}
