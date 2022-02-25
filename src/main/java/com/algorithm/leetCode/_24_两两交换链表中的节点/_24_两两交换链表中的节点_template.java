package com.algorithm.leetCode._24_两两交换链表中的节点;

import com.algorithm.leetCode.common.ListNode;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @author xiehongyu
 * @date 2022/02/16 16:56
 */
public class _24_两两交换链表中的节点_template {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        System.out.println(JSON.toJSONString(swapPairs(listNode)));
    }
}
