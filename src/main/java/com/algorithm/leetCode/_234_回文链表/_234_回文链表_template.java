package com.algorithm.leetCode._234_回文链表;

import com.algorithm.leetCode.common.ListNode;
import com.alibaba.fastjson.JSON;
import javafx.application.Preloader;
import org.junit.Test;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * @author xiehongyu
 * @date 2022/02/25 11:20
 */
public class _234_回文链表_template {


    /**
     * 栈
     * @param head
     * @return
     */
    public boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head!= null && !stack.empty()) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode q = head;
        ListNode s = head;
        while (q != null && q.next != null) {
            s = s.next;
            q = q.next.next;
        }
        ListNode tail = reverseNode(s); // 翻转链表
        ListNode tailCur = tail;
        ListNode headCur = head;

        while (tailCur != null && headCur != null) {
            if (tailCur.val != headCur.val) return false;
            tailCur = tailCur.next;
            headCur = headCur.next;
        }
        reverseNode(tail); // 恢复链表
        return true;
    }

    private ListNode reverseNode(ListNode from){
        ListNode pre = null;
        ListNode next = null;
        while(from != null) {
            next = from.next;
            from.next = pre;
            pre = from;
            from = next;
        }
        return pre;
    }


    @Test
    public void test() {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(2);
        System.out.println(JSON.toJSONString(isPalindrome(listNode)));
    }

}
