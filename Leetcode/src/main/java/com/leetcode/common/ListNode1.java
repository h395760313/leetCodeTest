package com.leetcode.common;


public class ListNode1 {

    public int val;

    public ListNode1 rand;

    public ListNode1 next;   // 下一个链表对象

    public ListNode1(int val) {
        this.val = val;
        next = null;
    }  //赋值链表的值

    public ListNode1() {
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
