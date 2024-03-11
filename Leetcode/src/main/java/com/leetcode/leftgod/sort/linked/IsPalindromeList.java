package com.leetcode.leftgod.sort.linked;

import com.leetcode.common.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @author xiehongyu
 * @date 2024/3/11 15:08
 */
public class IsPalindromeList {


    public boolean isPalindrome1(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = l;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        while (l != null) {
            if (l.val != stack.pop()) {
                return false;
            }
            l = l.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode l) {

        ListNode fast = l;
        ListNode slow = l;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode node = slow;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            if (l.val != stack.pop()) {
                return false;
            }
            l = l.next;
        }
        return true;
    }

    public boolean isPalindrome3(ListNode l) {
        ListNode n1 = l;
        ListNode n2 = l;
        while (n2 != null && n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        ListNode n3 = null;
        n1.next = null;
        while (n2!=null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n2 = l;
        n3 = n1;
        while (n2 != null && n1 != null) {
            if (n2.val != n1.val) {
                return false;
            }
            n2 = n2.next;
            n1 = n1.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return true;
    }


    @Test
    public void test() {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(2);
        l.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome3(l));
    }
}
