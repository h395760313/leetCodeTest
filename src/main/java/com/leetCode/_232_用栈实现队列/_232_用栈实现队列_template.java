package com.leetCode._232_用栈实现队列;


import org.junit.Test;

import java.util.Stack;

/**
 * @Author: xiehongyu
 * @Date: 2021/8/5 15:35
 * 思路：如果outStack为空，将inStack所有元素逐一弹出，push到outStack，outStack弹出元素；
 *      如果outStack不为空，outStack弹出栈顶元素。
 */
public class _232_用栈实现队列_template {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
    /** Initialize your data structure here. */
    public _232_用栈实现队列_template() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        inStackToOutStack();
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }

    private void inStackToOutStack() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }


    @Test
    public void MyQueueTest(){
        _232_用栈实现队列_template v = new _232_用栈实现队列_template();
        v.push(11);
        v.push(22);
        v.push(33);
        v.pop();
        v.pop();
        v.push(44);

        while (!v.empty()) {
            System.out.println(v.pop());
        }
    }
}
