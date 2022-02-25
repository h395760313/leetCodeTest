package com.algorithm.structure.算法.Morris遍历;

import com.algorithm.leetCode.common.TreeNode;
import org.junit.Test;

/**
 * Morris遍历细节
 * 假设来到当前节点cur，开始时cur来到头节点位置
 * 1)如果cur没有左孩子，cur向右移动(cur = cur.right)
 * 2)如果cur有左孩子，找到左子树上最右的节点mostRight:
 *      a. 如果mostRight的右指针指向空，让其指向cur，然后cur向左移动(cur = cur.left)
 *      b. 如果mostRight的右指针指向cur，让其指向null，然后cur向右移动(cur = cur.right)
 * 3)cur为空时遍历停止
 *
 * @author xiehongyu
 * @date 2022/02/23 16:45
 */
public class Morris {

    public void morris(TreeNode head){
        if (head == null) return;
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {// 有左子树
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight变成cur左子树上最右的节点
                if (mostRight.right == null) { // 这是第一次来到mostRight
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                mostRight.right = null; // mostRight.right == cur
            }
            cur = cur.right;
        }
    }

    public void morrisPre(TreeNode head){
        if (head == null) return;
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {// 有左子树
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight变成cur左子树上最右的节点
                if (mostRight.right == null) { // 这是第一次来到mostRight
                    System.out.print(cur.val + "\t");
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                mostRight.right = null; // mostRight.right == cur
            }else {
                System.out.print(cur.val + "\t");
            }
            cur = cur.right;
        }
    }

    public void morrisIn(TreeNode head){
        if (head == null) return;
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {// 有左子树
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight变成cur左子树上最右的节点
                if (mostRight.right == null) { // 这是第一次来到mostRight
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                mostRight.right = null; // mostRight.right == cur
            }
            System.out.print(cur.val + "\t");
            cur = cur.right;
        }
    }

    public void morrisPost(TreeNode head){
        if (head == null) return;
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {// 有左子树
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight变成cur左子树上最右的节点
                if (mostRight.right == null) { // 这是第一次来到mostRight
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                mostRight.right = null; // mostRight.right == cur
                printEdge(cur.left);
            }
            cur = cur.right;
        }
        printEdge(head);
    }

    private void printEdge(TreeNode x) {
        TreeNode tail = reverseEdge(x);
        TreeNode node = tail;
        while (node != null) {
            System.out.print(node.val + "\t");
            node = node.right;
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



    @Test
    public void test(){
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        morrisPre(node);
        System.out.println();
        morrisIn(node);
        System.out.println();
        morrisPost(node);
    }
    // 1 2 4 5 3 6 7
    // 4 2 5 1 6 3 7
    // 4 5 2 6 7 3 1
}
