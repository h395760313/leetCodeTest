package com.algorithm.leetCode._19_删除链表的倒数第N个结点;

import com.algorithm.leetCode.common.ListNode;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @author xiehongyu
 * @date 2022/02/21 16:20
 */
public class _19_删除链表的倒数第N个结点_220222 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }

        curr = head;
        if (n == count) return head.next;
        for (int i = n + 1; i < count; i++) {
            curr = curr.next;
        }
        curr.next = n == 1 ? null : curr.next.next;
        return head;
    }



    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        System.out.println(JSON.toJSONString(removeNthFromEnd(listNode, 2)));
    }
}
