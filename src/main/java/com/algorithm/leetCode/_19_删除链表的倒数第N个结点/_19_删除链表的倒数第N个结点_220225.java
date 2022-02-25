package com.algorithm.leetCode._19_删除链表的倒数第N个结点;

import com.algorithm.leetCode.common.ListNode;
import com.algorithm.leetCode.common.TreeNode;
import com.algorithm.structure.inter.List;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @author xiehongyu
 * @date 2022/02/21 16:20
 */
public class _19_删除链表的倒数第N个结点_220225 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tail = reverseNode(head);
        if (n == 1) {
            tail = tail.next;
            return reverseNode(tail);
        }
        ListNode cur = tail;
        for (int i = 1; i < n - 1 && cur != null; i++) {
            cur = cur.next;
        }
        if (cur != null) {
            if (cur.next != null){
                cur.next = cur.next.next;
            }else {
                cur.next = null;
            }
        }
        ListNode listNode = reverseNode(tail);
        return listNode;
    }

    private ListNode reverseNode(ListNode from){
        if (from == null) return from;
        ListNode next = null;
        ListNode pre = null;

        while (from != null) {
            next = from.next;
            from.next = pre;
            pre = from;
            from = next;
        }
        return pre;
    }


    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
        System.out.println(JSON.toJSONString(removeNthFromEnd(listNode, 1)));
    }
}
