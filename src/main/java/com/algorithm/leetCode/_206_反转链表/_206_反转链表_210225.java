package com.algorithm.leetCode._206_反转链表;

import com.algorithm.leetCode.common.ListNode;
import com.algorithm.structure.inter.List;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _206_反转链表_210225 {



    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    @Test
    public void test() {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(4);
        System.out.println(JSON.toJSONString(reverseList(listNode)));
    }

}
