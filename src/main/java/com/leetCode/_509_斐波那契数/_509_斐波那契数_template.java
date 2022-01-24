package com.leetCode._509_斐波那契数;


import com.tools.Asserts;
import com.tools.Times;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 * @Author: xiehongyu
 * @Date: 2021/7/20 09:54
 */
public class _509_斐波那契数_template {
    // 1 1 2 3 5 8 13 21
    public int fib0(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2 ) return 1;
        return fib0(n - 1) + fib0(n - 2);
    }

    int[] resArr;

    public int fib1(int n) {
        if (n <= 0) return n;
        resArr = new int[n + 1];
        resArr[1] = resArr[2] = 1;
        return res(n);
    }

    private int res(int n) {
        if (resArr[n] == 0) {
            resArr[n] = res(n - 1) + res(n - 2);
        }
        return resArr[n];
    }


    public int fib2(int n) {
        if (n <= 0) return n;
        if (n == 1 || n == 2) return 1;
        int[] arr = new int[n + 1];
        arr[1] = arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public int fib3(int n) {
        if (n <= 0) return n;
        int[] arr = new int[2];
        arr[1] = arr[0] = 1;
        int index = 2;
        while (index <= n) {
            arr[index++ % 2] = arr[0] + arr[1];
        }
        return arr[index % 2];
    }

    public int fib4(int n) {
        if (n <= 0) return n;
        int first = 1, second = 1;
        int index = 2;
        while (index < n) {
            second = first + second;
            first = second - first;
            index++;
        }
        return second;
    }

    public int fib5(int n) {
        if (n <= 0) return n;
        int[] arr = new int[2];
        arr[1] = arr[0] = 1;
        int index = 2;
        while (index <= n) {
            arr[index++ & 1] = arr[0] + arr[1];
        }
        return arr[index & 1];
    }

    public int fib(int n) {
        double c = Math.sqrt(5);
        return (int)((Math.pow((1 + c) / 2, n) - Math.pow((1 - c) / 2, n)) / c);
    }

    @Test
    public void test() {
        System.out.println(fib(10));
//        Asserts.test(fib(10) == 55);
    }
}
