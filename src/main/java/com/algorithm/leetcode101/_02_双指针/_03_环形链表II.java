package com.algorithm.leetcode101._02_双指针;

import com.algorithm.leetCode.common.ListNode;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 * @Author: xiehongyu
 * @Date: 2022/05/10 12:47
 */
public class _03_环形链表II {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode cur = head;
                while (cur != fast) {
                    cur = cur.next;
                    fast = fast.next.next;
                }
                return cur;
            }
        }
        return null;
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(JSON.toJSONString(detectCycle(node1)));
    }
}
