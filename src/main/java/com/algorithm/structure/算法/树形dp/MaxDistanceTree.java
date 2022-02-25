package com.algorithm.structure.算法.树形dp;

import com.algorithm.leetCode.common.TreeNode;
import com.algorithm.structure._5_树.printer.Printer;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author xiehongyu
 * @date 2022/02/23 10:27
 */
public class MaxDistanceTree {

    public static class Info{
        int distance;
        int height;

        public Info() {
        }

        public Info(int distence, int height) {
            this.distance = distence;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "distance=" + distance +
                    ", height=" + height +
                    '}';
        }
    }

    public Info getMaxDistance(TreeNode root){
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = getMaxDistance(root.left);
        Info rightInfo = getMaxDistance(root.right);
        int p1 = leftInfo.distance; // root不参与 左最长
        int p2 = rightInfo.distance; // root不参与 右最长
        int p3 = leftInfo.height + rightInfo.height + 1;
        int maxDistance = Math.max(Math.max(p1, p2), p3);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(maxDistance, height);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(1);
        root.left.left.left.left = new TreeNode(1);
        root.left.left.left.left.left = new TreeNode(1);
        root.left.left.left.left.left.left = new TreeNode(1);
        root.left.left.left.left.left.left.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.right = new TreeNode(1);
        root.right.right.right.right = new TreeNode(1);
        root.right.right.right.right.right = new TreeNode(1);
        root.right.right.right.right.right.right = new TreeNode(1);
        root.right.right.right.right.right.right.right = new TreeNode(1);

        System.out.println(getMaxDistance(root));
    }
}
