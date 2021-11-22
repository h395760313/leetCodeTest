package com.leetCode._203_移除链表元素;

import com.leetCode.common.ListNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @Author: xiehongyu
 * @Date: 2021/7/21 17:57
 */
public class _203_移除链表元素_template {
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode();
        ListNode listNode = res;
        while ( head != null ) {
            if (head.val != val) {
                listNode.next = new ListNode(head.val);
                listNode = listNode.next;
            }
            head = head.next;
        }
        return res.next;

        /*while ( head!=null ) {
            if (head.val == val) {
                head.next = head.next.next;
                head = head.next;
            }
            head = head.next;
        }
        return head;*/
    }

    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(6);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next.next = new ListNode(6);
        System.out.println(removeElements(listNode,6));
    }
}
