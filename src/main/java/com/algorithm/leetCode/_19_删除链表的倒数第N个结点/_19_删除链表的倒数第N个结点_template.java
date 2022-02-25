package com.algorithm.leetCode._19_删除链表的倒数第N个结点;

import com.algorithm.leetCode.common.ListNode;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @author xiehongyu
 * @date 2022/02/21 16:20
 */
public class _19_删除链表的倒数第N个结点_template {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        if (count == 1) return null;
        if (count == n) {
            head = head.next;
            return head;
        }
        curr = head;
        for (int i = 1; i < count - n; i++) {
            curr = curr.next;
        }
        ListNode next = curr.next;
        curr.next = curr.next.next;
        if (n != 1) next.next = null;
        return head;
    }



    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        System.out.println(JSON.toJSONString(removeNthFromEnd(listNode, 2)));
    }
}
