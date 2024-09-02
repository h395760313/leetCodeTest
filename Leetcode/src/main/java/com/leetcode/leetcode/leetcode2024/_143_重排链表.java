package com.leetcode.leetcode.leetcode2024;

import com.leetcode.common.ListNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author xiehongyu
 * @date 2024/3/15 14:20
 */
public class _143_重排链表 {


    public void reorderList1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;

        cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    /**
     * 1->2->3->4->5    ->   1->5->4->3->2
     *
     * @param head
     */
    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode cur = head.next;
        ListNode next = cur.next;
        ListNode N = null;
        cur.next = null;
        while (next != null) {
            N = next.next;
            next.next = cur;
            cur = next;
            next = N;
            head.next = cur;
        }

        cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    /**
     * 1->2->3->4->5  ->  1->5->2->3->4
     *
     * @param head
     */
    public void reorderList3(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode cur = head;
        ListNode next = null;
        while (cur.next != null) {
            next = cur.next;
            if (cur.next.next == null) {
                cur.next = null;
            }
            cur = next;
        }
        next = head.next;
        head.next = cur;
        cur.next = next;

        cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    /**
     * 题目做法
     * 1->2->3->4->5  ->  1->5->3->2->4
     *
     * @param head
     */
    public void reorderList4(ListNode head) {
        if (head == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
            len++;
        }
        cur = head;
        Queue<ListNode> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                queue.add(cur);
                cur = cur.next;
            } else {
                queue.add(stack.pop());
            }
        }
        ListNode pre = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (pre == null) {
                pre = cur;
                continue;
            }
            pre.next = cur;
            pre = pre.next;
        }
        cur.next = null;

        cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    /**
     * 题目做法
     * 1->2->3->4->5  ->  1->5->3->2->4
     *
     * @param head
     */
    public void reorderList5(ListNode head) {
        if (head == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = head;
        ListNode pop = stack.pop();
        ListNode next = null;
        while (cur != null && cur != pop) {
            next = cur.next;
            cur.next = pop;
            pop.next = next;
            cur = next;
            if (next == pop) {
                break;
            }
            pop = stack.pop();
        }
        cur.next = null;

        cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;


        reorderList5(n1);
    }
}
