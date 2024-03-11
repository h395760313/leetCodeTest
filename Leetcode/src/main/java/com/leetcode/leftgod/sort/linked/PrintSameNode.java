package com.leetcode.leftgod.sort.linked;

import com.leetcode.common.ListNode;
import org.junit.Test;

/**
 * @author xiehongyu
 * @date 2024/3/11 14:54
 */
public class PrintSameNode {

    public void printSameNode(ListNode l1, ListNode l2){
        while (l1!= null || l2!=null) {
            int v1 = l1.val;
            int v2 = l2.val;
            if (v1 == v2) {
                System.out.println(v1);
                l1 = l1.next;
                l2 = l2.next;
            }else if (v1 < v2) {
                l1 = l1.next;
            }else {
                l2 = l2.next;
            }
        }
    }


    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(0);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(5);
        printSameNode(l1, l2);
    }
}
