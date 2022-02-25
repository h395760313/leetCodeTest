package com.algorithm.leetCode._29_两数相除;

import java.math.BigInteger;

/**
 * https://leetcode-cn.com/problems/divide-two-integers
 * @author xiehongyu
 * @date 2022/02/22 11:33
 */
public class _29_两数相除 {
    public static int divide(int dividend, int divisor) {
        return BigInteger.valueOf(dividend).divide(BigInteger.valueOf(divisor)).intValue();
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648,-1));
    }
}
