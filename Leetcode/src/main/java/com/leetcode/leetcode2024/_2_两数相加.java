package com.leetcode.leetcode2024;


import com.leetcode.common.ListNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _2_两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode temp = res;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + flag;
            flag = sum / 10;
            temp.next = new ListNode(sum % 10);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (flag > 0) {
            temp.next = new ListNode(flag);
        }
        return res.next;
    }

    /**
     * 两数相减
     * @param l1
     * @param l2
     * @return
     */
    public ListNode subTwoNumber(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode temp = node;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sub = x - y;
            flag = sub < 0 ? -1 : 0;
            temp.next = new ListNode(Math.abs(sub));
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            temp = temp.next;
        }
        ListNode res;
        if (flag < 0) {
            res = new ListNode(flag);
            res.next = node.next;
            return res;
        }
        res = node;
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
