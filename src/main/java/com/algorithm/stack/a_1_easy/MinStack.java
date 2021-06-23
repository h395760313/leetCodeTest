package com.algorithm.stack.a_1_easy;

/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。


 push(x) —— 将元素 x 推入栈中。
 pop() —— 删除栈顶的元素。
 top() —— 获取栈顶元素。
 getMin() —— 检索栈中的最小元素。




 示例:

 输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.




 提示：


 pop、top 和 getMin 操作总是在 非空栈 上调用。

 Related Topics 栈 设计
 👍 707 👎 0
*/

import java.util.Scanner;
import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    int min = Integer.MIN_VALUE;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MinStack minStack = null;
        System.out.println("请输入MinStack/push/pop/top/getMin;\n输入quit退出");
        boolean flag = true;
        while (flag) {
            String next = scan.next();
            if ("MinStack".equals(next)) {
                minStack = new MinStack();
            } else if ("push".equals(next)) {
                System.out.println("请输入需要入栈的数");
                int num = scan.nextInt();
                minStack.push(num);
            } else if ("pop".equals(next)) {
                minStack.pop();
            } else if ("top".equals(next)) {
                System.out.println("顶部数为： " + minStack.top());
            } else if ("getMin".equals(next)) {
                System.out.println("最小数为： " + minStack.getMin());
            } else if ("quit".equals(next)) {
                flag = false;
            } else {
                System.out.println("输入错误");
            }
        }
    }

    public MinStack() {
    }

    public void push(int x) {
        min = x;
        if (min > x) {
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.lastElement();
    }

    public int getMin() {
        System.out.println(min);
        return min;
    }
}
