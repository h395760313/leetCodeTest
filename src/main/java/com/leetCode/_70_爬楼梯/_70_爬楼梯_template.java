package com.leetCode._70_爬楼梯;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _70_爬楼梯_template {
    public int climbStairs0(int n) {
        if (n <= 2) return n;
        return climbStairs0(n - 1) + climbStairs0(n - 2);
    }

    public int climbStairs1(int n) {
        if (n <= 2) return n;
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(climbStairs1(4)));
    }
}
