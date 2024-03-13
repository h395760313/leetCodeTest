package com.leetcode.leftgod.linked;

import com.leetcode.common.ListNode;
import org.junit.Test;

/**
 * 链表小于左边，等于中间，大于右边
 * @author xiehongyu
 * @date 2024/3/11 15:08
 */
public class SmallEqualBigger {


    public void smallEqualBigger1(ListNode head, int target) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        cur = head;
        ListNode[] arr = new ListNode[len];
        int i  = 0;
        while (cur != null) {
            arr[i++] = new ListNode(cur.val);
            cur = cur.next;
        }
        partition(arr, 0, len -1, target);
        i = 0;
        cur = head;
        while (cur != null) {
            cur.val = arr[i++].val;
            cur = cur.next;
        }
    }

    private void partition(ListNode[] arr, int l, int r, int target) {
        int i = l;
        int j = r;
        while (l <= j) {
            if (arr[l].val < target) {
                swap(arr, i++, l++);
            }else if (arr[l].val > target) {
                swap(arr, j--, l);
            }else {
                l++;
            }
        }
    }

    private void swap(ListNode[] arr, int i, int j) {
        ListNode temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public ListNode smallEqualBigger2(ListNode head, int target) {
        ListNode sh = null;
        ListNode st = null;
        ListNode eh = null;
        ListNode et = null;
        ListNode bh = null;
        ListNode bt = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < target) {
                if (sh == null) {
                    sh = head;
                    st = head;
                }else {
                    st.next = head;
                    st = head;
                }
            }else if (head.val > target) {
                if (bh == null) {
                    bh = head;
                    bt = head;
                }else {
                    bt.next = head;
                    bt = head;
                }
            }else {
                if (eh == null) {
                    eh = head;
                    et = head;
                }else {
                    et.next = head;
                    et = head;
                }
            }
            head = next;
        }
        if (st != null) {
            st.next = eh;
            et = et == null ? st : et;
        }
        if (et != null) {
            et.next = bh;
        }
        return sh != null ? sh : (eh != null ? eh : bh);
    }



    @Test
    public void test() {
        ListNode node = new ListNode(7);
        node.next = new ListNode(88);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(7);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(9);
        node.next.next.next.next.next.next = new ListNode(10);
        node.next.next.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next.next.next = new ListNode(9);
        ListNode listNode = smallEqualBigger2(node, 5);
        while (listNode!=null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
