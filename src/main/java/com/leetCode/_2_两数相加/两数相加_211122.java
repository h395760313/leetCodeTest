package com.leetCode._2_两数相加;


import com.leetCode.common.ListNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class 两数相加_211122 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;

        int flag = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + flag;
            curr.next = new ListNode(sum  % 10);
            flag = sum / 10;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            curr = curr.next;
        }
        if (flag > 0) {
            curr.next = new ListNode(1);
        }
        return res.next;
    }

    @Test
    public void test() {
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(9);
        listNode1.next.next = new ListNode(9);
        listNode1.next.next = new ListNode(9);
        listNode1.next.next.next = new ListNode(9);
        listNode1.next.next.next.next = new ListNode(9);
        ListNode listNode2 = new ListNode(9);
        listNode2.next = new ListNode(9);
        listNode2.next.next = new ListNode(9);
        listNode2.next.next.next = new ListNode(9);

        System.out.println(addTwoNumbers(listNode1,listNode2));
    }
}
