package com.algorithm.leetCode._98_验证二叉搜索树;

import com.algorithm.leetCode.common.TreeNode;
import org.junit.Test;

/**
 * @author xiehongyu
 * @date 2022/02/24 17:08
 */
public class _98_验证二叉搜索树 {

    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        TreeNode cur = root;
        TreeNode mostRight = null;
        long oldValue = Long.MIN_VALUE;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                // 表示有左子树
                // 寻找最右节点
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) { // 第一次遇到这个最右节点
                    mostRight.right = cur; // 指针指向cur
                    cur = cur.left; // 左移
                    continue;
                }
                mostRight.right = null;// 第二次遇到这个最右节点，说明当前指针已经指向cur，指针指向null
            }
            if (cur.val <= oldValue) {
                return false;
            }
            oldValue = cur.val;
            cur = cur.right; // 右移
        }
        return true;
    }


    public boolean test1(int x){
        System.out.println(x & (x - 1));
        return (x & (x - 1)) == 0;
    }
    @Test
    public void test(){
//        TreeNode node = new TreeNode(5);
//        node.left = new TreeNode(1);
//        node.right = new TreeNode(4);
//        node.right.left = new TreeNode(3);
//        node.right.right = new TreeNode(6);
//        System.out.println(isValidBST(node));


        System.out.println(test1(8));
    }
}
