package com.algorithm.leetCode._160_相交链表;

import com.algorithm.leetCode.common.ListNode;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author xiehongyu
 * @date 2022/02/25 12:07
 */
public class _160_相交链表_template {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        ListNode tailA = reverse(curA);
        ListNode tailB = reverse(curB);
        while (tailA.val == tailB.val) {
            tailA = tailA.next;
            tailB = tailB.next;
        }
        while (tailA != null) {
            tailA = tailA.next;
        }
        curA = reverse(curA);
        while (tailB != null && curA != null) {
            tailB = tailB.next;
            curA = curA.next;
        }
        return curA;
    }

    private ListNode reverse(ListNode from){
        ListNode next = null;
        ListNode pre = null;
        while (from != null) {
            next = from.next;
            from.next = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    @Test
    public void test() {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(1);
        listNode1.next.next.next = new ListNode(3);
        listNode1.next.next.next.next = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode2.next = new ListNode(36);
        listNode2.next.next = new ListNode(1);
        listNode2.next.next.next = new ListNode(3);
        listNode2.next.next.next.next = new ListNode(2);
        System.out.println(JSON.toJSONString(getIntersectionNode(listNode1, listNode2)));
    }
}
