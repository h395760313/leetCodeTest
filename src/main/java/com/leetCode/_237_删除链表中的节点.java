package com.leetCode;

import com.leetCode.common.ListNode;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/submissions/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _237_删除链表中的节点 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }



    @Test
    public void test() {
        System.out.println(JSON.toJSONString(null));
    }
}
