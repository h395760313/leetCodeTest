package com.leetCode._83_删除排序链表中的重复元素;

import com.leetCode.common.ListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @Author: xiehongyu
 * @Date: 2021/7/21 18:14
 */
public class _83_删除排序链表中的重复元素_template {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        Map map = new HashMap<Integer,Integer>();
        ListNode res = new ListNode();
        ListNode listNode = res;
        while (head != null) {
            if (!map.containsKey(head.val)) {
                map.put(head.val,1);
                listNode.next = new ListNode(head.val);
                listNode = listNode.next;
            }
            head = head.next;
        }
        return res.next;
    }

    @Test
    public void test() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(7);
        listNode.next.next.next.next = new ListNode(7);
//        listNode.next.next.next.next.next = new ListNode(4);
//        listNode.next.next.next.next.next.next = new ListNode(5);
//        listNode.next.next.next.next.next.next.next = new ListNode(6);
        System.out.println(deleteDuplicates(listNode));
    }
}
