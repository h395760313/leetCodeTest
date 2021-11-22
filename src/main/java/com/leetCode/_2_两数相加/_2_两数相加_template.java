package com.leetCode._2_两数相加;


import com.leetCode.common.ListNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _2_两数相加_template {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
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
