package com.algorithm.leetCode._445_两数相加2;

import com.algorithm.leetCode.common.ListNode;
import com.algorithm.structure.inter.List;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author xiehongyu
 * @date 2022/02/25 14:07
 */
public class _445_两数相加2_template {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tail1 = reverseNode(l1);
        ListNode tail2 = reverseNode(l2);
        ListNode cur1 = tail1;
        ListNode cur2 = tail2;
        ListNode res = new ListNode();
        ListNode cur = res;
        int flag = 0;
        while (cur1 != null || cur2 != null) {
            int x = cur1 == null ? 0 : cur1.val;
            int y = cur2 == null ? 0 : cur2.val;

            int sum = x + y + flag;
            flag = sum / 10;
            cur.next = new ListNode(sum % 10);

            cur = cur.next;
            cur1 = cur1 == null ? null : cur1.next;
            cur2 = cur2 == null ? null : cur2.next;
        }

        if (flag == 1) {
            cur.next = new ListNode(1);
        }

        ListNode tailRes = reverseNode(res.next);


        return tailRes;
    }

    private ListNode reverseNode(ListNode from){
        ListNode pre = null;
        ListNode next = null;
        while (from != null) {
            next = from.next;
            from.next = pre;
            pre = from;
            from = next;
        }
        return pre;
    }


    @Test
    public void test() {
        ListNode listNode1 = new ListNode(7);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);
        listNode1.next.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        System.out.println(JSON.toJSONString(addTwoNumbers(listNode1, listNode2)));
    }
}
