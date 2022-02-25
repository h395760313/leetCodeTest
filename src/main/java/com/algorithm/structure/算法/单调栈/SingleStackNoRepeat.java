package com.algorithm.structure.算法.单调栈;


import com.algorithm.leetCode.common.ListNode;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

/**
 * 找到数组中每一位数的左边和右边第一个比它大的数的下标 (有重复数据,使用链表存栈内重复数据)
 * |      3     |   |小
 * |      4     |   |
 * |      5     |   |
 * |      6     |   |
 * |      7     |   |
 *  \     8    /    |
 *   \    9   /     |
 *    \__10__/      |大
 *
 * @author xiehongyu
 * @date 2022/02/23 14:09
 */
public class SingleStackNoRepeat {

    public static class Bigger {
        Integer left;
        Integer right;

        public Bigger(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Bigger{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public Bigger[] singleStack(int[] arr) {
        Bigger[] res = new Bigger[arr.length];

        Stack<ListNode> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.empty()) { // 栈为空时直接压入栈
                stack.push(new ListNode(i));
            } else {// 栈不为空时
                ListNode peek = stack.peek();

                if (arr[peek.val] == arr[i]) {
                    // 如果相等，则加入链表
                    while (peek.next != null) {
                        peek = peek.next;
                    }
                    peek.next = new ListNode(i);
                    continue;
                } else if (arr[peek.val] > arr[i]) {
                    // 栈顶元素大于新增元素，新增一条新链表

                    stack.push(new ListNode(i));
                    continue;
                } else {

                    // 栈顶元素小于新增元素
                    while (!stack.empty() && arr[stack.peek().val] < arr[i]) {
                        ListNode pop = stack.pop();

                        while (pop != null) {
                            ListNode node = pop;
                            ListNode last = node;
                            while (node.next != null) {
                                if (node.next.next != null) {
                                    last = last.next;
                                }
                                node = node.next;
                            }
                            if (!stack.empty()) {
                                ListNode peek1 = stack.peek();
                                while (peek1.next != null) {
                                    peek1 = peek1.next;
                                }
                                res[node.val] = new Bigger(peek1.val, i); // 弹出元素，新加入的数为元素右边比自己更大的数，弹出后栈内如果还有元素则为左边第一个比自己大的数，否则左边大的数为空
                            } else {
                                res[node.val] = new Bigger(null, i); // 弹出元素，新加入的数为元素右边比自己更大的数，弹出后栈内如果还有元素则为左边第一个比自己大的数，否则左边大的数为空
                            }
                            if (pop.next != null) last.next = null;
                            else pop = null;
                        }
                    }
                    if (!stack.empty()) {
                        peek = stack.peek();
                        if (arr[peek.val] == arr[i]) {
                            // 如果相等，则加入链表
                            while (peek.next != null) {
                                peek = peek.next;
                            }
                            peek.next = new ListNode(i);
                            continue;
                        } else {
                            stack.push(new ListNode(i));
                        }
                    }else {
                        stack.push(new ListNode(i));
                    }
                }
            }
        }
        // 最后检查栈内还有没有数据，一一弹出
        while (!stack.empty()) {
            ListNode pop = stack.pop();
            while (pop != null) {
                ListNode node = pop;
                ListNode last = pop;
                while (node.next != null) {
                    if (node.next.next != null) {
                        last = last.next;
                    }
                    node = node.next;
                }
                if (!stack.empty()) {
                    ListNode peek1 = stack.peek();
                    while (peek1.next != null) {
                        peek1 = peek1.next;
                    }
                    res[node.val] = new Bigger(peek1.val, null); // 弹出元素，新加入的数为元素右边比自己更大的数，弹出后栈内如果还有元素则为左边第一个比自己大的数，否则左边大的数为空
                } else {
                    res[node.val] = new Bigger(null, null); // 弹出元素，新加入的数为元素右边比自己更大的数，弹出后栈内如果还有元素则为左边第一个比自己大的数，否则左边大的数为空
                }
                if (pop.next != null) last.next = null;
                else pop = null;
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(singleStack(new int[]{5, 3, 4, 2, 1, 4, 5, 6, 3, 6})));
    }


}
