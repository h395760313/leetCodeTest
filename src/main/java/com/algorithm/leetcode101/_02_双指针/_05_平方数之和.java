package com.algorithm.leetcode101._02_双指针;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/sum-of-square-numbers/
 * @Author: xiehongyu
 * @Date: 2022/05/30 20:34
 */
public class _05_平方数之和 {

    public boolean judgeSquareSum(int c) {

        long i = 0;
        long j = (long)Math.sqrt(c);
        while (i <= j) {
            long x = i * i;
            long y = j * j;
            if (x + y == c) {
                return true;
            }else if (x + y < c) {
                i++;
            }else {
                j--;
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(judgeSquareSum(0) + "   -------   true"); // true
        System.out.println(judgeSquareSum(1) + "   -------   true"); // true
        System.out.println(judgeSquareSum(2) + "   -------   true"); // true
        System.out.println(judgeSquareSum(3) + "   -------   false"); // false
        System.out.println(judgeSquareSum(4) + "   -------   true"); // true
        System.out.println(judgeSquareSum(5) + "   -------   true"); // true
        System.out.println(judgeSquareSum(6) + "   -------   false"); // false
        System.out.println(judgeSquareSum(7) + "   -------   false"); // false
        System.out.println(judgeSquareSum(8) + "   -------   true"); // true
        System.out.println(judgeSquareSum(9) + "   -------   true"); // true
        System.out.println(judgeSquareSum(1000000) + "   -------   true"); // true
    }
}
