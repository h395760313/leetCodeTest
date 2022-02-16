package com.algorithm.leetCode.common;


public class ListNode {

    public int val;

    public ListNode next;   // 下一个链表对象

    public ListNode(int val) {
        this.val = val;
    }  //赋值链表的值

    public ListNode() {
    }

    @Override
    public String toString() {
        return "{" +val + ", " + next +'}';
    }
}
