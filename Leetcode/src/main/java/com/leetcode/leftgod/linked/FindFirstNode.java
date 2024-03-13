package com.leetcode.leftgod.linked;

import com.leetcode.common.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 寻找循环单链表的第一个循环节点
 * @author xiehongyu
 * @date 2024/3/12 11:31
 */
public class FindFirstNode {

    public ListNode findFirstNode1(ListNode head){
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }

    public ListNode findFirstIntersectNode2(ListNode head){
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        // 快慢指针
        ListNode n1 = head.next;
        ListNode n2 = head.next.next;
        // 找到第一次相遇节点
        while (n1 != n2) {
            if (n1.next == null || n2.next == null) {
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // 快指针从头出发，两个指针同时一次一步，相遇即第一个环节点
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }


    @Test
    public void test() {
        System.out.println();
    }
}
