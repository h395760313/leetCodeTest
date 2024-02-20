package com.algorithm.leetCode._2_两数相加;


import com.algorithm.leetCode.common.ListNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _2_240217 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode result = null;
        while (l1.next != null || l2.next != null) {
            int sum = l1.val + l2.val;
            result = new ListNode(sum % 10 + flag);
            result = result.next;
            flag = sum / 10;
            l1=l1.next;
            l2=l2.next;
        }
        if (flag > 0) {
            result = new ListNode(flag);
        }

        return result;
    }

    @Test
    public void test() {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(listNode1,listNode2));
    }
}
