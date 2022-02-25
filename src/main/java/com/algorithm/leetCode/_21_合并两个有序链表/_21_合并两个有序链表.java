package com.algorithm.leetCode._21_合并两个有序链表;

import com.algorithm.leetCode.common.ListNode;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author xiehongyu
 * @date 2022/02/22 09:54
 */
public class _21_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode curr = res;

        while (list1 != null || list2 != null) {
            int x = list1 == null ? Integer.MAX_VALUE : list1.val;
            int y = list2 == null ? Integer.MAX_VALUE : list2.val;

            if (x <= y) {
                curr.next = new ListNode(list1.val);
                list1 = list1.next;
            }else {
                curr.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            curr = curr.next;
        }
        return res.next;
    }

    @Test
    public void test() {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        System.out.println(JSON.toJSONString(mergeTwoLists(listNode1, listNode2)));
    }
}
