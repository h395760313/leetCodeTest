package com.leetcode.huawei;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: xiehongyu
 * @Date: 2024/06/24 16:06
 */
@Slf4j
public class _t06_直角三角形周长解法 {


    @Test
    public void test() {
        int r = 120000;
        int a = 1;

        int res = 0;
        while (a < r / 3) {
            int b = a;
            while (b < r / 2) {
                int c = r - a - b;
                if (a * a + b * b == c * c) {
                    res++;
                }
                b++;
            }
            a++;
        }
        System.out.println(res);

    }

    @Test
    public void test2() {
        int r = 120;
        int a = 1;

        int res = 0;
        while (a < r / 3) {
            for (int c = r - a - 2; c > r / 2; c--) {
                double b = Math.sqrt(c * c - a * a);
                if (b == (int) b) {
                    res++;
                }
            }
            a++;
        }
        System.out.println(res);

    }
}
