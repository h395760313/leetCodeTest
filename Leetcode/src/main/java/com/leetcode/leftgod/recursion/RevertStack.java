package com.leetcode.leftgod.recursion;

import org.junit.Test;

import java.util.Stack;

/**
 * 逆序栈
 *
 * @Author: xiehongyu
 * @Date: 2024/03/26 14:58
 */
public class RevertStack {


    public void revertStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        dp(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private int f(Stack<Integer> stack) {
        Integer pop = stack.pop();
        if (stack.isEmpty()) {
            return pop;
        }
        int top = f(stack);
        stack.push(pop);
        return top;
    }

    private void dp(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int f = f(stack);
        dp(stack);
        stack.push(f);
    }

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        revertStack(stack);

    }
}
