package com.algorithm.structure.算法.Morris遍历;

import com.algorithm.leetCode.common.TreeNode;
import com.algorithm.structure._9_堆.Heap;
import org.junit.Test;

/**
 * Morris O(n)时间 O(1)空间 遍历树
 * 1)如果cur没有左子树，cur向右移动(cur = cur.right)
 * 2)如果cur有左子树，mostRight = cur.left
 *      a. 如果mostRight指向null，让mostRight指向cur，cur左移(cur = cur.left)
 *      b. 如果mostRight指向cur，让mostRight指向null，cur右移
 * 3)如果节点为空退出
 * @author xiehongyu
 * @date 2022/02/24 13:34
 */
public class MorrisTest1 {


    public void morris(TreeNode head){
        TreeNode cur = head;
        while (cur != null) {
            TreeNode mostRight = cur.left;
            if (mostRight != null) { // 有左子树
                while (mostRight != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight为cur左子树的左右节点
                if (mostRight.right == null) { // 第一次来到mostRight位置
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                mostRight.right = null; // 第二次来到mostRight位置
            }
            cur = cur.right;
        }
    }


    /**
     * 前序遍历
     * ->如果没有左子树直接打印
     * ->如果有左子树在第一次遇到mostRight时打印
     * @param head
     */
    public void morrisPre(TreeNode head){
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) { // 有左子树
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) { // 第一次遇到mostRight
                    System.out.print(cur.val + "\t");
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                mostRight.right = null;
            }else {
                System.out.print(cur.val + "\t");
            }
            // 没有左子树
            cur = cur.right;
        }
    }

    /**
     * 中序遍历
     * ->如果没有左子树直接打印
     * ->如果有左子树在第二次遇到mostRight时打印
     * @param head
     */
    public void morrisIn(TreeNode head){
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) { // 有左子树
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                System.out.print(cur.val + "\t");
                mostRight.right = null;
            }else {
                System.out.print(cur.val + "\t");
            }
            cur = cur.right;
        }
    }

    /**
     * 后序遍历
     * ->如果有左子树，逆序打印左子树的右子树
     * ->如果没有左子树
     * @param head
     */
    public void morrisPost(TreeNode head){
        if (head == null) return;
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) { // 有左子树
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                mostRight.right = null;
                printEdge(cur.left);
            }
            cur = cur.right;
        }
        printEdge(head);
    }

    private void printEdge(TreeNode x) {
        TreeNode tail = reverseEdge(x);
        TreeNode cur = tail;
        while (cur != null) {
            System.out.print(cur.val + "\t");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    private TreeNode reverseEdge(TreeNode from) {
        TreeNode next = null;
        TreeNode pre = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    public boolean isBST(TreeNode head){
        if (head == null) return true;
        TreeNode cur = head;
        TreeNode mostRight = null;
        int oldValue = Integer.MIN_VALUE;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                mostRight.right = null;
            }
            if (cur.val <= oldValue) {
                return false;
            }
            oldValue = cur.val;
            cur = cur.right;
        }
        return true;
    }

    @Test
    public void test(){
        TreeNode node = new TreeNode(6);
        node.left = new TreeNode(4);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(8);
        node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(9);
        morrisPre(node);
        System.out.println();
        morrisIn(node);
        System.out.println();
        morrisPost(node);
        System.out.println();
        System.out.println(isBST(node));
    }
}
