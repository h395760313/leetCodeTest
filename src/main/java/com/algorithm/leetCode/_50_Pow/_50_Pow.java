package com.algorithm.leetCode._50_Pow;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * @author xiehongyu
 * @date 2022/02/16 16:19
 */
public class _50_Pow {

    public double myPow(double x, int n) {
        long N = n;
        if (x == 1 || N == 0) return 1;
        if (n < 0) return myPowHelper(1 / x, Math.abs(N));
        return myPowHelper(x, N);
    }

    public double myPowHelper(double x, long n) {
        if (n == 1) return x;

        if ((n & 1) == 0) {
            // 偶数
            double half = myPowHelper(x, n / 2);
            return half * half;
        }else {
            double half = myPowHelper(x, n / 2);
            return half * half * x;
        }
    }




    @Test
    public void test() {
        System.out.println(JSON.toJSONString(myPow(2.00000,-2147483648)));
    }
}
