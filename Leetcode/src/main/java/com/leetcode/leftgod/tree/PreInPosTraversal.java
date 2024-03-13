package com.leetcode.leftgod.tree;

import com.leetcode.common.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @author xiehongyu
 * @date 2024/3/12 16:14
 */
public class PreInPosTraversal {


    /**
     * 递归方式 前、中、后序遍历
     */
    public void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + "_");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.val + "_");
        inOrderRecur(head.right);
    }

    public void posOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.val + "_");
    }


    /**
     * 非递归方式 前、中、后序遍历
     */
    public void preOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + "_");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历
     * 1）先将所有左节点压入栈
     * 2）弹出时打印
     * 3）将弹出节点的所有左节点压入栈
     * @param head
     */
    public void inOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                System.out.print(head.val + "_");
                head = head.right;
            }
        }
    }

    /**
     * 后序遍历（头-左-右）
     * 1）使用两个栈，一个存储栈，一个收集栈
     * 2）将头节点压入存储栈
     * 3）弹出节点，压入收集栈
     * 4）将弹出节点按照左-右的顺序压入存储栈
     *
     * @param head
     */
    public void posOrderUnRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + "_");
        }
    }

    @Test
    public void test() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        System.out.println("\n前序：");
        preOrderRecur(node);
        System.out.println("\n前序：");
        preOrderUnRecur(node);
        System.out.println("\n中序：");
        inOrderRecur(node);
        System.out.println("\n中序：");
        inOrderUnRecur(node);
        System.out.println("\n后序：");
        posOrderRecur(node);
        System.out.println("\n后序：");
        posOrderUnRecur(node);
    }
}
