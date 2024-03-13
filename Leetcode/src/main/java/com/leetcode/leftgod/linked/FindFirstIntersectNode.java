package com.leetcode.leftgod.linked;

import com.leetcode.common.ListNode;
import org.junit.Test;

/**
 * 寻找两条链表相交的第一个节点
 *
 * @author xiehongyu
 * @date 2024/3/12 11:31
 */
public class FindFirstIntersectNode {

    public ListNode findFirstIntersectNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        } else if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    private ListNode getLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode n1 = head.next;
        ListNode n2 = head.next.next;
        while (n1 != n2) {
            if (n1 == null || n2 == null || n1.next == null || n2.next == null) {
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public ListNode noLoop(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode cur1 = head1;
        ListNode cur2 = head2;

        // 两条链表遍历一遍
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            cur1 = cur1.next;
            n--;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    private ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
        if (loop1 == loop2) {
            return noLoop(head1, head2);
        } else {
            ListNode cur = loop1.next;
            while (cur != loop1) {
                if (loop1 == loop2) {
                    return loop1;
                }
                cur = cur.next;
            }
            return null;
        }
    }


    @Test
    public void test() {
//        ListNode node1 = ListNode.create(1, 2, 3, 4);
//        ListNode node0 = ListNode.create(5, 6, 7, 8);
//        node1 = ListNode.next(node1, node0);
//        ListNode node2 = ListNode.create(-1, -2);
//        node2 = ListNode.next(node2, node0);

        ListNode node1 = ListNode.create(1, 2, 3);
        ListNode node2 = ListNode.create(4);
        ListNode node3 = ListNode.create(5, 6);
        ListNode node4 = ListNode.create(7, 8);
        node4 = ListNode.next(node3, node4);
        node3 = ListNode.next(node4, node2);
        node2 = ListNode.next(node2, node3);
        node1 = ListNode.next(node1, node2);

        ListNode node01 = ListNode.create(4, 1);
        node01 = ListNode.next(node01, node4);

        ListNode firstIntersectNode = findFirstIntersectNode(node01, node1);
        while (firstIntersectNode != null) {
            System.out.println(firstIntersectNode.val);
            firstIntersectNode = firstIntersectNode.next;
        }
    }
}
