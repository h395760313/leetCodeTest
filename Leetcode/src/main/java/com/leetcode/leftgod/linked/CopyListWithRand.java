package com.leetcode.leftgod.linked;

import com.leetcode.common.ListNode1;
import org.junit.Test;

import java.util.HashMap;

/**
 * 复制链表
 *
 * @author xiehongyu
 * @date 2024/3/12 09:56
 */
public class CopyListWithRand {


    public ListNode1 copyListWithRand1(ListNode1 head) {
        HashMap<ListNode1, ListNode1> map = new HashMap<>();
        ListNode1 cur = head;
        while (cur != null) {
            map.put(cur, new ListNode1(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).rand = map.get(cur.rand);
            map.get(cur).next = map.get(cur.next);
            cur = cur.next;
        }
        return map.get(head);
    }

    public ListNode1 copyListWithRand2(ListNode1 head) {
        ListNode1 cur = head;

        while (cur != null) {
            ListNode1 next = cur.next;
            cur.next = new ListNode1(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            cur.next.rand = cur.rand == null ? null : cur.rand.next;
            cur = cur.next.next;
        }
        cur = head;
        ListNode1 res = head.next;
        ListNode1 resCur = res;
        while (cur != null && cur.next != null) {
            ListNode1 next = cur.next.next;
            resCur.next = cur.next;
            cur.next = next;
            cur = next;
            resCur = resCur.next;
        }
        return res;
    }

    @Test
    public void test() {
        ListNode1 node = new ListNode1(1);
        ListNode1 node2 = new ListNode1(2);
        ListNode1 node3 = new ListNode1(3);
        node.rand = node3;
        node.next = node2;
        node2.rand = node;
        node2.next = node3;
        ListNode1 res = copyListWithRand2(node);
        while (res != null) {
            System.out.println("val:" + res.val + ", rand::" + res.rand);
            res = res.next;
        }
    }
}
