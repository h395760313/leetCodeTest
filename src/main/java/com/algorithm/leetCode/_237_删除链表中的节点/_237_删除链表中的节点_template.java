package com.algorithm.leetCode._237_删除链表中的节点;

import com.alibaba.fastjson.JSON;
import com.algorithm.leetCode.common.ListNode;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/submissions/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _237_删除链表中的节点_template {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }



    @Test
    public void test() {
        System.out.println(JSON.toJSONString(null));
    }
}
