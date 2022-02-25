package com.algorithm.structure.算法.单调栈;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Stack;

/**
 * 找到数组中每一位数的左边和右边第一个比它大的数的下标 (无重复数据)
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
public class SingleStackRepeat {

    public static class Bigger{
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
    public Bigger[] singleStack(int[] arr){
        Bigger[] res = new Bigger[arr.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.empty()) { // 栈为空时直接压入栈
                stack.push(i);
            }else {// 栈不为空时
                // 栈顶元素大于新增元素
                if (arr[stack.peek()] > arr[i]) {
                    stack.push(i);
                    continue;
                }
                // 栈顶元素小于新增元素
                while (!stack.empty() && arr[stack.peek()] <= arr[i]) {
                    Integer pop = stack.pop();
                    res[pop] = new Bigger(stack.empty() ? null : stack.peek(), i); // 弹出元素，新加入的数为元素右边比自己更大的数，弹出后栈内如果还有元素则为左边第一个比自己大的数，否则左边大的数为空
                }
                stack.push(i);
            }
        }
        // 最后检查栈内还有没有数据，一一弹出
        while (!stack.empty()) {
            Integer pop = stack.pop();
            res[pop] = new Bigger(stack.empty() ? null : stack.peek(), null); // 弹出元素，右边为空，弹出后栈内如果还有元素则为左边第一个比自己大的数，否则左边大的数为空
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(JSON.toJSONString(singleStack(new int[]{5,3,6,2,1,7,4})));
    }


}
