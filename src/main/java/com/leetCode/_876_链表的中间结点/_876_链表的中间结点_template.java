package com.leetCode._876_链表的中间结点;

import com.leetCode.common.ListNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @Author: xiehongyu
 * @Date: 2021/7/21 18:26
 */
public class _876_链表的中间结点_template {
    
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        int len = 0;
        ListNode res = new ListNode();
        ListNode node = res;
        ListNode temp = head;

        while (temp != null) {
            len ++;
            temp = temp.next;
        }
        for (int i = 0; i < len; i++) {
            if (i >= len/2){
                node.next = new ListNode(head.val);
                node = node.next;
            }
            head = head.next;
        }
        return res.next;
    }


    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
//        listNode.next.next.next.next.next = new ListNode(4);
//        listNode.next.next.next.next.next.next = new ListNode(5);
//        listNode.next.next.next.next.next.next.next = new ListNode(6);
        System.out.println(middleNode(listNode));
    }
}
