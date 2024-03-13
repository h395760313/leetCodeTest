package com.leetcode.common;


public class ListNode {

    public int val;

    public ListNode next;   // 下一个链表对象

    public ListNode(int val) {
        this.val = val;
        next = null;
    }  //赋值链表的值

    public static ListNode create(int... val) {
        ListNode node = new ListNode();
        ListNode cur = node;
        for (int v : val) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return node.next;
    }  //赋值链表的值

    public static ListNode next(ListNode node, ListNode nextNode) {
        ListNode cur = node;
        while (cur.next != null ){
            cur = cur.next;
        }
        cur.next = nextNode;
        return node;
    }

    public ListNode() {
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
