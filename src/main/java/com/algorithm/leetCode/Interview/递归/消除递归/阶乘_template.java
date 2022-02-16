package com.algorithm.leetCode.Interview.递归.消除递归;


import org.junit.Test;

/**
 *
 * @author xiehongyu
 * @date 2022/1/20 14:19
 */
public class 阶乘_template {

    @Test
    public void TestFactorial(){
        System.out.println(factorial1(10));
        System.out.println(factorial2(10));
    }

    private int factorial1(int n){
        if (n == 1) return n;
        return n * factorial1(n - 1);
    }

    private int factorial2(int n) {
        return factorial2(n, 1);
    }

    private int factorial2(int n, int res) {
        if (n == 1) return res;
        return factorial2(n - 1, n * res);
    }
}
