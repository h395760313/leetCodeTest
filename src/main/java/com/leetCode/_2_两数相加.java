package com.leetCode;


import com.leetCode.common.ListNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _2_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode listNode = res;
        int flag = 0;

        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int sum = x + y + flag;
            flag = sum / 10;
            listNode.next = new ListNode(sum % 10);

            listNode = listNode.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (flag > 0) {
            listNode.next = new ListNode(1);
        }
        return res.next;
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
