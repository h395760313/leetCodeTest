package com.leetCode._2_两数相加;


import com.leetCode.common.ListNode;
import org.junit.Test;


/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _2_220105 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //res存放结果，curr为res的尾指针
        ListNode res = new ListNode();
        ListNode curr = res;

        // 进位
        int flag = 0;
        while (l1 != null || l2 != null) {
            // 如果其中一个到达结尾了，那么这个链表的值为0
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            // 求和
            int sum = x + y + flag;
            // 创建一个节点接到res的尾部
            curr.next = new ListNode(sum % 10);
            // 计算进位
            flag = sum / 10;

            // 节点后移
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            curr = curr.next;
        }

        // 如果最后还有进位的话，增加一个节点
        if (flag > 0) {
            curr.next = new ListNode(flag);
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
